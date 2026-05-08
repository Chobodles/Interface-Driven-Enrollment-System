package org.example.model;

import java.util.List;

public class Instructor extends Person{

    public Instructor(int index, String ID, String name) {
        super.setIndex(index);
        super.setId(ID);
        super.setName(name);
    }

    public void mainTask(){
        System.out.println("Instructor Grades");
    }

    public void display() {
        System.out.printf("Index: [%d] | Instructor ID: %s | Instructor Name: %s %n",
                super.getIndex(), super.getId(), super.getName());
    }

    @Override
    public String toString() {
        return "Instructor{}";
    }
}

