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

//@RestController
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

//    @PostMapping("/user_login")
//    public String login(@ModelAttribute User currentUser, Model model){
//        model.addAttribute("userLogin", new User());
//        String message = null;
//        UserDto user = userService.findUserByEmail(currentUser.getEmail());
//
//        if (user != null){
//            if (user.getPassword().equals(currentUser.getPassword())) {
//                message = "Welcome!";
//                model.addAttribute("loginMessage", message);
//                return "index";
//            }
//
//            else{
//                 message = "Invalid username or password!";
//                model.addAttribute("loginMessage", message);
//                 return "index";
//            }
//        }
//
//        else {
//         message = "User name doesn't exist!";
//            model.addAttribute("loginMessage", message);
//         return "index";
//        }
//
//    }

    @GetMapping("/home")
    public String displayHome(Model model){

        return "index";
    }
}
