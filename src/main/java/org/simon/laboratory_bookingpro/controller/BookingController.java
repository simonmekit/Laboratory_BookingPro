package org.simon.laboratory_bookingpro.controller;

import org.simon.laboratory_bookingpro.dto.Booking;
import org.simon.laboratory_bookingpro.dto.LabLocation;
import org.simon.laboratory_bookingpro.dto.UserDto;
import org.simon.laboratory_bookingpro.model.User;
import org.simon.laboratory_bookingpro.repositoryservice.BookingService;
import org.simon.laboratory_bookingpro.repositoryservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookingController {

    private final BookingService bookingService;
    private final UserService userService;

    @Autowired
    public BookingController(BookingService bookingService, UserService userService) {
        this.bookingService = bookingService;
        this.userService = userService;
    }

    @GetMapping("/booking")
    public String createBooking(Model model) {
        model.addAttribute("labUser", new UserDto());
        model.addAttribute("booking", new Booking());
        return "createBook";
    }

    @PostMapping("/findUser")
    public String findUser(@ModelAttribute User user, Model model) {
        UserDto myUser = userService.findUserByEmail(user.getEmail());

        System.out.println(myUser.toString());

//    String message = null;
//    if (myUser != null){
//        message = "User found";
//        model.addAttribute("laboratoryUser", myUser);
//        model.addAttribute("message", message);
//    }
//    else {
//        message = "User not found!";
//        model.addAttribute("laboratoryUser", new User());
//        model.addAttribute("message", message);
//    }
        Booking booking = new Booking();
        booking.setLabUserDto(myUser);
        model.addAttribute("booking", booking);
        model.addAttribute("labUser", new UserDto());

        return "createBook";
    }

    @PostMapping("/saveBooking")
    public String saveBooking(@ModelAttribute Booking booking, Model model) {

        System.out.println(booking.toString());

        LabLocation location = new LabLocation();
        location.setName(booking.getLabLocation().toString());
        booking.setLabLocation(location);
        bookingService.createBooking(booking);
//            String message = null;
//            model.addAttribute("message", message);

        return "index";
    }

}
