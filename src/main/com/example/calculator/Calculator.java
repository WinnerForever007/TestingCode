package com.example.calculator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.NumberFormat;
import java.util.Locale;

public class Calculator {

    public Calculator() {
        System.out.println("Calculator's constructor");
    }

    public int add(int num1, int num2) {
        return Math.addExact(num1, num2);
    }

    public int subtract(int num1, int num2) {
        return num1 - num2;
    }

    public int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public int divide(int num1, int num2) {
        return num1 / num2;
    }

    public String calculateAnnuity(String deposit, int years,
                                   String annualRate, int periodsPerYear) {
        BigDecimal a = new BigDecimal(annualRate).divide(new BigDecimal(periodsPerYear),
                MathContext.DECIMAL128); // annualRate/periodsPerYear
        BigDecimal b = BigDecimal.ONE.add(a); // 1 + annualRate/periodsPerYear
        BigDecimal c = b.pow(periodsPerYear * years); // (1 + annualRate/periodsPerYear)^(periodsPerYear * years)
        BigDecimal d = c.subtract(BigDecimal.ONE); // ... - 1
        BigDecimal e = d.divide(a, MathContext.DECIMAL128); // ... / (annualRate/periodsPerYear)
        BigDecimal f = e.multiply(new BigDecimal(deposit)); // deposit * ...

        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(Locale.US);
        return currencyInstance.format(f);
    }
}
