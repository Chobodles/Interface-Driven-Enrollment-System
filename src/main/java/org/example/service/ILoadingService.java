package org.example.service;

import org.example.model.Loading;
import org.example.model.Student;

public interface ILoadingService {
    void addLoading(Loading loading);
    void displayAllLoading();
    void updateLoading(int index, int instructorIndex, int courseIndex);
    void removeLoading(int index);
    void enrollStudent(int loadingIndex, Student student);
    void removeStudent(int loadingIndex, int studentIndex);
}