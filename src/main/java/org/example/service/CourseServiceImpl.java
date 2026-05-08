package org.example.service;

import org.example.model.Course;
import org.example.model.Program;

import java.util.ArrayList;

public class CourseServiceImpl implements ICourseService {
    private final ArrayList<Course> courseList = new ArrayList<>();

    public void addCourse(Course course) {
        courseList.add(course);
    }

    public void displayAllCourse() {
        for (Course course : courseList) {
            course.display();
        }
    }

    public void updateCourse(int index, String courseId, String courseName, Program program) {
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCourseIndex() == index) {
                courseList.set(i, new Course(index, courseId, courseName, program));
                break;
            }
        }
    }

    public void removeCourse(int index) {
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCourseIndex() == index) {
                courseList.remove(i);
                break;
            }
        }
    }
}