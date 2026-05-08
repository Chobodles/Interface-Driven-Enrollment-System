package org.example.service;

import org.example.model.Program;
import org.example.model.Section;

import java.util.ArrayList;
import java.util.List;

public class ProgramServiceImpl implements IProgramService {
    private final List<Program> programList = new ArrayList<>();

    public void addProgram(Program program) {
        programList.add(program);
    }

    public void displayAllProgram() {
        for (Program program : programList) {
            List<Section> sections = program.display();
            for (Section section : sections) {
                section.display();
            }
        }
    }

    public void updateProgram(int index, String programId, String programName) {
        for (int i = 0; i < programList.size(); i++) {
            if (programList.get(i).getProgramIndex() == index) {
                programList.set(i, new Program(
                        index,
                        programId,
                        programName,
                        programList.get(i).getCourseList(),
                        programList.get(i).getSectionList()
                ));
                break;
            }
        }
    }

    public void removeProgram(int index) {
        for (int i = 0; i < programList.size(); i++) {
            if (programList.get(i).getProgramIndex() == index) {
                programList.remove(i);
                break;
            }
        }
    }
}