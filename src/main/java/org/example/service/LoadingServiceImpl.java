package org.example.service;


import org.example.exception.LoadFullException;
import org.example.model.Course;
import org.example.model.Instructor;
import org.example.model.Loading;
import org.example.model.Student;

import java.util.ArrayList;
import java.util.List;

public class LoadingServiceImpl implements ILoadingService {
    private final List<Loading> loadingList = new ArrayList<>();

    public void addLoading(Loading loading) {
        loadingList.add(loading);
    }

    public void displayAllLoading() {
        for (Loading loading : loadingList) {
            loading.display();
        }
    }

    public void updateLoading(int index, Instructor instructor, Course course) {
        for (int i = 0; i < loadingList.size(); i++) {
            if (loadingList.get(i).getLoadingIndex() == index) {
                loadingList.set(i, new Loading(
                        index,
                        instructor,
                        course,
                        loadingList.get(i).getStudentList()
                ));
                break;
            }
        }
    }

    public void removeLoading(int index) {
        for (int i = 0; i < loadingList.size(); i++) {
            if (loadingList.get(i).getLoadingIndex() == index) {
                loadingList.remove(i);
                break;
            }
        }
    }

    public void enrollStudent(int loadingIndex, Student student) throws LoadFullException{
        for (Loading loading : loadingList) {
            if (loading.getLoadingIndex() == loadingIndex) {
                if (loading.getStudentList().size() >= loading.getMaxCapacity()) {
                    throw new LoadFullException("Enrollment failed: Section with " + loading.getCourse().getCourseName() + " is currently full.");
                }

                loading.getStudentList().add(student);
                break;
            }
        }
    }

    public void removeStudent(int loadingIndex, int studentIndex) {
        for (Loading loading : loadingList) {
            if (loading.getLoadingIndex() == loadingIndex) {
                List<Student> students = loading.getStudentList();
                for (int i = 0; i < students.size(); i++) {
                    if (students.get(i).getIndex() == studentIndex) {
                        students.remove(i);
                        break;
                    }
                }
                break;
            }
        }
    }
}