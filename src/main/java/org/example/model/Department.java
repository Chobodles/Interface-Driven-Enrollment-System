package org.example.model;

import java.util.List;

public class Department {
    private int departmentIndex;
    private String departmentId;
    private String departmentName;
    private List<Instructor> instructorList;
    private List<Program> programList;

    public Department(int departmentIndex,String departmentId, String departmentName, List<Instructor> instructorList, List<Program> programList){
        this.departmentIndex = departmentIndex;
        this.departmentId = departmentId;
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
        return departmentId;
    }

    public void setId(String departmentId) {
        this.departmentId = departmentId;
    }

    public List<Instructor> getInstructorList() {
        return instructorList;
    }

    public void setInstructorList(List<Instructor> instructorList) {
        this.instructorList = instructorList;
    }

    public List<Program> display(){
        System.out.printf("Index: [%d] | Department ID: %s | Department Name: %s %n", departmentIndex, departmentId, departmentName);
        return programList.stream().toList();
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentIndex=" + departmentIndex +
                ", departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", instructorList=" + instructorList +
                ", programList=" + programList +
                '}';
    }
}
