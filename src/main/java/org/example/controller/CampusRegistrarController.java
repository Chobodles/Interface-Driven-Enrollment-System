package org.example.controller;

import org.example.model.*;
import org.example.service.*;

public class CampusRegistrarController {

    private final IStudentService studentService;
    private final IInstructorService instructorService;
    private final ICourseService courseService;
    private final IProgramService programService;
    private final ISectionService sectionService;
    private final ILoadingService loadingService;
    private final IDepartmentService departmentService;

    public CampusRegistrarController(
            IStudentService studentService,
            IInstructorService instructorService,
            ICourseService courseService,
            IProgramService programService,
            ISectionService sectionService,
            ILoadingService loadingService,
            IDepartmentService departmentService
    ) {
        this.studentService = studentService;
        this.instructorService = instructorService;
        this.courseService = courseService;
        this.programService = programService;
        this.sectionService = sectionService;
        this.loadingService = loadingService;
        this.departmentService = departmentService;
    }

    //student

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
