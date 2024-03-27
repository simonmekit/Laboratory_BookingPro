package org.simon.laboratory_bookingpro.controller;

import org.simon.laboratory_bookingpro.dto.Booking;
import org.simon.laboratory_bookingpro.service.BookingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking_api")
public class BookingRestController {

    private final BookingServiceImpl bookingService;

    @Autowired
    public BookingRestController(BookingServiceImpl bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/{id}")
    public List<Booking> getBooking(@PathVariable Long id){
    // List<Booking> bookings = bookingService.findBookingByUserId(id);
        return bookingService.findBookingByUserId(id);
     //   return bookings;
    }
    @DeleteMapping("/delete/{id}")
    public void deleteBooking(@PathVariable Long id){
        bookingService.deleteBookingById(id);
    }

    @GetMapping("/bookings")
    public List<Booking> getAllBookings(){
        return (List<Booking>) bookingService.findAll();
    }
}
