package com.inEffigo.spring_security_roles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping("/login")
    public String viewLogin(){
        return "login";
    }

    @GetMapping("/")
    public String welcome(){
        return "welcome";
    }

    @GetMapping("/admin")
    public String viewAdmin(){
        return "admin";
    }

    @GetMapping("/user")
    public String viewUsers(){
        return "users";
    }

    @GetMapping("/logout")
    public String viewLogout(){
        return "logout";
    }
}
