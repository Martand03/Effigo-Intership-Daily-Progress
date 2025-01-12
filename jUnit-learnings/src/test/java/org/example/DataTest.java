package org.example;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataTest {

    static ArrayList<Integer> numberList;
    static URL path;
    static File file;
    static Scanner scanner;

    @BeforeAll
    public static void init() throws FileNotFoundException {

        numberList = new ArrayList<Integer>();
        path = DataTest.class.getResource("numbers.txt");
        assert path != null;
        file = new File(path.getFile());
        scanner = new Scanner(file);
        while(scanner.hasNext()){
            Integer i = Integer.parseInt(scanner.next());
            numberList.add(i);
        }
        System.out.println("numberList: " + numberList);
    }

    @Test
    void testFindLargest() {
        int computedVal = Data.findLargest(numberList);
        int expectedVal = 40;
        assertEquals(expectedVal, computedVal);
    }

   @AfterAll
   public static void tearDown(){
     scanner.close();
   }
}