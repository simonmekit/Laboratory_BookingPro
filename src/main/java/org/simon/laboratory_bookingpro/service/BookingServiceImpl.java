package org.simon.laboratory_bookingpro.service;

import org.simon.laboratory_bookingpro.model.Booking;
import org.simon.laboratory_bookingpro.repository.BookingRepository;
import org.simon.laboratory_bookingpro.repositoryservice.BookingRepositoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingRepositoryService {
    private final BookingRepository bookingRepository;
    private static final Logger logger = LoggerFactory.getLogger(BookingServiceImpl.class);
    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository){
           this.bookingRepository = bookingRepository;
       }

    @Override
    public List<Booking> findBookingByUserId(long userId) {

        return bookingRepository.findAllById(userId);
    }

    @Override
    public List<Booking> findBookingByLabLocation(long locationId) {
        return null;
    }

    @Override
    public void createBooking(Booking booking) {
    if(isBookingExists(booking)){
       // System.out.println("booking already created");
        logger.error("booking already created");
    }
    else {
        bookingRepository.save(booking);
    }
    }

    @Override
    public Booking findBookingByDateTime(String dateTime) {
        Booking booking = bookingRepository.findBookingByDateTime(dateTime);
        return null;
    }

    @Override
    public void deleteBookingById(long bookingId) {

    }

    @Override
    public void deleteBookingByUserId(long userId) {

    }

    @Override
    public void updateBookingById(long bookingId) {

    }

    @Override
    public void updateBookingByUserId(long userId) {

    }

    private boolean isBookingExists(Booking booking) {
        List<Booking> bookings = bookingRepository.findAll();
        for(Booking b: bookings){
            if (b.getLabUser().equals(booking.getLabUser()) && b.getDateTime().equals(booking.getDateTime()))
                return true;
        }
        return false;
    }

}
