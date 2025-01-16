package com.inEffigo.learn_spring_framework.test;

import java.io.Serializable;

public class SpringBeanvsJavaBean {
    public static void main(String[] args) {

        Pojo pojo = new Pojo();
        System.out.println(pojo);
    }
}
class Pojo{
    private String text;
    private int number;
    public String toString(){
        return text + ":" + number;
    }
}

class JavaBean implements Serializable {
    //EJB enterprise java beans
    // 3 restrictions
    //1: no-arg constructor

    public JavaBean(){

    }

    //2: to have getters and setters
    private String text;
    private int number;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    //3: should implement serializable
}
