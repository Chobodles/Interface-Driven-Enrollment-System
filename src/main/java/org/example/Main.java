
package org.example;

import org.example.controller.*;
import org.example.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static StudentServiceController studentCtrl    = new StudentServiceController();
    static InstructorServiceController instructorCtrl = new InstructorServiceController();
    static CourseServiceController     courseCtrl     = new CourseServiceController();
    static ProgramServiceController    programCtrl    = new ProgramServiceController();
    static SectionServiceController    sectionCtrl    = new SectionServiceController();
    static LoadingServiceController    loadingCtrl    = new LoadingServiceController();
    static DepartmentServiceController departmentCtrl = new DepartmentServiceController();
    static TuitionServiceController    tuitionCtrl    = new TuitionServiceController();

    static List<Student> students    = new ArrayList<>();
    static List<Instructor> instructors = new ArrayList<>();
    static List<Course>     courses     = new ArrayList<>();
    static List<Program>    programs    = new ArrayList<>();
    static List<Section>    sections    = new ArrayList<>();
    static List<Loading>    loadings    = new ArrayList<>();
    static List<Department> departments = new ArrayList<>();

    static int studentIdCounter    = 1;
    static int instructorIdCounter = 1;
    static int courseIdCounter     = 1;
    static int programIdCounter    = 1;
    static int sectionIdCounter    = 1;
    static int loadingIdCounter    = 1;
    static int departmentIdCounter = 1;

    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║       CAMPUS REGISTRAR ENROLLMENT SYSTEM     ║");
        System.out.println("╚══════════════════════════════════════════════╝");


        while (true) {
            printMainMenu();
            int choice = readInt("Enter choice: ");
            switch (choice) {
                case 1  -> manageStudents();
                case 2  -> manageInstructors();
                case 3  -> manageCourses();
                case 4  -> managePrograms();
                case 5  -> manageSections();
                case 6  -> manageLoadings();
                case 7  -> manageDepartments();
                case 8  -> manageEnrollment();
                case 9  -> manageTuition();
                case 10 -> displayAll();
                case 0  -> { System.exit(0); }
                default -> System.out.println("[!] Invalid option. Try again.");
            }
        }
    }


    static void printMainMenu() {
        System.out.println("\n┌──────────────────────────────────┐");
        System.out.println("│            MAIN MENU             │");
        System.out.println("├──────────────────────────────────┤");
        System.out.println("│  1. Manage Students              │");
        System.out.println("│  2. Manage Instructors           │");
        System.out.println("│  3. Manage Courses               │");
        System.out.println("│  4. Manage Programs              │");
        System.out.println("│  5. Manage Sections              │");
        System.out.println("│  6. Manage Loadings              │");
        System.out.println("│  7. Manage Departments           │");
        System.out.println("│  8. Enrollment                   │");
        System.out.println("│  9. Tuition                      │");
        System.out.println("│ 10. Display All                  │");
        System.out.println("│  0. Exit                         │");
        System.out.println("└──────────────────────────────────┘");
    }

    static void printCrudMenu(String entity) {
        System.out.println("\n--- " + entity + " ---");
        System.out.println("  1. Add");
        System.out.println("  2. Display All");
        System.out.println("  3. Update");
        System.out.println("  4. Remove");
        System.out.println("  0. Back");
    }

    // ═══════════════════════════════════════════════════════════════════════════
    // STUDENTS
    // ═══════════════════════════════════════════════════════════════════════════
    static void manageStudents() {
        boolean back = false;
        while (!back) {
            printCrudMenu("STUDENTS");
            int c = readInt("Choice: ");
            switch (c) {
                case 1 -> {
                    String id   = readString("Student ID (e.g. STU-001): ");
                    String name = readString("Student Name: ");
                    Student s = new Student(studentIdCounter, id, name);
                    students.add(s);
                    studentCtrl.addStudent(studentIdCounter, id, name);
                    studentIdCounter++;
                }
                case 2 -> {
                    System.out.println("\n=== All Students ===");
                    if (students.isEmpty()) { System.out.println("  (none)"); break; }
                    students.forEach(Student::display);
                }
                case 3 -> {
                    if (students.isEmpty()) { System.out.println("No students to update."); break; }
                    students.forEach(Student::display);
                    int idx = readInt("Enter index to update: ");
                    Student found = findStudentByIndex(idx);
                    if (found == null) { System.out.println("Not found."); break; }
                    String newId   = readString("New ID: ");
                    String newName = readString("New Name: ");
                    found.setId(newId);
                    found.setName(newName);
                    studentCtrl.updateStudent(idx, newId, newName);
                }
                case 4 -> {
                    if (students.isEmpty()) { System.out.println("No students to remove."); break; }
                    students.forEach(Student::display);
                    int idx = readInt("Enter index to remove: ");
                    students.removeIf(s -> s.getIndex() == idx);
                    studentCtrl.removeStudent(idx);
                }
                case 0 -> back = true;
                default -> System.out.println("Invalid.");
            }
        }
    }

    static void manageInstructors() {
        boolean back = false;
        while (!back) {
            printCrudMenu("INSTRUCTORS");
            int c = readInt("Choice: ");
            switch (c) {
                case 1 -> {
                    String id   = readString("Instructor ID (e.g. INS-001): ");
                    String name = readString("Instructor Name: ");
                    Instructor ins = new Instructor(instructorIdCounter, id, name);
                    instructors.add(ins);
                    instructorCtrl.addInstructor(instructorIdCounter, id, name);
                    instructorIdCounter++;
                }
                case 2 -> {
                    System.out.println("\n=== All Instructors ===");
                    if (instructors.isEmpty()) { System.out.println("  (none)"); break; }
                    instructors.forEach(Instructor::display);
                }
                case 3 -> {
                    if (instructors.isEmpty()) { System.out.println("No instructors to update."); break; }
                    instructors.forEach(Instructor::display);
                    int idx = readInt("Enter index to update: ");
                    Instructor found = findInstructorByIndex(idx);
                    if (found == null) { System.out.println("Not found."); break; }
                    String newId   = readString("New ID: ");
                    String newName = readString("New Name: ");
                    found.setId(newId);
                    found.setName(newName);
                    instructorCtrl.updateInstructor(idx, newId, newName);
                }
                case 4 -> {
                    if (instructors.isEmpty()) { System.out.println("No instructors to remove."); break; }
                    instructors.forEach(Instructor::display);
                    int idx = readInt("Enter index to remove: ");
                    instructors.removeIf(i -> i.getIndex() == idx);
                    instructorCtrl.removeInstructor(idx);
                }
                case 0 -> back = true;
                default -> System.out.println("Invalid.");
            }
        }
    }

    static void manageCourses() {
        boolean back = false;
        while (!back) {
            printCrudMenu("COURSES");
            int c = readInt("Choice: ");
            switch (c) {
                case 1 -> {
                    if (programs.isEmpty()) { System.out.println("Add a program first."); break; }
                    String cid  = readString("Course ID (e.g. IT101): ");
                    String name = readString("Course Name: ");
                    listPrograms();
                    int pidx    = readInt("Select Program index: ");
                    Program prog = findProgramByIndex(pidx);
                    if (prog == null) { System.out.println("Program not found."); break; }
                    Course course = new Course(courseIdCounter, cid, name, prog);
                    courses.add(course);
                    courseCtrl.addCourse(courseIdCounter, cid, name, prog);
                    courseIdCounter++;
                }
                case 2 -> {
                    System.out.println("\n=== All Courses ===");
                    if (courses.isEmpty()) { System.out.println("  (none)"); break; }
                    courses.forEach(co -> System.out.printf(
                            "Index: [%d] | %s - %s | Program: %s%n",
                            co.getCourseIndex(), co.getCourseId(),
                            co.getCourseName(), co.getProgram().getProgramName()));
                }
                case 3 -> {
                    if (courses.isEmpty()) { System.out.println("No courses to update."); break; }
                    listCourses();
                    int idx = readInt("Enter course index to update: ");
                    Course found = findCourseByIndex(idx);
                    if (found == null) { System.out.println("Not found."); break; }
                    String newId   = readString("New Course ID: ");
                    String newName = readString("New Course Name: ");
                    listPrograms();
                    int pidx   = readInt("Select new Program index: ");
                    Program prog = findProgramByIndex(pidx);
                    if (prog == null) { System.out.println("Program not found."); break; }
                    found.setCourseId(newId);
                    found.setCourseName(newName);
                    found.setProgram(prog);
                    courseCtrl.updateCourse(idx, newId, newName, prog);
                }
                case 4 -> {
                    if (courses.isEmpty()) { System.out.println("No courses to remove."); break; }
                    listCourses();
                    int idx = readInt("Enter course index to remove: ");
                    courses.removeIf(co -> co.getCourseIndex() == idx);
                    courseCtrl.removeCourse(idx);
                }
                case 0 -> back = true;
                default -> System.out.println("Invalid.");
            }
        }
    }


    static void managePrograms() {
        boolean back = false;
        while (!back) {
            printCrudMenu("PROGRAMS");
            int c = readInt("Choice: ");
            switch (c) {
                case 1 -> {
                    String pid  = readString("Program ID (e.g. BSIT): ");
                    String name = readString("Program Name: ");
                    Program prog = new Program(programIdCounter, pid, name, new ArrayList<>(), new ArrayList<>());
                    programs.add(prog);
                    programCtrl.addProgram(prog);
                    programIdCounter++;
                }
                case 2 -> {
                    System.out.println("\n=== All Programs ===");
                    if (programs.isEmpty()) { System.out.println("  (none)"); break; }
                    programs.forEach(p -> System.out.printf("Index: [%d] | %s - %s%n",
                            p.getProgramIndex(), p.getProgramId(), p.getProgramName()));
                }
                case 3 -> {
                    if (programs.isEmpty()) { System.out.println("No programs to update."); break; }
                    listPrograms();
                    int idx = readInt("Enter index to update: ");
                    Program found = findProgramByIndex(idx);
                    if (found == null) { System.out.println("Not found."); break; }
                    String newId   = readString("New Program ID: ");
                    String newName = readString("New Program Name: ");
                    found.setProgramId(newId);
                    found.setProgramName(newName);
                    programCtrl.updateProgram(idx, newId, newName);
                }
                case 4 -> {
                    if (programs.isEmpty()) { System.out.println("No programs to remove."); break; }
                    listPrograms();
                    int idx = readInt("Enter index to remove: ");
                    programs.removeIf(p -> p.getProgramIndex() == idx);
                    programCtrl.removeProgram(idx);
                }
                case 0 -> back = true;
                default -> System.out.println("Invalid.");
            }
        }
    }

    static void manageSections() {
        boolean back = false;
        while (!back) {
            printCrudMenu("SECTIONS");
            int c = readInt("Choice: ");
            switch (c) {
                case 1 -> {
                    String name = readString("Section Name (e.g. IT1C): ");
                    int year    = readInt("Year Level: ");
                    Section sec = new Section(sectionIdCounter, name, year, new ArrayList<>());
                    sections.add(sec);
                    sectionCtrl.addSection(sec);
                    if (!programs.isEmpty()) {
                        listPrograms();
                        int pidx = readInt("Attach to Program index (0 to skip): ");
                        if (pidx != 0) {
                            Program prog = findProgramByIndex(pidx);
                            if (prog != null) prog.getSectionList().add(sec);
                            else System.out.println("Program not found, skipping attach.");
                        }
                    }
                    sectionIdCounter++;
                }
                case 2 -> {
                    System.out.println("\n=== All Sections ===");
                    if (sections.isEmpty()) { System.out.println("  (none)"); break; }
                    sections.forEach(s -> System.out.printf("Index: [%d] | %s | Year %d | Loadings: %d%n",
                            s.getSectionIndex(), s.getSectionName(),
                            s.getYearLevel(), s.getLoadingList().size()));
                }
                case 3 -> {
                    if (sections.isEmpty()) { System.out.println("No sections to update."); break; }
                    listSections();
                    int idx = readInt("Enter index to update: ");
                    Section found = findSectionByIndex(idx);
                    if (found == null) { System.out.println("Not found."); break; }
                    String newName = readString("New Section Name: ");
                    int newYear    = readInt("New Year Level: ");
                    found.setSectionName(newName);
                    found.setYearLevel(newYear);
                    sectionCtrl.updateSection(idx, newName, newYear);
                }
                case 4 -> {
                    if (sections.isEmpty()) { System.out.println("No sections to remove."); break; }
                    listSections();
                    int idx = readInt("Enter index to remove: ");
                    sections.removeIf(s -> s.getSectionIndex() == idx);
                    sectionCtrl.removeSection(idx);
                }
                case 0 -> back = true;
                default -> System.out.println("Invalid.");
            }
        }
    }

    static void manageLoadings() {
        boolean back = false;
        while (!back) {
            printCrudMenu("LOADINGS");
            int c = readInt("Choice: ");
            switch (c) {
                case 1 -> {
                    if (instructors.isEmpty()) { System.out.println("Add an instructor first."); break; }
                    if (courses.isEmpty())     { System.out.println("Add a course first."); break; }
                    listInstructors();
                    int iidx       = readInt("Select Instructor index: ");
                    Instructor ins = findInstructorByIndex(iidx);
                    if (ins == null) { System.out.println("Instructor not found."); break; }
                    listCourses();
                    int cidx      = readInt("Select Course index: ");
                    Course course = findCourseByIndex(cidx);
                    if (course == null) { System.out.println("Course not found."); break; }

                    Loading loading = new Loading(loadingIdCounter, ins, course, new ArrayList<>());
                    loadings.add(loading);
                    loadingCtrl.addLoading(loading);

                    if (!sections.isEmpty()) {
                        listSections();
                        int sidx = readInt("Attach to Section index (0 to skip): ");
                        if (sidx != 0) {
                            Section sec = findSectionByIndex(sidx);
                            if (sec != null) sec.getLoadingList().add(loading);
                            else System.out.println("Section not found, skipping attach.");
                        }
                    }
                    loadingIdCounter++;
                }
                case 2 -> {
                    System.out.println("\n=== All Loadings ===");
                    if (loadings.isEmpty()) { System.out.println("  (none)"); break; }
                    listLoadings();
                }
                case 3 -> {
                    if (loadings.isEmpty()) { System.out.println("No loadings to update."); break; }
                    listLoadings();
                    int idx = readInt("Enter loading index to update: ");
                    Loading found = findLoadingByIndex(idx);
                    if (found == null) { System.out.println("Not found."); break; }
                    listInstructors();
                    int iidx       = readInt("Select new Instructor index: ");
                    Instructor ins = findInstructorByIndex(iidx);
                    if (ins == null) { System.out.println("Instructor not found."); break; }
                    listCourses();
                    int cidx      = readInt("Select new Course index: ");
                    Course course = findCourseByIndex(cidx);
                    if (course == null) { System.out.println("Course not found."); break; }
                    found.setInstructor(ins);
                    found.setCourse(course);
                    loadingCtrl.updateLoading(idx, ins, course);
                }
                case 4 -> {
                    if (loadings.isEmpty()) { System.out.println("No loadings to remove."); break; }
                    listLoadings();
                    int idx = readInt("Enter loading index to remove: ");
                    loadings.removeIf(l -> l.getLoadingIndex() == idx);
                    loadingCtrl.removeLoading(idx);
                }
                case 0 -> back = true;
                default -> System.out.println("Invalid.");
            }
        }
    }

    static void manageDepartments() {
        boolean back = false;
        while (!back) {
            printCrudMenu("DEPARTMENTS");
            int c = readInt("Choice: ");
            switch (c) {
                case 1 -> {
                    String did  = readString("Department ID (e.g. CITE): ");
                    String name = readString("Department Name: ");

                    // Assign instructors
                    List<Instructor> deptInstructors = new ArrayList<>();
                    if (!instructors.isEmpty()) {
                        System.out.println("Assign instructors (enter index one by one, 0 to stop):");
                        listInstructors();
                        while (true) {
                            int iidx = readInt("  Instructor index (0 to stop): ");
                            if (iidx == 0) break;
                            Instructor ins = findInstructorByIndex(iidx);
                            if (ins != null) deptInstructors.add(ins);
                            else System.out.println("  Not found, skipping.");
                        }
                    }

                    List<Program> deptPrograms = new ArrayList<>();
                    if (!programs.isEmpty()) {
                        System.out.println("Assign programs (enter index one by one, 0 to stop):");
                        listPrograms();
                        while (true) {
                            int pidx = readInt("  Program index (0 to stop): ");
                            if (pidx == 0) break;
                            Program prog = findProgramByIndex(pidx);
                            if (prog != null) deptPrograms.add(prog);
                            else System.out.println("  Not found, skipping.");
                        }
                    }

                    Department dept = new Department(departmentIdCounter, did, name, deptInstructors, deptPrograms);
                    departments.add(dept);
                    departmentCtrl.addDepartment(dept);
                    departmentIdCounter++;
                }
                case 2 -> {
                    System.out.println("\n=== All Departments ===");
                    if (departments.isEmpty()) { System.out.println("  (none)"); break; }
                    departments.forEach(d -> System.out.printf("Index: [%d] | %s - %s%n",
                            d.getDepartmentIndex(), d.getId(), d.getDepartmentName()));
                }
                case 3 -> {
                    if (departments.isEmpty()) { System.out.println("No departments to update."); break; }
                    departments.forEach(d -> System.out.printf("Index: [%d] | %s - %s%n",
                            d.getDepartmentIndex(), d.getId(), d.getDepartmentName()));
                    int idx    = readInt("Enter index to update: ");
                    String newId   = readString("New Department ID: ");
                    String newName = readString("New Department Name: ");
                    departments.stream()
                            .filter(d -> d.getDepartmentIndex() == idx)
                            .findFirst()
                            .ifPresent(d -> { d.setId(newId); d.setDepartmentName(newName); });
                    departmentCtrl.updateDepartment(idx, newId, newName);
                }
                case 4 -> {
                    if (departments.isEmpty()) { System.out.println("No departments to remove."); break; }
                    departments.forEach(d -> System.out.printf("Index: [%d] | %s - %s%n",
                            d.getDepartmentIndex(), d.getId(), d.getDepartmentName()));
                    int idx = readInt("Enter index to remove: ");
                    departments.removeIf(d -> d.getDepartmentIndex() == idx);
                    departmentCtrl.removeDepartment(idx);
                }
                case 0 -> back = true;
                default -> System.out.println("Invalid.");
            }
        }
    }

    static void manageEnrollment() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- ENROLLMENT ---");
            System.out.println("  1. Enroll Student to Loading");
            System.out.println("  2. Remove Student from Loading");
            System.out.println("  3. View Students in a Loading");
            System.out.println("  0. Back");
            int c = readInt("Choice: ");
            switch (c) {
                case 1 -> {
                    if (students.isEmpty()) { System.out.println("No students available. Add students first."); break; }
                    if (loadings.isEmpty()) { System.out.println("No loadings available. Add loadings first."); break; }
                    listStudents();
                    int sidx    = readInt("Select Student index: ");
                    Student stu = findStudentByIndex(sidx);
                    if (stu == null) { System.out.println("Student not found."); break; }

                    listLoadings();
                    int lidx     = readInt("Select Loading index: ");
                    Loading load = findLoadingByIndex(lidx);
                    if (load == null) { System.out.println("Loading not found."); break; }

                    double discount = readDouble("Discount rate (0.0 = none, 0.2 = 20%): ");

                    // Use the section's loading list for correct tuition unit count
                    List<Loading> contextLoadings = getSectionLoadingsForLoading(load);
                    loadingCtrl.enrollStudentToLoading(lidx, stu, contextLoadings, discount);
                }
                case 2 -> {
                    if (loadings.isEmpty()) { System.out.println("No loadings available."); break; }
                    listLoadings();
                    int lidx     = readInt("Select Loading index: ");
                    Loading load = findLoadingByIndex(lidx);
                    if (load == null) { System.out.println("Loading not found."); break; }
                    if (load.getStudentList().isEmpty()) { System.out.println("No students in this loading."); break; }
                    load.getStudentList().forEach(Student::display);
                    int studentIdx = readInt("Enter Student index to remove: ");
                    loadingCtrl.removeStudentFromLoading(lidx, studentIdx);
                }
                case 3 -> {
                    if (loadings.isEmpty()) { System.out.println("No loadings available."); break; }
                    listLoadings();
                    int lidx     = readInt("Select Loading index: ");
                    Loading load = findLoadingByIndex(lidx);
                    if (load == null) { System.out.println("Loading not found."); break; }
                    System.out.printf("%nStudents enrolled in [%s → %s]:%n",
                            load.getInstructor().getName(), load.getCourse().getCourseName());
                    if (load.getStudentList().isEmpty()) System.out.println("  (none)");
                    else load.getStudentList().forEach(Student::display);
                }
                case 0 -> back = true;
                default -> System.out.println("Invalid.");
            }
        }
    }

    static void manageTuition() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- TUITION ---");
            System.out.println("  1. View Student Tuition");
            System.out.println("  2. Process Payment");
            System.out.println("  3. View All Students Tuition");
            System.out.println("  0. Back");
            int c = readInt("Choice: ");
            switch (c) {
                case 1 -> {
                    if (students.isEmpty()) { System.out.println("No students."); break; }
                    listStudents();
                    int idx     = readInt("Select Student index: ");
                    Student stu = findStudentByIndex(idx);
                    if (stu == null) { System.out.println("Not found."); break; }
                    tuitionCtrl.displayStudentTuition(stu);
                }
                case 2 -> {
                    if (students.isEmpty()) { System.out.println("No students."); break; }
                    listStudents();
                    int idx     = readInt("Select Student index: ");
                    Student stu = findStudentByIndex(idx);
                    if (stu == null) { System.out.println("Not found."); break; }
                    tuitionCtrl.displayStudentTuition(stu);
                    double amount = readDouble("Payment amount: ");
                    tuitionCtrl.payStudentTuition(stu, amount);
                }
                case 3 -> {
                    System.out.println("\n=== All Students Tuition ===");
                    if (students.isEmpty()) { System.out.println("  (none)"); break; }
                    students.forEach(tuitionCtrl::displayStudentTuition);
                }
                case 0 -> back = true;
                default -> System.out.println("Invalid.");
            }
        }
    }

    static void displayAll() {
        System.out.println("\n╔══════════════════════════════════════════════╗");
        System.out.println("║           FULL SYSTEM DISPLAY                ║");
        System.out.println("╚══════════════════════════════════════════════╝");
        if (departments.isEmpty()) System.out.println("No departments set up yet.");
        else departmentCtrl.displayAllDepartments();
    }

    static Student    findStudentByIndex(int idx)    { return students.stream().filter(s -> s.getIndex() == idx).findFirst().orElse(null); }
    static Instructor findInstructorByIndex(int idx) { return instructors.stream().filter(i -> i.getIndex() == idx).findFirst().orElse(null); }
    static Course     findCourseByIndex(int idx)     { return courses.stream().filter(c -> c.getCourseIndex() == idx).findFirst().orElse(null); }
    static Program    findProgramByIndex(int idx)    { return programs.stream().filter(p -> p.getProgramIndex() == idx).findFirst().orElse(null); }
    static Section    findSectionByIndex(int idx)    { return sections.stream().filter(s -> s.getSectionIndex() == idx).findFirst().orElse(null); }
    static Loading    findLoadingByIndex(int idx)    { return loadings.stream().filter(l -> l.getLoadingIndex() == idx).findFirst().orElse(null); }

    static List<Loading> getSectionLoadingsForLoading(Loading target) {
        for (Section sec : sections) {
            if (sec.getLoadingList().contains(target)) return sec.getLoadingList();
        }
        return List.of(target);
    }

    static void listStudents()    { students.forEach(Student::display); }
    static void listInstructors() { instructors.forEach(Instructor::display); }
    static void listCourses()     { courses.forEach(co -> System.out.printf("Index: [%d] | %s - %s%n", co.getCourseIndex(), co.getCourseId(), co.getCourseName())); }
    static void listPrograms()    { programs.forEach(p -> System.out.printf("Index: [%d] | %s - %s%n", p.getProgramIndex(), p.getProgramId(), p.getProgramName())); }
    static void listSections()    { sections.forEach(s -> System.out.printf("Index: [%d] | %s | Year %d%n", s.getSectionIndex(), s.getSectionName(), s.getYearLevel())); }
    static void listLoadings()    { loadings.forEach(l -> System.out.printf("Index: [%d] | %s → %s (%d students)%n", l.getLoadingIndex(), l.getInstructor().getName(), l.getCourse().getCourseName(), l.getStudentList().size())); }

    static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try { return Integer.parseInt(sc.nextLine().trim()); }
            catch (NumberFormatException e) { System.out.println("  [!] Please enter a valid number."); }
        }
    }

    static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try { return Double.parseDouble(sc.nextLine().trim()); }
            catch (NumberFormatException e) { System.out.println("  [!] Please enter a valid number."); }
        }
    }

    static String readString(String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }

}