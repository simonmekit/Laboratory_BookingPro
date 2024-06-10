package org.simon.laboratory_bookingpro.repository;

import org.simon.laboratory_bookingpro.dto.Booking;
import org.simon.laboratory_bookingpro.dto.LabLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    public Booking findById(long id);
    public Booking findBookingByDateTime(LocalDateTime dateTime);

    List<Booking> findAllById(long id);

    List<Booking> findBookingByLabLocation(LabLocation location);

public Booking findBookingByDescription(String description);

}
