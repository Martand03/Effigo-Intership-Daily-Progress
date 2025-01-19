package com.inEffigo.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

//    private Logger logger = LoggerFactory.getLogger(getClass());

    // localhost:8085/login?name=Shiv
//    @RequestMapping("login")
//    public String gotoLoginPage(@RequestParam String name, ModelMap model){
//        model.put("name",name);
//        logger.debug("Logger Request param: {} ",name); //for debug level
//        logger.info("Logger Request param: {} ",name); // for info level: levels can be changed in application .properties file
//        System.out.println("Request param: " + name); // not recommended for prod level
//        return "login";
//    }

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String gotoLoginPage(){
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model){
        model.put("name", name);
        // authentication
        // name: Shiv password: nandi
        if(authenticationService.authenticate(name, password)){
            return "welcome";
        }
        model.put("error", "Wrong username or password");
        return "login";
    }

}
