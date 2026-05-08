package org.example.service;

import org.example.model.Department;
import org.example.model.Program;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DepartmentServiceImpl implements IDepartmentService {
    private final Scanner scanner = new Scanner(System.in);
    private final List<Department> departmentList = new ArrayList<>();

    public void addDepartment(Department department) {
        departmentList.add(department);
    }

    public void displayAllDepartment() {
        for (Department department : departmentList) {
            List<Program> programs = department.display();
            for (Program program : programs) {
                program.display();
            }
        }
    }

    public void updateDepartment(Department department) {
        for (int i = 0; i < departmentList.size(); i++) {
            if (departmentList.get(i).getDepartmentIndex() == department.getDepartmentIndex()) {
                System.out.println("Enter Department ID: ");
                String departmentId = scanner.nextLine();

                System.out.println("Enter Department Name: ");
                String departmentName = scanner.nextLine();

                departmentList.set(i, new Department(
                        department.getDepartmentIndex(),
                        departmentId,
                        departmentName,
                        departmentList.get(i).getInstructorList(),
                        departmentList.get(i).getProgramList()
                ));
                break;
            }
        }
    }

    public void removeDepartment(Department department) {
        for (int i = 0; i < departmentList.size(); i++) {
            if (departmentList.get(i).getDepartmentIndex() == department.getDepartmentIndex()) {
                departmentList.remove(i);
                break;
            }
        }
    }
}