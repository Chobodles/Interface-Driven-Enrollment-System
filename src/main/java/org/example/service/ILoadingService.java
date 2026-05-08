package org.example.service;

import org.example.model.Course;
import org.example.model.Instructor;
import org.example.model.Loading;
import org.example.model.Student;

public interface ILoadingService {
    void addLoading(Loading loading);
    void displayAllLoading();
    void updateLoading(int index, Instructor instructor, Course course);
    void removeLoading(int index);
    void enrollStudent(int loadingIndex, Student student);
    void removeStudent(int loadingIndex, int studentIndex);
}