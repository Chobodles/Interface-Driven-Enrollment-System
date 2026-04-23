package org.example.model;

public abstract class Person {
    private int index;
    private String id;
    private String name;

    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public String getId() { return id; };
    public void setId(String ID){
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
                "index=" + index +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
