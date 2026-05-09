package org.example.controller;

import org.example.exception.LoadFullException;
import org.example.model.Course;
import org.example.model.Instructor;
import org.example.model.Loading;
import org.example.model.Student;
import org.example.model.Tuition;
import org.example.service.ILoadingService;
import org.example.service.LoadingServiceImpl;
import org.example.service.ITuitionService;
import org.example.service.TuitionServiceImpl;

import java.util.List;



public class LoadingServiceController {
    private static final int UNITS_PER_LOAD = 3;
    private final ILoadingService loadingService;
    private final ITuitionService tuitionService;

    public LoadingServiceController() {
        this.tuitionService = new TuitionServiceImpl();
        this.loadingService = new LoadingServiceImpl();
    }

    public void addLoading(Loading loading) {
        loadingService.addLoading(loading);
        System.out.println("Loading added for course: " + loading.getCourse().getCourseName());
    }

    public void displayAllLoadings() {
        System.out.println("=== All Loadings ===");
        loadingService.displayAllLoading();
    }

    public void updateLoading(int index, Instructor instructor, Course course) {
        loadingService.updateLoading(index, instructor, course);
        System.out.println("Loading updated at index: " + index);
    }

    public void removeLoading(int index) {
        loadingService.removeLoading(index);
        System.out.println("Loading removed at index: " + index);
    }

    public void enrollStudentToLoading(int loadingIndex, Student student, List<Loading> allLoadings, double discountRate) {
        try {
            loadingService.enrollStudent(loadingIndex, student);
            System.out.println("Student " + student.getName() + " enrolled to loading index: " + loadingIndex);
            recalculateStudentTuition(student, allLoadings, discountRate);
        } catch (LoadFullException e) {
            System.out.println("Enrollment Error: " + e.getMessage());
        }
    }

    public void removeStudentFromLoading(int loadingIndex, int studentIndex) {
        loadingService.removeStudent(loadingIndex, studentIndex);
        System.out.println("Student removed from loading index: " + loadingIndex);
    }

    private void recalculateStudentTuition(Student student, List<Loading> allLoadings, double discountRate) {
        int count = 0;
        for (Loading loading : allLoadings) {
            if (loading.getStudentList().contains(student)) {
                count++;
            }
        }

        int totalUnits = (int) count * UNITS_PER_LOAD;

        if (student.getTuition() == null) {
            student.setTuition(new Tuition());
        }

        tuitionService.calculateTuitionFee(student.getTuition(), totalUnits, discountRate);
        System.out.printf("Tuition recalculated for %s | Units: %d | Total: %.2f%n",
                student.getName(), totalUnits, student.getTuition().getTotal());
    }
}
