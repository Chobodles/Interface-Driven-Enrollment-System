package org.example.model;

import java.util.List;

public class Loading {
    private int loadingIndex;
    private Instructor instructor;
    private Course course;
    private List<Student> studentList;

    public int getLoadingIndex() {
        return loadingIndex;
    }

    public void setLoadingIndex(int loadingIndex) {
        this.loadingIndex = loadingIndex;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Loading{" +
                "loadingIndex=" + loadingIndex +
                ", instructor=" + instructor +
                ", course=" + course +
                ", studentList=" + studentList +
                '}';
    }
}
