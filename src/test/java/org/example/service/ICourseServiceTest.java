package org.example.service;

import org.example.model.Course;
import org.example.model.Program;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ICourseServiceTest {

    private ICourseService courseService;
    private Program sampleProgram;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setup() {
        courseService = new CourseServiceImpl();
        sampleProgram = new Program(1, "P001", "Computer Science", new ArrayList<>(), new ArrayList<>());
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void shouldAddCourseAndDisplayIt() {
        courseService.addCourse(new Course(1, "CS101", "Intro to Programming", sampleProgram));
        courseService.displayAllCourse();
        assertTrue(outContent.toString().contains("Intro to Programming"));
    }

    @Test
    void shouldDisplayCourseIdAndName() {
        courseService.addCourse(new Course(1, "CS101", "Intro to Programming", sampleProgram));
        courseService.displayAllCourse();
        String output = outContent.toString();
        assertTrue(output.contains("CS101"));
        assertTrue(output.contains("Intro to Programming"));
    }

    @Test
    void shouldUpdateCourseName() {
        courseService.addCourse(new Course(1, "CS101", "Intro to Programming", sampleProgram));
        courseService.updateCourse(1, "CS101", "Advanced Programming", sampleProgram);
        courseService.displayAllCourse();
        assertTrue(outContent.toString().contains("Advanced Programming"));
    }

    @Test
    void shouldOnlyRemoveTargetedCourse() {
        courseService.addCourse(new Course(1, "CS101", "Intro to Programming", sampleProgram));
        courseService.addCourse(new Course(2, "CS102", "Data Structures", sampleProgram));
        courseService.removeCourse(1);
        courseService.displayAllCourse();
        String output = outContent.toString();
        assertFalse(output.contains("Intro to Programming"));
        assertTrue(output.contains("Data Structures"));
    }
}