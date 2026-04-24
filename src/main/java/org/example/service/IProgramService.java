package org.example.service;

import org.example.model.Program;

public interface IProgramService {
    void addProgram(Program program);
    void displayAllProgram();
    void updateProgram(Program program);
    void removeProgram(Program program);
}