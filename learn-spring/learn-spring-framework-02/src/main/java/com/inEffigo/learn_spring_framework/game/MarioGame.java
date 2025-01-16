package com.inEffigo.learn_spring_framework.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MarioGame implements GamingConsole {

    public void upButton(){
        System.out.println("Jump");
    }

    public void downButton(){
        System.out.println("Go into a hole");
    }

    public void leftButton(){
        System.out.println("Go back");
    }

    public void rightButton(){
        System.out.println("Accelerate");
    }
}
