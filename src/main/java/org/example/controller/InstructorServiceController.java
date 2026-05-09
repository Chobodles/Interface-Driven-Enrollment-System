package org.example.controller;

import org.example.model.Instructor;
import org.example.service.IInstructorService;
import org.example.service.InstructorServiceImpl;

public class InstructorServiceController {
    private final IInstructorService instructorService;

    public InstructorServiceController() {
        this.instructorService = new InstructorServiceImpl();
    }

    public void addInstructor(int index, String id, String name) {
        instructorService.addInstructor(new Instructor(index, id, name));
        System.out.println("Instructor added: " + name);
    }

    public void displayAllInstructors() {
        System.out.println("=== All Instructors ===");
        instructorService.displayAllInstructor();
    }

    public void updateInstructor(int index, String id, String name) {
        instructorService.updateInstructor(index, id, name);
        System.out.println("Instructor updated at index: " + index);
    }

    public void removeInstructor(int index) {
        instructorService.removeInstructor(index);
        System.out.println("Instructor removed at index: " + index);
    }
}
