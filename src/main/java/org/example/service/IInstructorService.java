package org.example.service;

import org.example.model.Instructor;

public interface IInstructorService {
    void addInstructor(Instructor instructor);
    void displayAllInstructor();
    void updateInstructor(int index, String id, String name);
    void removeInstructor(int index);
}