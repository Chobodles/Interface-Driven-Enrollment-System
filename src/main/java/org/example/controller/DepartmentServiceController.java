package org.example.controller;

import org.example.model.Department;
import org.example.service.DepartmentServiceImpl;
import org.example.service.IDepartmentService;

public class DepartmentServiceController {
    private final IDepartmentService departmentService;

    public DepartmentServiceController() {
        this.departmentService = new DepartmentServiceImpl();
    }

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

}
