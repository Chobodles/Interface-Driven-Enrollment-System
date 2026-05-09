package org.example.controller;

import org.example.model.Student;
import org.example.service.IStudentService;

public class StudentServiceController {
    private final IStudentService studentService;

    public StudentServiceController(IStudentService studentService) {
        this.studentService = studentService;
    }

    public void addStudent(int index, String id, String name) {
        studentService.addStudent(new Student(index, id, name));
        System.out.println("Student added: " + name);
    }

    public void displayAllStudents() {
        System.out.println("=== All Students ===");
        studentService.displayAllStudent();
    }

    public void updateStudent(int index, String id, String name) {
        studentService.updateStudent(index, id, name);
        System.out.println("Student updated at index: " + index);
    }

    public void removeStudent(int index) {
        studentService.removeStudent(index);
        System.out.println("Student removed at index: " + index);
    }
}
