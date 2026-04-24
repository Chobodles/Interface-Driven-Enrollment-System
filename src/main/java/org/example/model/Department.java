package org.example.model;

import java.util.List;

public class Department {
    private int departmentIndex;
    private String id;
    private String departmentName;
    private List<Instructor> instructorList;

    public Department(int departmentIndex,String id, String departmentName, List<Instructor> instructorList){
        this.departmentIndex = departmentIndex;
        this.id = id;
        this.departmentName = departmentName;
        this.instructorList = instructorList;
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
                '}';
    }
}
