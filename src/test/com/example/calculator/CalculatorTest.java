package com.example.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    private Calculator calc;


    @BeforeEach
    void setUp() {
        calc = new Calculator();
        System.out.println("BeforeEach CalculatorTest");
    }

    @Test
    void canAddZeroPlusZero() {
        int sum = calc.add(0, 0);
        assertEquals(0, sum);
    }

    @Test
    void canAddOnePlusOne() {
        int sum = calc.add(1, 1);
        assertEquals(2, sum);
    }

    @Test
    void canAddMinusThreePlusFive() {
        int sum = calc.add(-3, +5);
        assertEquals(2, sum);
    }

    @Test
    void canAddMinusThreePlusMinusFive() {
        int sum = calc.add(-3, -5);
        assertEquals(-8, sum);
    }

    @Test
    void canAddMaxIntPlusMinusFive() {
        assertThrows(ArithmeticException.class, () -> calc.add(Integer.MAX_VALUE, 1));
    }

    @Test
    void canAddMinIntPlusMinusOne() {
        assertThrows(ArithmeticException.class, () -> calc.add(Integer.MIN_VALUE, -1));
    }

    @Test
    void canSubtractFiveMinusThree() {
        int diff = calc.subtract(5, 3);
        assertEquals(2, diff);
    }

    @Test
    void canSubtractTenMinusFour() {
        int diff = calc.subtract(10, 4);
        assertEquals(6, diff);
    }

    @Test
    void canMultiplyFiveTimesThree() {
        int mult = calc.multiply(5, 3);
        assertEquals(15, mult);
    }

    @Test
    void canMultiplyFiveTimesZero() {
        int mult = calc.multiply(5, 0);
        assertEquals(0, mult);
    }

    @Test
    void canMultiplyMinusNineTimesMinusTwo() {
        int mult = calc.multiply(-9, -2);
        assertEquals(18, mult);
    }

    @Test
    void canDivideFiveDividedByThree() {
        int div = calc.divide(5, 3);
        assertEquals(1, div);
    }

    @Test
    void canDivideFiveDividedByZero() {
        assertThrows(ArithmeticException.class, () -> calc.divide(5, 0));
    }

    @Test
    void canDivideSevenDividedByTwo() {
        int div = calc.divide(7, 2);
        assertEquals(3, div, "7 / 2 is wrong!");
    }

    @Test
    void annuityExample() {
        String answer = calc.calculateAnnuity("22000", 7, "0.06", 1);
        assertEquals("$184,664.43", answer);
    }

    @Test
    void annuityPractice2() {
        String answer = calc.calculateAnnuity("1200", 10, "0.08", 4);
        assertEquals("$72,482.38", answer);
    }

    //Exercise 1
    @Test
    void annuityExercise1() {
        String answer = calc.calculateAnnuity("500", 5, "0.06", 12);
        assertEquals("$34,885.02", answer);
    }

    //Exercise 2
    // java.lang.ArithmeticException: Non-terminating decimal expansion;
    // no exact representable decimal result.
    //That's without BigDecimal.DECIMAL128
    @Test
    void annuityExercise2() {
        String answer = calc.calculateAnnuity("500", 5, "0.07", 12);
        assertEquals("$35,796.45", answer);
    }


}
