package org.example.service;

import org.example.model.Program;

public interface IProgramService {
    void addProgram(Program program);
    void displayAllProgram();
    void updateProgram(int index, String programId, String programName);
    void removeProgram(int index);
}