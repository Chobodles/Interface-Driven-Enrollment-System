package org.example.service;

import org.example.model.Section;

import java.util.ArrayList;
import java.util.List;

public class SectionServiceImpl implements ISectionService {
    private final List<Section> sectionList = new ArrayList<>();

    public void addSection(Section section) {
        sectionList.add(section);
    }

    public void displayAllSection() {
        for (Section section : sectionList) {
            section.display().forEach(loading -> loading.display());
        }
    }

    public void updateSection(int index, String sectionName, int yearLevel) {
        for (int i = 0; i < sectionList.size(); i++) {
            if (sectionList.get(i).getSectionIndex() == index) {
                sectionList.set(i, new Section(index, sectionName, yearLevel, sectionList.get(i).getLoadingList()));
                break;
            }
        }
    }

    public void removeSection(int index) {
        for (int i = 0; i < sectionList.size(); i++) {
            if (sectionList.get(i).getSectionIndex() == index) {
                sectionList.remove(i);
                break;
            }
        }
    }
}