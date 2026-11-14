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

    public String calculateAnnuity(String R, int t, String r, int n) {
        BigDecimal a = new BigDecimal(r).divide(new BigDecimal(n),
                MathContext.DECIMAL128); // r/n
        BigDecimal b = BigDecimal.ONE.add(a); // 1 + r/n
        BigDecimal c = b.pow(n * t); // (1 + r/n)^(n * t)
        BigDecimal d = c.subtract(BigDecimal.ONE); // ... - 1
        BigDecimal e = d.divide(a, MathContext.DECIMAL128); // ... / (r/n)
        BigDecimal f = e.multiply(new BigDecimal(R)); // R * ...

        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(Locale.US);
        return currencyInstance.format(f);
    }
}
