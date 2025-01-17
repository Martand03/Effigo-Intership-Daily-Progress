package com.inEffigo.learn_spring_framework.game.examples.d1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class ClassA{

}

@Component
@Lazy
class ClassB{

    private ClassA classA;

    public ClassB(ClassA classA){
        System.out.println("Some Initialisation logic");
        this.classA = classA;
    }
    public void doSomething(){
        System.out.println("Do something");
    }
}

@Configuration
@ComponentScan
public class LazyInitialisationLauncherApplication {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(LazyInitialisationLauncherApplication.class);

        System.out.println("Initialisation of context is completed");

        context.getBean(ClassB.class).doSomething();
    }
}