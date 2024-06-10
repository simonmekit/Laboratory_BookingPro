package org.simon.laboratory_bookingpro.controller;

import org.simon.laboratory_bookingpro.dto.UserDto;
import org.simon.laboratory_bookingpro.model.User;
import org.simon.laboratory_bookingpro.repositoryservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for accessing home page.
 * End points - /home, /
 */
@Controller
public class HomeController {

    private final UserService userService;

    @Autowired
    public HomeController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/")
    public String homepage(Model model){
       // model.addAttribute("userLogin", new User());
        return "redirect:/login";
    }



    @GetMapping("/home")
    public String displayHome(Model model){

        return "index";
    }
}
