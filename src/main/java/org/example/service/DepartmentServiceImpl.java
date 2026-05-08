package org.example.service;

import org.example.model.Department;
import org.example.model.Program;

import java.util.ArrayList;
import java.util.List;

public class DepartmentServiceImpl implements IDepartmentService {
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

    public void updateDepartment(int index, String departmentId, String departmentName) {
        for (int i = 0; i < departmentList.size(); i++) {
            if (departmentList.get(i).getDepartmentIndex() == index) {
                departmentList.set(i, new Department(
                        index,
                        departmentId,
                        departmentName,
                        departmentList.get(i).getInstructorList(),
                        departmentList.get(i).getProgramList()
                ));
                break;
            }
        }
    }

    public void removeDepartment(int index) {
        for (int i = 0; i < departmentList.size(); i++) {
            if (departmentList.get(i).getDepartmentIndex() == index) {
                departmentList.remove(i);
                break;
            }
        }
    }
}