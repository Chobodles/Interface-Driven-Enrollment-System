package org.example.service;

import org.example.model.Instructor;

public interface IInstructorService {
    void addInstructor(Instructor instructor);
//    void getInstructorDetails();
//    void assignInstructorToSection(Instructor instructor);
    void displayAllInstructor();
    void updateInstructor(int index);
    void removeInstructor(int index);
}
