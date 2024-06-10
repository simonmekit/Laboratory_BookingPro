package org.simon.laboratory_bookingpro.repositoryservice;

import org.simon.laboratory_bookingpro.dto.Booking;
import org.simon.laboratory_bookingpro.dto.BookingDto;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingService {
public List<Booking> findBookingByUserId(long userId);
public void createBooking(Booking booking);
public void createBooking(BookingDto bookingDto, int locationCode);
public Booking findBookingByDateTime(LocalDateTime dateTime);
public void deleteBookingById(long bookingId);
public void deleteBookingByUserId(long userId);
public void updateBookingById(long bookingId);
public void updateBookingByUserId(long userId);
public List<Booking> findAll();
public Booking findBookingByDescription(String description);
}
