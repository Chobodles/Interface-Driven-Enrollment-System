package org.example.service;

import org.example.model.Section;

public interface ISectionService {
    void addSection(Section section);
    void displayAllSection();
    void updateSection(int index, String sectionName, int yearLevel);
    void removeSection(int index);
}