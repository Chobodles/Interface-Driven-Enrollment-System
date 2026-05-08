package org.example.model;

public class Course {
    private int courseIndex;
    private String courseId;
    private String courseName;
    private Program program;

    public Course(int courseIndex, String courseId, String courseName, Program program) {
        this.courseIndex = courseIndex;
        this.courseId = courseId;
        this.courseName = courseName;
        this.program = program;
    }

    public int getCourseIndex() {
        return courseIndex;
    }

    public void setCourseIndex(int courseIndex) {
        this.courseIndex = courseIndex;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public void display() {
        System.out.println("Course ID: " + getCourseId());
        System.out.println("Course Name: " + getCourseName());
        System.out.println("Program: " + program.getProgramName());
        System.out.println();
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseIndex=" + courseIndex +
                ", courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", program=" + program.getProgramName() +
                '}';
    }
}