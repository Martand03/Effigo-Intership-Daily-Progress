package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        // Load the Spring configuration file
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get the bean from the Spring container
        Dev obj = (Dev) context.getBean("dev");

//        obj.age = 18;
//        obj.setAge(18); // to do this with the help of spring add the property tag in th xml file for the bean
        System.out.println(obj.getAge());

        // Call a method on the bean
        obj.build();
    }
}
