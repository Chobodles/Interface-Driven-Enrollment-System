package org.example;

import org.example.controller.CampusRegistrarController;
import org.example.model.*;
import org.example.service.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // ─── Init Controller ─────────────────────────────────────────────────
        CampusRegistrarController controller = new CampusRegistrarController(
                new StudentServiceImpl(),
                new InstructorServiceImpl(),
                new CourseServiceImpl(),
                new ProgramServiceImpl(),
                new SectionServiceImpl(),
                new LoadingServiceImpl(),
                new DepartmentServiceImpl(),
                new TuitionServiceImpl()
        );

        // ─── Instructor ──────────────────────────────────────────────────────
        controller.addInstructor(1, "INS-001", "Mr. Reyes");
        Instructor mrReyes = new Instructor(1, "INS-001", "Mr. Reyes");

        // ─── Program ─────────────────────────────────────────────────────────
        Program bsit = new Program(1, "BSIT", "BS Information Technology", new ArrayList<>(), new ArrayList<>());
        controller.addProgram(bsit);

        // ─── Course ──────────────────────────────────────────────────────────
        controller.addCourse(1, "IT101", "Interprog", bsit);
        Course interprog = new Course(1, "IT101", "Interprog", bsit);

        // ─── Students ────────────────────────────────────────────────────────
        controller.addStudent(1, "STU-001", "Juan dela Cruz");
        controller.addStudent(2, "STU-002", "Maria Santos");
        controller.addStudent(3, "STU-003", "Carlo Reyes");
        controller.addStudent(4, "STU-004", "Angela Lim");
        controller.addStudent(5, "STU-005", "Renzo Garcia");

        Student juan    = new Student(1, "STU-001", "Juan dela Cruz");
        Student maria   = new Student(2, "STU-002", "Maria Santos");
        Student carlo   = new Student(3, "STU-003", "Carlo Reyes");
        Student angela  = new Student(4, "STU-004", "Angela Lim");
        Student renzo   = new Student(5, "STU-005", "Renzo Garcia");

        // ─── Loading ─────────────────────────────────────────────────────────
        List<Loading> allLoadings = new ArrayList<>();
        Loading interProgLoad = new Loading(1, mrReyes, interprog, new ArrayList<>());
        allLoadings.add(interProgLoad);
        controller.addLoading(interProgLoad);

        // ─── Section ─────────────────────────────────────────────────────────
        Section it2c = new Section(1, "IT2C", 2, allLoadings);
        controller.addSection(it2c);

        // ─── Department ──────────────────────────────────────────────────────
        Department cite = new Department(1, "CITE", "College of Information Technology and Engineering",
                List.of(mrReyes), List.of(bsit));
        controller.addDepartment(cite);

        // ─── Enroll Students ─────────────────────────────────────────────────
        System.out.println("\n=== Enrolling Students to Integprog Load ===");
        controller.enrollStudentToLoading(1, juan,   allLoadings, 0.0);
        controller.enrollStudentToLoading(1, maria,  allLoadings, 0.0);
        controller.enrollStudentToLoading(1, carlo,  allLoadings, 0.0);
        controller.enrollStudentToLoading(1, angela, allLoadings, 0.0);
        controller.enrollStudentToLoading(1, renzo,  allLoadings, 0.0);

        // ─── Display All ─────────────────────────────────────────────────────
        System.out.println();
        controller.displayAllDepartments();

        // ─── Display Tuition ─────────────────────────────────────────────────
        System.out.println("\n=== Student Tuition Summary ===");
        controller.displayStudentTuition(juan);
        controller.displayStudentTuition(maria);
        controller.displayStudentTuition(carlo);
        controller.displayStudentTuition(angela);
        controller.displayStudentTuition(renzo);
    }
}