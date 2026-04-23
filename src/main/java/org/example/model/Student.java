package org.example.model;

public class Student extends Person {
    private String program;

    public Student(int index, String id, String name, String program) {
        super.setIndex(index);
        super.setId(id);
        super.setName(name);
        this.program = program;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public void display(){
        System.out.println("Student ID: " + super.getId());
        System.out.println("Student Name: " + super.getName());
        System.out.println("Program: " + getProgram());
        System.out.println();
    }

    @Override
    public void mainTask(){
        System.out.println("Student Studies");
    }

    @Override
    public String toString() {
        return "Student{" +
                "program='" + program + '\'' +
                '}';
    }
}
