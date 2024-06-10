package org.simon.laboratory_bookingpro;

import org.junit.jupiter.api.Test;
import org.simon.laboratory_bookingpro.dto.Booking;
import org.simon.laboratory_bookingpro.dto.BookingDto;
import org.simon.laboratory_bookingpro.dto.UserDto;
import org.simon.laboratory_bookingpro.repositoryservice.UserService;
import org.simon.laboratory_bookingpro.service.BookingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class BookingServiceTest {

    @Autowired
    private BookingServiceImpl bookingService;

    @Test
    public void testFindById() {
        // Save a user to the repository
        Booking booking = new Booking();

        String desc = "My Booking";
       // booking.setLabLocationCode(2000);
        booking.setDescription(desc);
        bookingService.createBooking(booking);

        // Retrieve the user by username
        //List<Booking> found = bookingService.findBookingByLabLocation(2000);
    Booking found = bookingService.findBookingByDescription(desc);
        // Assert that the user was found
        assertThat(found).isNotNull();
        assertThat(found.getDescription()).isEqualTo(desc);
        //assertThat(found.get(0).getLabLocationCode()).isEqualTo(2000);
    }
}
