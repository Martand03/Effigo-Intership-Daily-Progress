package org.example.practice;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Practice02Test {

    int x = 2;
    int y = 2;
    int z = 3;

    boolean a = (x == y);
    boolean b = (y == z);

    // write a test that shows a is true

    @Test
    public void test1(){
        assertTrue(a);
    }

    // write a test to show b is false

    @Test
    public void test2(){
        assertFalse(b);
    }
}
