package org.example.service;

import org.example.model.Tuition;

public class TuitionServiceImpl implements ITuitionService{
    public double calculateTuitionFee(Tuition tuition, int units, double discountRate) {
        double total = PRICE_PER_UNIT * units;
        double discount = total * discountRate;
        double finalFee = total - discount;

        tuition.setTotal(finalFee);
        tuition.setRemainingBalance(finalFee - tuition.getTotalAmountPaid());
        tuition.setFullyPaid(tuition.getRemainingBalance() <= 0);

        return finalFee;
    }

    public void processPayment(Tuition tuition, double amount) {
        // add validation here for not accepting negative numbers and if already fully paid custom exception

        double newAmountPaid = tuition.getTotalAmountPaid() + amount;
        tuition.setTotalAmountPaid(tuition.getTotal() - newAmountPaid);

        tuition.setFullyPaid(tuition.getRemainingBalance() <= 0);

        System.out.printf("Payment of %.2f accepted. Your Remaining balance: %.2f%n",
                amount, tuition.getRemainingBalance());

    }
}
