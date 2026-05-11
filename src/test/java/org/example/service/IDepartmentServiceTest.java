package org.example.service;

import org.example.model.*;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class IDepartmentServiceTest {

    private IDepartmentService departmentService;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private Department buildDepartment(int index, String id, String name) {
        return new Department(index, id, name, new ArrayList<>(), new ArrayList<>());
    }

    @BeforeEach
    void setup() {
        departmentService = new DepartmentServiceImpl();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    @DisplayName("addDepartment: added department appears in display output")
    void shouldAddDepartmentAndDisplayIt() {
        departmentService.addDepartment(buildDepartment(1, "D001", "CITE"));
        departmentService.displayAllDepartment();
        assertTrue(outContent.toString().contains("CITE"));
    }

    @Test
    @DisplayName("displayAllDepartment: output contains department ID and name")
    void shouldDisplayDepartmentIdAndName() {
        departmentService.addDepartment(buildDepartment(1, "D001", "CITE"));
        departmentService.displayAllDepartment();
        String output = outContent.toString();
        assertTrue(output.contains("D001"));
        assertTrue(output.contains("CITE"));
    }

    @Test
    @DisplayName("updateDepartment: department name is replaced after update")
    void shouldUpdateDepartmentName() {
        departmentService.addDepartment(buildDepartment(1, "D001", "CITE"));
        departmentService.updateDepartment(1, "D001", "CITE Updated");
        departmentService.displayAllDepartment();
        assertTrue(outContent.toString().contains("CITE Updated"));
    }

    @Test
    @DisplayName("updateDepartment: existing instructor and program lists are preserved")
    void shouldPreserveListsOnUpdate() {
        Instructor instructor = new Instructor(1, "I001", "Dr. Strange");
        Program program = new Program(1, "P001", "CS", new ArrayList<>(), new ArrayList<>());
        Department department = new Department(1, "D001", "CITE",
                new ArrayList<>() {{ add(instructor); }},
                new ArrayList<>() {{ add(program); }});
        departmentService.addDepartment(department);
        departmentService.updateDepartment(1, "D001", "CITE Renamed");
        departmentService.displayAllDepartment();
        assertTrue(outContent.toString().contains("CS"));
    }

    @Test
    @DisplayName("removeDepartment: removed department no longer appears in display")
    void shouldRemoveDepartmentByIndex() {
        departmentService.addDepartment(buildDepartment(1, "D001", "CITE"));
        departmentService.removeDepartment(1);
        departmentService.displayAllDepartment();
        assertFalse(outContent.toString().contains("CITE"));
    }
}