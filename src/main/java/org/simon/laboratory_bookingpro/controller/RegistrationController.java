package org.simon.laboratory_bookingpro.controller;

import org.simon.laboratory_bookingpro.dto.UserDto;
import org.simon.laboratory_bookingpro.model.User;
import org.simon.laboratory_bookingpro.repositoryservice.UserService;
import org.simon.laboratory_bookingpro.service.BookingServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    private final UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(BookingServiceImpl.class);

    private BCryptPasswordEncoder passwordEncoder;



    @Autowired
    public RegistrationController(UserService userService, BCryptPasswordEncoder passwordEncoder){
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String register(Model model){
    model.addAttribute("userForm", new UserDto());
   // model.addAttribute("userLogin", new UserDto());
        return "signup";
    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute UserDto userDto, Model model){
        //System.out.println(userDto.toString());
        String message = null;
        if (userDto.getPassword().equals(userDto.getMatchingPassword())) {
            String password = passwordEncoder.encode(userDto.getPassword());
            userDto.setPassword(password);
            userDto.setMatchingPassword(password);
           message = String.valueOf(userService.createUser(userDto));
           // message = "UserDto created successfully!";
        }
        else{
         message = "Password doesn't match!";
            logger.error(message);
        }
        model.addAttribute("message", message);
        model.addAttribute("userLogin", new UserDto());
        return "index";
    }

}
