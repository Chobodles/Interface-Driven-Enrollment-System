package org.example.service;

import org.example.model.Tuition;

public interface ITuitionService {
    double PRICE_PER_UNIT = 1000.00;

    void calculateTuitionFee(Tuition tuition, int units, double discountRate);
    void processPayment(Tuition tuition, double amount);
}
