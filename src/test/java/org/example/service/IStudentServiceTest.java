package org.example.service;

import org.example.model.Student;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class IStudentServiceTest {

    private IStudentService studentService;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setup() {
        studentService = new StudentServiceImpl();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void shouldAddStudentAndDisplayIt() {
        studentService.addStudent(new Student(1, "S001", "Alice"));
        studentService.displayAllStudent();
        assertTrue(outContent.toString().contains("Alice"));
    }

    @Test
    void shouldAddMultipleStudents() {
        studentService.addStudent(new Student(1, "S001", "Alice"));
        studentService.addStudent(new Student(2, "S002", "Bob"));
        studentService.displayAllStudent();
        String output = outContent.toString();
        assertTrue(output.contains("Alice"));
        assertTrue(output.contains("Bob"));
    }


    @Test
    void shouldDisplayStudentIdAndName() {
        studentService.addStudent(new Student(1, "S001", "Alice"));
        studentService.displayAllStudent();
        String output = outContent.toString();
        assertTrue(output.contains("S001"));
        assertTrue(output.contains("Alice"));
    }

    @Test
    void shouldUpdateStudentName() {
        studentService.addStudent(new Student(1, "S001", "Alice"));
        studentService.updateStudent(1, "S001", "Alice Updated");
        studentService.displayAllStudent();
        assertTrue(outContent.toString().contains("Alice Updated"));
    }

    @Test
    void shouldRemoveStudentByIndex() {
        studentService.addStudent(new Student(1, "S001", "Alice"));
        studentService.removeStudent(1);
        studentService.displayAllStudent();
        assertFalse(outContent.toString().contains("Alice"));
    }

}