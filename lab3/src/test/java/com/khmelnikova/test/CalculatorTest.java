package com.khmelnikova.test;

import com.khmelnikova.calculatorlab.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeClass
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void testAddition() {
        Assert.assertEquals(calculator.calculate("22 + 4"), 26.0);
    }

    @Test
    public void testSubtraction() {
        Assert.assertEquals(calculator.calculate("22 - 4"), 18.0);
    }

    @Test
    public void testMultiplication() {
        Assert.assertEquals(calculator.calculate("22 * 4"), 88.0);
    }

    @Test
    public void testDivision() {
        Assert.assertEquals(calculator.calculate("21 / 7"), 3.0);
    }

    @Test
    public void testComplexExpression() {
        double result = calculator.calculate("4 * (10 + 16) - 12/2");
        double answer = 98.0;
        Assert.assertEquals(result, answer);
    }
    
    @Test(expectedExceptions = java.lang.ArithmeticException.class)
    public void testDivideByZero() {
        calculator.calculate("22 / 0");
    }
}