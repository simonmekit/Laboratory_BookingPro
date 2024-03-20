package org.simon.laboratory_bookingpro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @GetMapping("/register")
    public String register(){

        return "signup";
    }

    @PostMapping("/createUser")
    public void createUser(){

    }
}
