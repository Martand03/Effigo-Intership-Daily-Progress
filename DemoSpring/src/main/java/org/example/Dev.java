package org.example;

public class Dev {

    private int age;


    // constructor injection
    public Dev(int age){
        this.age = age;
    }

    // settter injection
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void build(){
        System.out.println("Working!!!");
    }
}

