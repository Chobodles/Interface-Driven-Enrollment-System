package org.example.service;

import org.example.model.Course;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseServiceImpl implements ICourseService{
    private final Scanner scanner = new Scanner(System.in);
    //holds all Course objects accessible via index
    private final ArrayList<Course> courseList = new ArrayList<>();

    public void addCourse(Course course){
        courseList.add(course);
    }

    public void displayAllCourse(){
        for (Course course : courseList) {
            course.display();
        }
    }

    public void updateCourse(int index){
        for (int i = 0; i < courseList.size(); i++){
            // matches the course details in the list with the corresponding course index sent from the controller
            if(courseList.get(i).getCourseIndex() == index) {
                System.out.println("Enter Course ID: ");
                String courseId = scanner.nextLine();

                System.out.println("Enter Course Name: ");
                String courseName = scanner.nextLine();

                System.out.println("Enter Program: ");
                String program = scanner.nextLine();

                courseList.set(i, new Course(index, courseId, courseName, program));
                break;
            }
        }
    }

    public void removeCourse(int index){
        for (int i = 0; i < courseList.size(); i++){
            if(courseList.get(i).getCourseIndex() == index){
                courseList.remove(i);
                break;
            }
        }
    }
}
