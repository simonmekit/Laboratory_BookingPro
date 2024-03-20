package org.simon.laboratory_bookingpro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String userLogin(Model model){

        return "login";
    }
    @PostMapping("/user_login")
    public void login(Model model){

    }
}