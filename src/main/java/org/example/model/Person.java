package org.example.model;

public abstract class Person {
    private String id;
    private String name;

    public String getID() { return id; };
    public void setID(String ID){
        this.id = ID;
    };
    public String getName(){
        return name;
    };
    public void setName(String name) {
        this.name = name;
    };
    public abstract void mainTask();

    @Override
    public String toString() {
        return "Person{" +
                "ID='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
