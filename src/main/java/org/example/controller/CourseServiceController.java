package org.example.controller;

import org.example.model.Course;
import org.example.model.Program;
import org.example.service.CourseServiceImpl;
import org.example.service.ICourseService;

public class CourseServiceController {
    private final ICourseService courseService;

    public CourseServiceController() {
        this.courseService = new CourseServiceImpl();
    }

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
