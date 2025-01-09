package com.effigo.MyApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Dev {

//    @Autowired // field injection
//    private Laptop laptop;


    // constructor injection
//    public Dev(Laptop laptop){
//        this.laptop = laptop;
//    }

    // setter injection
//    @Autowired
//    public void setLaptop(Laptop laptop){
//        this.laptop = laptop;
//    }

    @Autowired
    @Qualifier("laptop") // if you dont want to use @Primary

    private Computer comp;


    public void build(){
        System.out.println("Working!!!");
        comp.compile();
    }
}
