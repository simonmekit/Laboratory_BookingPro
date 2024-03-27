package org.simon.laboratory_bookingpro.controller;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.simon.laboratory_bookingpro.dto.Booking;
import org.simon.laboratory_bookingpro.dto.BookingDto;
import org.simon.laboratory_bookingpro.dto.LabLocation;
import org.simon.laboratory_bookingpro.dto.UserDto;
import org.simon.laboratory_bookingpro.model.User;
import org.simon.laboratory_bookingpro.repositoryservice.BookingService;
import org.simon.laboratory_bookingpro.repositoryservice.UserService;
import org.simon.laboratory_bookingpro.service.LabLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookingController {

    private final BookingService bookingService;
    private final UserService userService;

    private final LabLocationService locationService;

    @Autowired
    public BookingController(BookingService bookingService, UserService userService, LabLocationService locationService) {
        this.bookingService = bookingService;
        this.userService = userService;
        this.locationService = locationService;
    }

    @GetMapping("/booking")
    public String createBooking(Model model) {
       // model.addAttribute("labUser", new UserDto());
        model.addAttribute("booking", new BookingDto());
        return "createBook";
    }

    @PostMapping("/saveBooking")
    public String saveBooking(@ModelAttribute("booking") BookingDto bookingDto) {

      //  System.out.println(booking.toString());

        bookingService.createBooking(bookingDto, bookingDto.getLabLocationCode());
//            String message = null;
//            model.addAttribute("message", message);

        return "index";
    }

    @GetMapping("/viewBookings")
    public String getBookings(Model model){
        List<Booking> bookings = bookingService.findAll();
        model.addAttribute("bookings", bookings);
        return "viewBookings";
    }

    }
