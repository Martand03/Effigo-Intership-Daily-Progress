package com.inEffigo.spring_security_custom.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
    }
    @GetMapping("/login")
    public String viewLogin(){
        return "login";
    }
    @GetMapping("/logout")
    public String viewLogout(){
        return "logout";
    }
}
