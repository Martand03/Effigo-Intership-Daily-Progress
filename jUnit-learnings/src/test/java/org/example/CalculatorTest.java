package org.example;

import junit.framework.TestCase;

public class CalculatorTest extends TestCase {

    private final Calculator calc = new Calculator();

    public void testAdd() {
        assertEquals(5, calc.add(2,3) );
    }
}