package org.example.service;

import org.example.model.Tuition;

public class TuitionServiceImpl implements ITuitionService{
    public void calculateTuitionFee(Tuition tuition, int units, double discountRate) {
        double total = (PRICE_PER_UNIT * units);
        double discount = total * discountRate;
        double finalFee = total - discount;

        tuition.setTotal(finalFee);
        tuition.setRemainingBalance(finalFee);
        tuition.setFullyPaid(finalFee <= 0);
    }

    public void processPayment(Tuition tuition, double amount) {
        // add validation here for not accepting negative numbers and if already fully paid

        double newAmountPaid = tuition.getTotalAmountPaid() + amount;
        tuition.setTotalAmountPaid(newAmountPaid);

        double newBalance = tuition.getTotal() - newAmountPaid;

        if (newBalance <= 0) {
            tuition.setRemainingBalance(0);
            tuition.setFullyPaid(true);
        } else {
            tuition.setRemainingBalance(newBalance);
            tuition.setFullyPaid(false);
        }
    }
}
