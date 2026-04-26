package org.example.model;

public class Section {
    private int sectionIndex;
    private String sectionName;
    private int yearLevel;


    public Section (int sectionIndex, String sectionName, int yearLevel){
        this.sectionIndex = sectionIndex;
        this.sectionName = sectionName;
        this.yearLevel = yearLevel;
    }
    public int getSectionIndex() {
        return sectionIndex;
    }

    public void setSectionIndex(int sectionIndex) {
        this.sectionIndex = sectionIndex;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public int getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(int yearLevel) {
        this.yearLevel = yearLevel;
    }

    public void display(){
        System.out.printf("Index: [%d] | Section: %s | Year: %d %n", sectionIndex, sectionName, yearLevel);
    }

    @Override
    public String toString() {
        return "Section{" +
                "sectionIndex=" + sectionIndex +
                ", sectionName='" + sectionName + '\'' +
                ", yearLevel=" + yearLevel +
                '}';
    }
}
