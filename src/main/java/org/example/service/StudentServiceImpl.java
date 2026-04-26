package org.example.service;

import org.example.model.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentServiceImpl implements IStudentService{
    private final Scanner scanner = new Scanner(System.in);
    //holds all student objects accessible via index
    //if to add a student to section place index
    private final ArrayList<Student> studentList = new ArrayList<>();

    public void addStudent(Student student){
        studentList.add(student);
    }

    public void displayAllStudent(){
        for (Student student : studentList) {
            student.display();
        }
    }

    public void updateStudent(int index){
        for (int i = 0; i < studentList.size(); i++){
            // matches the student details in the list with the received student data
            if(studentList.get(i).getIndex() == index) {
                System.out.println("Enter Name: ");
                String studentName = scanner.nextLine();

                System.out.println("Enter Student ID: ");
                String studentId = scanner.nextLine();

                studentList.set(i, new Student(index, studentId, studentName));
                break;
            }
        }
    }

    public void removeStudent(int index){
        for (int i = 0; i < studentList.size(); i++){
            if(studentList.get(i).getIndex() == index){
                studentList.remove(i);
                break;
            }
        }
    }
}
