package org.example.model;

import java.util.List;

public class Program {
    private int programIndex;
    private String programId;
    private String programName;
    private List<Course> courseList;
    private List<Section> sectionList;

    public Program(int programIndex, String programId, String programName, List<Course> courseList, List<Section> sectionList) {
        this.programIndex = programIndex;
        this.programId = programId;
        this.programName = programName;
        this.courseList = courseList;
        this.sectionList = sectionList;
    }

    public int getProgramIndex() {
        return programIndex;
    }

    public void setProgramIndex(int programIndex) {
        this.programIndex = programIndex;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public List<Section> getSectionList() {
        return sectionList;
    }

    public void setSectionList(List<Section> sectionList) {
        this.sectionList = sectionList;
    }

    public List<Section> display() {
        System.out.printf("Index: [%d] | Program ID: %s | Program: %s %n", programIndex, programId, programName);
        return sectionList.stream().toList();
    }

    @Override
    public String toString() {
        return "Program{" +
                "programIndex=" + programIndex +
                ", programId='" + programId + '\'' +
                ", programName='" + programName + '\'' +
                ", courseList=" + courseList +
                ", sectionList=" + sectionList +
                '}';
    }
}