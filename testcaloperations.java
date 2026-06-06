package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class testcaloperations {

    @Test
    void testAddition() {
        int result = caloperations.add(10, 5);
        Assert.assertEquals(result, 15);
    }

    @Test
    void testSubtraction() {
        int result = caloperations.subtract(10, 3);
        Assert.assertEquals(result, 7);
    }

    @Test
    void testMultiplication() {
        int result = caloperations.multiply(4, 5);
        Assert.assertEquals(result, 20);
    }

    @Test
    void testDivision() {
        int result = caloperations.divide(20, 5);
        Assert.assertEquals(result, 4);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    void testDivisionByZero() {
        caloperations.divide(10, 0);
    }

    @Test
    void testModulus() {
        int result = caloperations.modulus(10, 3);
        Assert.assertEquals(result, 1);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    void testModulusByZero() {
        caloperations.modulus(10, 0);
    }
}
