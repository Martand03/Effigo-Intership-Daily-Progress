package com.inEffigo.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String username, String password){
        return username.equals("Shiv") && password.equals("nandi");
    }
}
