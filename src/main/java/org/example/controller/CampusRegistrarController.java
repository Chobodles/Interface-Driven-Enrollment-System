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

    //instructor

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

    //course

    public void addCourse(int index, String courseId, String courseName, Program program) {
        courseService.addCourse(new Course(index, courseId, courseName, program));
        System.out.println("Course added: " + courseName);
    }

    public void displayAllCourses() {
        System.out.println("=== All Courses ===");
        courseService.displayAllCourse();
    }

    public void updateCourse(int index, String courseId, String courseName, Program program) {
        courseService.updateCourse(index, courseId, courseName, program);
        System.out.println("Course updated at index: " + index);
    }

    public void removeCourse(int index) {
        courseService.removeCourse(index);
        System.out.println("Course removed at index: " + index);
    }

}
