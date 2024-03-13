package org.perscholas.laboratory_bookingpro.repositoryservice;

import org.perscholas.laboratory_bookingpro.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookingRepositoryImpl {
    private final BookingRepository bookingRepository;

    @Autowired
    public BookingRepositoryImpl(BookingRepository bookingRepository){
           this.bookingRepository = bookingRepository;
       }
}
