package org.simon.laboratory_bookingpro.controller;

import org.simon.laboratory_bookingpro.model.User;
import org.simon.laboratory_bookingpro.repositoryservice.BookingService;
import org.simon.laboratory_bookingpro.repositoryservice.UserService;
import org.simon.laboratory_bookingpro.service.BookingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.simon.laboratory_bookingpro.dto.UserDto;

@Controller
public class BookingController {

    private final BookingService bookingService;
    private final UserService userService;

@Autowired
    public BookingController(BookingService bookingService, UserService userService){
        this.bookingService = bookingService;
        this.userService = userService;
    }

    @GetMapping("/booking")
    public String createBooking(Model model){
    model.addAttribute("labUser", new UserDto());
        return "createBook";
    }
    @PostMapping("/saveBooking")
    public String saveBooking(@ModelAttribute User user, Model model){
    UserDto myUser = userService.findUserByPhone(user.getPhoneNumber());
    String message = null;
    if (myUser != null){
        message = "User found";
        model.addAttribute("laboratoryUser", myUser);
        model.addAttribute("message", message);
    }
    else {
        message = "User not found!";
        model.addAttribute("laboratoryUser", new User());
        model.addAttribute("message", message);
    }
    return "createBook";
    }
}
