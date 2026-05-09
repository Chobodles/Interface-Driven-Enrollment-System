package org.example.controller;

import org.example.model.Student;
import org.example.model.Tuition;
import org.example.service.ITuitionService;
import org.example.service.TuitionServiceImpl;

public class TuitionServiceController {

    private final ITuitionService tuitionService;

    public TuitionServiceController() {
        this.tuitionService = new TuitionServiceImpl();
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
