package org.perscholas.laboratory_bookingpro.service;

import org.perscholas.laboratory_bookingpro.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository){
           this.bookingRepository = bookingRepository;
       }
}
