package org.example.model;

import java.util.List;

public class Section {
    private int sectionIndex;
    private String sectionName;
    private int yearLevel;
    private List<Loading> loadingList;

    public Section(int sectionIndex, String sectionName, int yearLevel, List<Loading> loadingList) {
        this.sectionIndex = sectionIndex;
        this.sectionName = sectionName;
        this.yearLevel = yearLevel;
        this.loadingList = loadingList;
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

    public List<Loading> getLoadingList() {
        return loadingList;
    }

    public void setLoadingList(List<Loading> loadingList) {
        this.loadingList = loadingList;
    }

    public List<Loading> display() {
        System.out.printf("Index: [%d] | Section: %s | Year: %d %n", sectionIndex, sectionName, yearLevel);
        return loadingList.stream().toList();
    }

    @Override
    public String toString() {
        return "Section{" +
                "sectionIndex=" + sectionIndex +
                ", sectionName='" + sectionName + '\'' +
                ", yearLevel=" + yearLevel +
                ", loadingList=" + loadingList +
                '}';
    }
}