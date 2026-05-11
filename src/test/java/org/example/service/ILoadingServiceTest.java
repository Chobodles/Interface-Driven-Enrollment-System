package org.example.service;

import org.example.exception.LoadFullException;
import org.example.model.*;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ILoadingServiceTest {

    private ILoadingService loadingService;
    private Instructor sampleInstructor;
    private Course sampleCourse;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private Loading buildLoading(int index) {
        return new Loading(index, sampleInstructor, sampleCourse, new ArrayList<>());
    }

    @BeforeEach
    void setup() {
        loadingService = new LoadingServiceImpl();
        Program program = new Program(1, "P001", "Computer Science", new ArrayList<>(), new ArrayList<>());
        sampleInstructor = new Instructor(1, "I001", "Dr. Strange");
        sampleCourse = new Course(1, "CS101", "Intro to Programming", program);
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void teardown() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("addLoading: added loading appears in display output")
    void shouldAddLoadingAndDisplayIt() {
        loadingService.addLoading(buildLoading(1));
        loadingService.displayAllLoading();
        assertTrue(outContent.toString().contains("Intro to Programming"));
    }

    @Test
    @DisplayName("displayAllLoading: output contains instructor and course info")
    void shouldDisplayInstructorAndCourse() {
        loadingService.addLoading(buildLoading(1));
        loadingService.displayAllLoading();
        String output = outContent.toString();
        assertTrue(output.contains("Dr. Strange"));
        assertTrue(output.contains("Intro to Programming"));
    }

    @Test
    @DisplayName("updateLoading: instructor is replaced after update")
    void shouldUpdateInstructor() {
        loadingService.addLoading(buildLoading(1));
        Instructor newInstructor = new Instructor(2, "I002", "Prof. Jones");
        loadingService.updateLoading(1, newInstructor, sampleCourse);
        loadingService.displayAllLoading();
        assertTrue(outContent.toString().contains("Prof. Jones"));
    }

    @Test
    @DisplayName("removeLoading: removed loading no longer appears in display")
    void shouldRemoveLoadingByIndex() {
        loadingService.addLoading(buildLoading(1));
        loadingService.removeLoading(1);
        loadingService.displayAllLoading();
        assertEquals("", outContent.toString());
    }

    @Test
    @DisplayName("enrollStudent: enrolled student appears in the loading's student list")
    void shouldEnrollStudentSuccessfully() throws LoadFullException {
        loadingService.addLoading(buildLoading(1));
        Student student = new Student(1, "STU01", "Alice");
        loadingService.enrollStudent(1, student);
        loadingService.displayAllLoading();
        assertTrue(outContent.toString().contains("Alice"));
    }

    @Test
    @DisplayName("enrollStudent: enrolling to a full loading throws LoadFullException")
    void shouldThrowWhenLoadingIsFull() throws LoadFullException {
        Loading loading = buildLoading(1);
        loadingService.addLoading(loading);

        // fill to max capacity (30)
        for (int i = 1; i <= 30; i++) {
            loadingService.enrollStudent(1, new Student(i, "S" + i, "Student" + i));
        }

        Student extraStudent = new Student(31, "S031", "Overflow");
        assertThrows(LoadFullException.class, () -> loadingService.enrollStudent(1, extraStudent));
    }

    @Test
    @DisplayName("enrollStudent: enrolling up to max capacity does not throw")
    void shouldNotThrowWhenAtMaxCapacity() throws LoadFullException {
        loadingService.addLoading(buildLoading(1));
        for (int i = 1; i <= 30; i++) {
            loadingService.enrollStudent(1, new Student(i, "S" + i, "Student" + i));
        }
    }

    @Test
    @DisplayName("removeStudent: removed student no longer appears in the loading")
    void shouldRemoveStudentFromLoading() throws LoadFullException {
        loadingService.addLoading(buildLoading(1));
        Student student = new Student(1, "STU01", "Alice");
        loadingService.enrollStudent(1, student);
        loadingService.removeStudent(1, 1);
        loadingService.displayAllLoading();
        assertFalse(outContent.toString().contains("Alice"));
    }

}