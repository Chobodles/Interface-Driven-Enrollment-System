package org.example.service;

import org.example.model.Program;
import org.example.model.Section;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProgramServiceImpl implements IProgramService {
    private final Scanner scanner = new Scanner(System.in);
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

    public void updateProgram(Program program) {
        for (int i = 0; i < programList.size(); i++) {
            if (programList.get(i).getProgramIndex() == program.getProgramIndex()) {
                System.out.println("Enter Program ID: ");
                String programId = scanner.nextLine();

                System.out.println("Enter Program Name: ");
                String programName = scanner.nextLine();

                programList.set(i, new Program(
                        program.getProgramIndex(),
                        programId,
                        programName,
                        programList.get(i).getSectionList()
                ));
                break;
            }
        }
    }

    public void removeProgram(Program program) {
        for (int i = 0; i < programList.size(); i++) {
            if (programList.get(i).getProgramIndex() == program.getProgramIndex()) {
                programList.remove(i);
                break;
            }
        }
    }
}