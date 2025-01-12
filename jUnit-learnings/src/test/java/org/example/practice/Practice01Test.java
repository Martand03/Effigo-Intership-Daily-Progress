package org.example.practice;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Practice01Test {
    int x = 2;
    int y = 2;
    int z = 3;

    // write a test method with asserts that shows x and y are equal

    @Test
    public void  test1(){
        assertEquals(x , y);
    }

    // write a test method that shows y and z are not equal using assert

    @Test
    public void test2(){
        assertNotEquals(y , z);
    }

}
