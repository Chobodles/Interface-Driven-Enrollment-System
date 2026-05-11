package org.example.service;

import org.example.model.Tuition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class ITuitionServiceTest {
    private ITuitionService tuitionService;
    private Tuition tuition;

    @BeforeEach
    void setup() {
        this.tuitionService = new TuitionServiceImpl();
        this.tuition = new Tuition();
    }

    @Test
    void shouldCalculateTuitionFee() {
        Assertions.assertEquals((double)6000.0F, this.tuitionService.calculateTuitionFee(tuition, 6, 0));

    }

    @Test
    @DisplayName("Calculation of TuitionFee with 10 percent")
    void shouldCalculateTotalTuitionFeeWith10PercentDiscount() {
        Assertions.assertEquals((double)5400.0F, this.tuitionService.calculateTuitionFee(tuition,6, 0.1));
    }

    @Test
    void shouldProcessPayment() {
        tuitionService.calculateTuitionFee(tuition, 3, 0); // total = 2700.00
        tuitionService.processPayment(tuition, 1000.0);

        assertEquals(2000.0, tuition.getRemainingBalance(), .0001);
    }

    @Test
    void shouldCheckIfTheTuitionFeeIsNotFullyPaid() {
        this.tuitionService.calculateTuitionFee(tuition, 6, 0);
        this.tuitionService.processPayment(tuition, 5000);
        Assertions.assertFalse(this.tuition.isFullyPaid());
    }

    @Test
    void shouldCheckIfTheTuitionFeeIsFullyPaid() {
        this.tuitionService.calculateTuitionFee(tuition, 6, 0);
        this.tuitionService.processPayment(tuition, 6000);
        Assertions.assertTrue(this.tuition.isFullyPaid());
    }

}



