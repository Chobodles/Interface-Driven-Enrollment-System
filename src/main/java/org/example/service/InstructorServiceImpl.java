package org.example.service;

import org.example.model.Instructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InstructorServiceImpl implements IInstructorService{

    private final Scanner scanner = new Scanner(System.in);
    private final List<Instructor> instructorList =new ArrayList<>();

    public void addInstructor(Instructor instructor){
        instructorList.add(instructor);
    }

    public void displayAllInstructor(){
        for (Instructor instructor : instructorList) {
            instructor.display();
        }
    }

    public void updateInstructor(int index){
        for (int i = 0; i < instructorList.size(); i++){
            if(instructorList.get(i).getIndex() == index) {
                System.out.println("Enter Instructor Name: ");
                String instructorName = scanner.nextLine();

                System.out.println("Enter Instructor ID: ");
                String instructorId = scanner.nextLine();


                instructorList.set(i, new Instructor(index, instructorId, instructorName, instructorList.get(i).getCourseList()));
            }
        }
    }

    public void removeInstructor(int index){
        for (int i = 0; i < instructorList.size(); i++){
            if(instructorList.get(i).getIndex() == index){
                instructorList.remove(i);
                break;
            }
        }
    }
}
