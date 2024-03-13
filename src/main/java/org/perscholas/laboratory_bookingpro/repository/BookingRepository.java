package org.perscholas.laboratory_bookingpro.repository;

import org.perscholas.laboratory_bookingpro.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    public Booking findById(long id);
    public List<Booking> findAllByDateTime(LocalDateTime dateTime);
}
