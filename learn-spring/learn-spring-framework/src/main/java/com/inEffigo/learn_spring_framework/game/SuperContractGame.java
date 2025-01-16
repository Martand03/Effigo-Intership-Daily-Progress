package com.inEffigo.learn_spring_framework.game;

public class SuperContractGame implements GamingConsole{
    public void upButton(){
        System.out.println("Up");
    }

    public void downButton(){
        System.out.println("Down");
    }

    public void leftButton(){
        System.out.println("Go back");
    }

    public void rightButton(){
        System.out.println("Shoot a bullet");
    }
}
