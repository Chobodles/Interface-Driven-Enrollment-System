package org.example.model;

public class Tuition {
    private double total;
    private double totalAmountPaid;
    private double remainingBalance;
    private boolean isFullyPaid;

    public Tuition() {
        this.amountTotalPaid = 0;
        this.isFullyPaid = false;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotalAmountPaid() {
        return totalAmountPaid;
    }

    public void setTotalAmountPaid(double totalAmountPaid) {
        this.totalAmountPaid = totalAmountPaid;
    }

    public double getRemainingBalance() {
        return remainingBalance;
    }

    public void setRemainingBalance(double remainingBalance) {
        this.remainingBalance = remainingBalance;
    }

    public boolean isFullyPaid() {
        return isFullyPaid;
    }

    public void setFullyPaid(boolean fullyPaid) {
        isFullyPaid = fullyPaid;
    }

    @Override
    public String toString() {
        return "Tuition{" +
                "total=" + total +
                ", totalAmountPaid=" + totalAmountPaid +
                ", remainingBalance=" + remainingBalance +
                ", isFullyPaid=" + isFullyPaid +
                '}';
    }
}
