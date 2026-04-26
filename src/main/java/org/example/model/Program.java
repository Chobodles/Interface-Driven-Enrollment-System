package org.example.model;

import java.util.List;

public class Program {
    private int programIndex;
    private String programId;
    private String programName;
    private final List<Section> sectionList;

    public Program(int programIndex, String programId, String programName, List<Section> sectionList){
        this.programIndex = programIndex;
        this.programId = programId;
        this.programName = programName;
        this.sectionList = sectionList;
    }

    public List<Section> getSectionList() {
        return sectionList;
    }

    public int getProgramIndex() {
        return programIndex;
    }

    public void setProgramIndex(int programIndex) {
        this.programIndex = programIndex;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public List<Section> display(){
        System.out.printf("Index: [%d] | Program ID: %s | Program: %s %n", programIndex, programId, programName);
        return sectionList.stream().toList();
    }

    @Override
    public String toString() {
        return "Program{" +
                "programIndex=" + programIndex +
                ", programId='" + programId + '\'' +
                ", programName='" + programName + '\'' +
                '}';
    }
}
