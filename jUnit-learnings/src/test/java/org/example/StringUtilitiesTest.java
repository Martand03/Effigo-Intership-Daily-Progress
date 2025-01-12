package org.example;

import junit.framework.TestCase;

public class StringUtilitiesTest extends TestCase {

    public void testVowelCount() {
        String s = "hello";
        String t = "xyz";
        String u = "";
        StringUtilities utilities = new StringUtilities();
        assertEquals(2, utilities.vowelCount(s));
        assertEquals(0, utilities.vowelCount(t));
        assertEquals(0, utilities.vowelCount(u));
        assertEquals(0, utilities.vowelCount(null));
    }
}