package com.inEffigo.rest.webservices.restful_web_services.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// rest api
@RestController
public class HelloWorldController {

//    @RequestMapping(method = RequestMethod.GET,path = "/hello-world")
    @GetMapping(path = "hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping(path = "hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");
    }

    @GetMapping(path = "hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(String name){
        return new HelloWorldBean(String.format("HelloWorld, %s", name));
    }

}
