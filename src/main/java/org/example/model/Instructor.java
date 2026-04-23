package org.example.model;

import java.util.List;

public class Instructor extends Person{
    private final List<Course> courseList;

    public Instructor(int index, String ID, String name, List<Course> courseList) {
        super.setIndex(index);
        super.setId(ID);
        super.setName(name);
        this.courseList = courseList;
    }

    public void mainTask(){
        System.out.println("Instructor Grades");
    }

    public List<Course> displayCourse(){
        return courseList.stream().toList();
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "courseList=" + courseList +
                '}';
    }
}

