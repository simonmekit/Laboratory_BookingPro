package org.simon.laboratory_bookingpro;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.simon.laboratory_bookingpro.dto.Booking;
import org.simon.laboratory_bookingpro.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

//@DataJpaTest
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class BookingRepositoryTest {

    @Autowired
    private BookingRepository bookingRepository;

    @Test
    public void testFindById() {
        // Save bookings to the repository
        Booking booking1 = new Booking();
        booking1.setId(2L);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking();
        booking2.setId(3L);
        bookingRepository.save(booking2);

        // Retrieve bookings by user ID
        List<Booking> bookings = bookingRepository.findAllById(1L);

        // Assert that the correct bookings were found
        assertThat(bookings.size()).isEqualTo(1);
        assertThat(bookings.get(0).getId()).isEqualTo(1L);
    }
}
