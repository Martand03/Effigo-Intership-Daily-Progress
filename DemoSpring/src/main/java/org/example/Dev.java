package org.example;

public class Dev {

    private int age;
    private Laptop laptop;

    public Dev(){
        System.out.println("Dev Constructor");
    }

    // constructor injection
    public Dev(int age){
        this.age = age;
    }

//    public Dev(laptop laptop){
//        this.laptop = laptop;
//        System.out.println("Dev parameter constructor");
//    }
//    public Laptop getLaptop() {
//        return laptop;
//    }
//
//    public void setLaptop(Laptop laptop) {
//        this.laptop = laptop;
//    }

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

