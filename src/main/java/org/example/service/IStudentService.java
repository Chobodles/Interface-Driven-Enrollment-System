package org.example.service;

import org.example.model.Student;

public interface IStudentService {
    void addStudent(Student student);
    void displayAllStudent();
    void updateStudent(int index);
    void removeStudent(Student student);
}
