package org.example;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssertTrueTheoryTest {
    @Test
    public void test1(){
        assertTrue(true);
    }

    @Test
    public void test2(){
        assertTrue(2 == 2);
    }

    @Test
    public void test3(){
        assertTrue("xyz".length() == 3);
    }
}
