package org.example.controller;

import org.example.model.Program;
import org.example.service.IProgramService;
import org.example.service.ProgramServiceImpl;

public class ProgramServiceController {

    private final IProgramService programService;

    public ProgramServiceController() {
        this.programService = new ProgramServiceImpl();
    }

    public void addProgram(Program program) {
        programService.addProgram(program);
        System.out.println("Program added: " + program.getProgramName());
    }

    public void displayAllPrograms() {
        System.out.println("=== All Programs ===");
        programService.displayAllProgram();
    }

    public void updateProgram(int index, String programId, String programName) {
        programService.updateProgram(index, programId, programName);
        System.out.println("Program updated at index: " + index);
    }

    public void removeProgram(int index) {
        programService.removeProgram(index);
        System.out.println("Program removed at index: " + index);
    }

}

