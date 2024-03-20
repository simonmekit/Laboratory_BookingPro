package org.simon.laboratory_bookingpro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.simon.laboratory_bookingpro.dto.UserDto;

@Controller
public class BookingController {

    @GetMapping("/booking")
    public String createBooking(Model model){

        return "createBook";
    }
    @PostMapping("/saveBooking")
        public void saveBooking(@ModelAttribute UserDto userDto, Model model){

    }
}
