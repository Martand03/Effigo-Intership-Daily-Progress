package com.inEffigo.learn_spring_framework.helloWorld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// record feature from jdk-16 reduces the work of making getters, setters, etc
record Person (String name, int age, Address address){};
record Address (String address, String city){};

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name(){
        return "Akash";
    }

    @Bean
    public int age(){
        return 20;
    }

    @Bean
    public Person person(){
        return new Person("Ravi", 20, new Address("Miyapur", "Hyderabad"));
    };

    @Bean
    public Person person2MethodCall(){
        return new Person(name(), age(), address()); // using name, age beans
    };

    @Bean
    public Person person3Parameters(String name, int age, Address address2){
        // parameters: name, age, address2
        return new Person(name, age, address2); // using name, age beans
    };

    @Bean
    public Person person4Qualifier(String name, int age, @Qualifier("address3Qualifier") Address address3){
        // parameters: name, age, address2
        return new Person(name, age, address3); // using name, age beans
    };

    @Bean(name = "address2") // to give custom name
    @Primary
    public Address address(){
        return new Address("Kondapur", "Hyderabad");
    };

    @Bean
    @Qualifier("address3Qualifier")
    public Address address3(){
        return new Address("SriRamNager", "Hyderabad");
    };

}
