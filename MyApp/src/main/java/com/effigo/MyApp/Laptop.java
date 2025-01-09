package com.effigo.MyApp;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component // to instantiate the laptop object
//@Primary  // to avoid confusion of 2 beans: desktop & laptop
public class Laptop implements Computer {
    public void compile(){
        System.out.println("Compiling...");
    }
}
