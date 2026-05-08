package org.example.service;

import org.example.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements IStudentService {
    private final List<Student> studentList = new ArrayList<>();

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void displayAllStudent() {
        for (Student student : studentList) {
            student.display();
        }
    }

    public void updateStudent(int index, String id, String name) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getIndex() == index) {
                studentList.set(i, new Student(index, id, name));
                break;
            }
        }
    }

    public void removeStudent(int index) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getIndex() == index) {
                studentList.remove(i);
                break;
            }
        }
    }
}