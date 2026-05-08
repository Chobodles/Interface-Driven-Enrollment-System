package org.example.service;

import org.example.model.Course;
import org.example.model.Instructor;

import java.util.ArrayList;
import java.util.List;

public class InstructorServiceImpl implements IInstructorService {
    private final List<Instructor> instructorList = new ArrayList<>();

    public void addInstructor(Instructor instructor) {
        instructorList.add(instructor);
    }

    public void displayAllInstructor() {
        for (Instructor instructor : instructorList) {
            instructor.display();
        }
    }

    public void updateInstructor(int index, String id, String name) {
        for (int i = 0; i < instructorList.size(); i++) {
            if (instructorList.get(i).getIndex() == index) {
                instructorList.set(i, new Instructor(index, id, name));
                break;
            }
        }
    }

    public void removeInstructor(int index) {
        for (int i = 0; i < instructorList.size(); i++) {
            if (instructorList.get(i).getIndex() == index) {
                instructorList.remove(i);
                break;
            }
        }
    }
}