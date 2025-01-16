package com.inEffigo.learn_spring_framework.game;

import org.springframework.stereotype.Component;

@Component
public class PacManGame implements GamingConsole{
    public void upButton(){
        System.out.println("Up");
    }

    public void downButton(){
        System.out.println("Down");
    }

    public void leftButton(){
        System.out.println("Left");
    }

    public void rightButton(){
        System.out.println("Right");
    }
}
