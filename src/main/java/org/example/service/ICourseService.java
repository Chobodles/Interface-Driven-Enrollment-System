package org.example.service;

import org.example.model.Course;
import org.example.model.Program;

public interface ICourseService {
    void addCourse(Course course);
    void displayAllCourse();
    void updateCourse(int index, String courseId, String courseName, Program program);
    void removeCourse(int index);
}