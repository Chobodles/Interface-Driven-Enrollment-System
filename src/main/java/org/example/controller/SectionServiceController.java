package org.example.controller;

import org.example.model.Section;
import org.example.service.ISectionService;
import org.example.service.SectionServiceImpl;

public class SectionServiceController {

    private final ISectionService sectionService;

    public SectionServiceController() {
        this.sectionService = new SectionServiceImpl();
    }

    public void addSection(Section section) {
        sectionService.addSection(section);
        System.out.println("Section added: " + section.getSectionName());
    }

    public void displayAllSections() {
        System.out.println("=== All Sections ===");
        sectionService.displayAllSection();
    }

    public void updateSection(int index, String sectionName, int yearLevel) {
        sectionService.updateSection(index, sectionName, yearLevel);
        System.out.println("Section updated at index: " + index);
    }

    public void removeSection(int index) {
        sectionService.removeSection(index);
        System.out.println("Section removed at index: " + index);
    }
}
