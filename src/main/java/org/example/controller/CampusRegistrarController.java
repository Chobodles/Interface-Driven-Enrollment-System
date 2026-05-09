package org.example.controller;

import org.example.exception.LoadFullException;
import org.example.model.*;
import org.example.service.*;

import java.util.List;

public class CampusRegistrarController {

    private final IStudentService studentService;
    private final IInstructorService instructorService;
    private final ICourseService courseService;
    private final IProgramService programService;
    private final ISectionService sectionService;
    private final ILoadingService loadingService;
    private final IDepartmentService departmentService;
    private final ITuitionService tuitionService;

    private static final int UNITS_PER_LOAD = 3;

    public CampusRegistrarController(
//            IStudentService studentService,
//            IInstructorService instructorService,
//            ICourseService courseService,
//            IProgramService programService,
//            ISectionService sectionService,
//            ILoadingService loadingService,
//            IDepartmentService departmentService,
//            ITuitionService tuitionService
    ) {
        this.studentService = new StudentServiceImpl();
        this.instructorService = instructorService;
        this.courseService = courseService;
        this.programService = programService;
        this.sectionService = sectionService;
        this.loadingService = loadingService;
        this.departmentService = departmentService;
        this.tuitionService = tuitionService;
    }

    //student


    //instructor

    public void addInstructor(int index, String id, String name) {
        instructorService.addInstructor(new Instructor(index, id, name));
        System.out.println("Instructor added: " + name);
    }

    public void displayAllInstructors() {
        System.out.println("=== All Instructors ===");
        instructorService.displayAllInstructor();
    }

    public void updateInstructor(int index, String id, String name) {
        instructorService.updateInstructor(index, id, name);
        System.out.println("Instructor updated at index: " + index);
    }

    public void removeInstructor(int index) {
        instructorService.removeInstructor(index);
        System.out.println("Instructor removed at index: " + index);
    }

    //course

    public void addCourse(int index, String courseId, String courseName, Program program) {
        courseService.addCourse(new Course(index, courseId, courseName, program));
        System.out.println("Course added: " + courseName);
    }

    public void displayAllCourses() {
        System.out.println("=== All Courses ===");
        courseService.displayAllCourse();
    }

    public void updateCourse(int index, String courseId, String courseName, Program program) {
        courseService.updateCourse(index, courseId, courseName, program);
        System.out.println("Course updated at index: " + index);
    }

    public void removeCourse(int index) {
        courseService.removeCourse(index);
        System.out.println("Course removed at index: " + index);
    }

    //department

    public void addDepartment(Department department) {
        departmentService.addDepartment(department);
        System.out.println("Department added: " + department.getDepartmentName());
    }

    public void displayAllDepartments() {
        System.out.println("=== All Departments ===");
        departmentService.displayAllDepartment();
    }

    public void updateDepartment(int index, String departmentId, String departmentName) {
        departmentService.updateDepartment(index, departmentId, departmentName);
        System.out.println("Department updated at index: " + index);
    }

    public void removeDepartment(int index) {
        departmentService.removeDepartment(index);
        System.out.println("Department removed at index: " + index);
    }

    //program

    public void addProgram(Program program) {
        programService.addProgram(program);
        System.out.println("Program added: " + program.getProgramName());
    }

    public void displayAllPrograms() {
        System.out.println("=== All Programs ===");
        programService.displayAllProgram();
    }

    public void updateProgram(int index, String programId, String programName) {
        programService.updateProgram(index, programId, programName);
        System.out.println("Program updated at index: " + index);
    }

    public void removeProgram(int index) {
        programService.removeProgram(index);
        System.out.println("Program removed at index: " + index);
    }

    //section

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

    //loading

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

    //tuition

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

    public void payStudentTuition(Student student, double amount) {
        if (student.getTuition() == null) {
            System.out.println("No tuition record found for student: " + student.getName());
            return;
        }
        tuitionService.processPayment(student.getTuition(), amount);
    }

    public void displayStudentTuition(Student student) {
        if (student.getTuition() == null) {
            System.out.println("No tuition record found for student: " + student.getName());
            return;
        }
        Tuition t = student.getTuition();
        System.out.printf("=== Tuition for %s ===%n", student.getName());
        System.out.printf("Total: %.2f | Paid: %.2f | Balance: %.2f | Fully Paid: %s%n",
                t.getTotal(), t.getTotalAmountPaid(), t.getRemainingBalance(), t.isFullyPaid());
    }

}
