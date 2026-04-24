package org.example.model;

public class Student extends Person {
    public Student(int index, String id, String name, String program) {
        super.setIndex(index);
        super.setId(id);
        super.setName(name);
    }

    public void display(){
        System.out.println("Student ID: " + super.getId());
        System.out.println("Student Name: " + super.getName());
        System.out.println();
    }

    @Override
    public void mainTask(){
        System.out.println("Student Studies");
    }

}
