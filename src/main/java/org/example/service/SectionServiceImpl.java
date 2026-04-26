package org.example.service;

import org.example.model.Section;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SectionServiceImpl implements ISectionService{
    private final Scanner scanner = new Scanner(System.in);
    private final List<Section> sectionList = new ArrayList<>();

    public void addSection(Section section){
        sectionList.add(section);
    }

    public void displayAllSection(){
        for (Section section : sectionList) {
            section.display();
        }
    }

    public void updateSection(int index){
        for (int i = 0; i < sectionList.size(); i++){
            if(sectionList.get(i).getSectionIndex() == index) {
                System.out.println("Enter Section Name: ");
                String sectionName= scanner.nextLine();

                System.out.println("Enter Year Level: ");
                int yearlevel = Integer.parseInt(scanner.nextLine());

                sectionList.set(i, new Section(index, sectionName, yearlevel));
                break;
            }
        }
    }

    public void removeSection(int index){
        for (int i = 0; i < sectionList.size(); i++){
            if(sectionList.get(i).getSectionIndex() == index){
                sectionList.remove(i);
                break;
            }
        }
    }

}
