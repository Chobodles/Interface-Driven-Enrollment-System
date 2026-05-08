package org.example.model;

public class Student extends Person {
    private Tuition tuition;

    public Student(int index, String id, String name) {
        super.setIndex(index);
        super.setId(id);
        super.setName(name);
    }

    public Tuition getTuition() {
        return tuition;
    }

    public void setTuition(Tuition tuition) {
        this.tuition = tuition;
    }

    public void display(){
        System.out.printf("Index: [%d] | Student ID: %s | Student Name: %s %n", super.getIndex(), super.getId(), super.getName());
    }

    @Override
    public void mainTask(){
        System.out.println("Student Studies");
    }

}
