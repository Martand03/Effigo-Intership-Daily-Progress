package com.inEffigo.learn_spring_framework.helloWorld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class App02HelloWorldSpring {
    public static void main(String[] args) {

        //1: launch a spring context :-
        var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

        //2: configure the things that we want spring to manage -@Configuration
        //HelloWorldConfiguration class for configurations
        // name : @Bean

        //3: retrieve the value managed by spring
        System.out.println(context.getBean("name"));
        System.out.println(context.getBean("age"));
        System.out.println(context.getBean("person"));
        System.out.println(context.getBean("address2"));
        System.out.println(context.getBean(Address.class));
        System.out.println(context.getBean("person2MethodCall"));
        System.out.println(context.getBean("person3Parameters"));
        //System.out.println(context.getBean(Person.class)); // gives error for 3 matching type beans
        // to solve use @Primary annotation or use @Qualifier
        System.out.println(context.getBean(Address.class)); // gives error for 2 matching type beans
        // to get beans list
        System.out.println("Beans list: ");
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        System.out.println(context.getBean("person4Qualifier"));
    }
}
