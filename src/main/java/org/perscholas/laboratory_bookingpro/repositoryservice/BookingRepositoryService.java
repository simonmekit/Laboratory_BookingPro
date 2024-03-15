package org.perscholas.laboratory_bookingpro.repositoryservice;

import org.perscholas.laboratory_bookingpro.model.Booking;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingRepositoryService {
    public List<Booking> findBookingByUserId(long userId);
    public List<Booking> findBookingByLabLocation(long locationId);
    public void createBooking(Booking booking);
    public Booking findBookingByDateTime(LocalDateTime dateTime);
    public void deleteBookingById(long bookingId);
    public void deleteBookingByUserId(long userId);
    public void updateBookingById(long bookingId);
    public void updateBookingByUserId(long userId);

}
