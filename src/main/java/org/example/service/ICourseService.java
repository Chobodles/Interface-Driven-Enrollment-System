package org.example.service;

import org.example.model.Course;

public interface ICourseService {
    void addCourse(Course course);
    void displayAllCourse();
    void updateCourse(int index);
    void removeCourse(int index);
}
