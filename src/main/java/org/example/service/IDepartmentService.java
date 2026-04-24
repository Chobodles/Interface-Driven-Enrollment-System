package org.example.service;

import org.example.model.Department;

public interface IDepartmentService {
    void addDepartment(Department department);
    void displayAllDepartment();
    void updateDepartment(Department department);
    void removeDepartment(Department department);
}