package org.simon.laboratory_bookingpro.controller;

import org.simon.laboratory_bookingpro.dto.UserDto;
import org.simon.laboratory_bookingpro.model.User;
import org.simon.laboratory_bookingpro.repository.UserRepository;
import org.simon.laboratory_bookingpro.repositoryservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/login")
    public String userLogin(Model model){
    model.addAttribute("userLogin", new User());
        return "login";
    }
    @PostMapping("/user_login")
    public String login(@ModelAttribute User currentUser, Model model){
        model.addAttribute("userLogin", new User());
    UserDto user = userService.findUserByEmail(currentUser.getEmail());
    if (user != null){
        if (user.getPassword().equals(currentUser.getPassword()))
            return "index";
        else
            return "login";
    }
    else
        return "login";
    }
}