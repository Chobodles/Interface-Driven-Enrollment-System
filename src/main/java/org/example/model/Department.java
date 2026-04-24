package org.example.model;

import java.util.List;

public class Department {
    private int departmentIndex;
    private String id;
    private String departmentName;
    private List<Instructor> instructorList;
    private List<Program> programList;

    public Department(int departmentIndex,String id, String departmentName, List<Instructor> instructorList, List<Program> programList){
        this.departmentIndex = departmentIndex;
        this.id = id;
        this.departmentName = departmentName;
        this.instructorList = instructorList;
        this.programList = programList;
    }

    public List<Program> getProgramList() {
        return programList;
    }

    public void setProgramList(List<Program> programList) {
        this.programList = programList;
    }

    public int getDepartmentIndex() {
        return departmentIndex;
    }

    public void setDepartmentIndex(int departmentIndex) {
        this.departmentIndex = departmentIndex;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Instructor> getInstructorList() {
        return instructorList;
    }

    public void setInstructorList(List<Instructor> instructorList) {
        this.instructorList = instructorList;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentIndex=" + departmentIndex +
                ", id='" + id + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", instructorList=" + instructorList +
                ", programList=" + programList +
                '}';
    }
}
