package org.example.service;

import org.example.model.Department;

public interface IDepartmentService {
    void addDepartment(Department department);
    void displayAllDepartment();
    void updateDepartment(int index, String departmentId, String departmentName);
    void removeDepartment(int index);
}