package com.inEffigo.spring_security_basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/")

    public String hello(){
        return "welcome";
    }
}
