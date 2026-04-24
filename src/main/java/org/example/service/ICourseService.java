package org.example.service;

import org.example.model.Course;

public interface ICourseService {
    void addCourse(Course course);
    void displayAllCourse();
    void updateCourse(Course course);
    void removeCourse(Course course);
}
