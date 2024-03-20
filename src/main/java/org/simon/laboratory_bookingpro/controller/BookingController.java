package org.simon.laboratory_bookingpro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class BookingController {

    @GetMapping("/booking")
    public String createBooking(Model model){

        return "createBook";
    }
    @PostMapping("/saveBooking")
        public void saveBooking(){
        //booking details
    }
}
