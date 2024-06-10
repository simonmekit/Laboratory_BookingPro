package org.simon.laboratory_bookingpro.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NamedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.simon.laboratory_bookingpro.LaboratoryBookingProApplication;
import org.simon.laboratory_bookingpro.dto.Booking;
import org.simon.laboratory_bookingpro.dto.BookingDto;
import org.simon.laboratory_bookingpro.dto.LabLocation;
import org.simon.laboratory_bookingpro.dto.UserDto;
import org.simon.laboratory_bookingpro.exception.RepositoryException;
import org.simon.laboratory_bookingpro.repository.BookingRepository;
import org.simon.laboratory_bookingpro.repository.LocationRepository;
import org.simon.laboratory_bookingpro.repositoryservice.BookingService;
import org.simon.laboratory_bookingpro.repositoryservice.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final UserService userService;
    private final LabLocationService labLocationService;
    //private final SessionFactory sessionFactory;
    private final EntityManager entityManager;

    private static final Logger logger = LoggerFactory.getLogger(BookingServiceImpl.class);

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository,
                              UserService userService, LabLocationService labLocationService, EntityManager entityManager){
           this.bookingRepository = bookingRepository;
        this.userService = userService;
        this.labLocationService = labLocationService;

        this.entityManager = entityManager;
    }

    @Override
    public List<Booking> findBookingByUserId(long userId) {
        try  {
            Session session = entityManager.unwrap(Session.class);
            UserDto userDto = userService.getUserByUserId(userId);
            List<Booking> bookings;

            try {
                if (userDto != null) {
                   // String query = "FROM Booking bk where bk.labUserDto =: labUser";

                    //return session.createQuery(query, Booking.class).setParameter("labUser", userDto).getResultList();
                    //bookings = bookingRepository.findAllById(userId);
                    bookings = userDto.getBookings();
                    return bookings;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        throw new RuntimeException("Booking information not found");
    }


    public List<Booking> findBookingByLabLocation(int locationCode) {
        LabLocation location = labLocationService.getLabLocationByCode(locationCode);
        return bookingRepository.findBookingByLabLocation(location);
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
    @Transactional
    public void createBooking(BookingDto bookingDto, int labLocationCode){

        try {
            UserDto labUser = userService.findUserByEmail("admin@admin.com");
            LabLocation labLocation = labLocationService.getLabLocationByCode(labLocationCode);
            /** Using model mapper helps to avoid extra coding
             * @param userDTO
             */

            ModelMapper modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            Booking booking1 = modelMapper.map(bookingDto, Booking.class);
            booking1.setLabUserDto(labUser);
            booking1.setLabLocation(labLocation);

            bookingRepository.save(booking1);
        }
        catch (Exception e) {
            throw new RepositoryException("Invalid booking details.");
        }

    }
    @Override
    public Booking findBookingByDateTime(LocalDateTime dateTime) {
        Booking booking = bookingRepository.findBookingByDateTime(dateTime);
        return null;
    }

    @Override
    public void deleteBookingById(long bookingId) {
    bookingRepository.deleteById(bookingId);
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

    /**
     * @return
     */
    @Override
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    /**
     * @param description
     * @return
     */
    @Override
    public Booking findBookingByDescription(String description) {
        return bookingRepository.findBookingByDescription(description);
    }


    private boolean isBookingExists(Booking booking) {
       if(booking != null) {
           List<Booking> bookings = bookingRepository.findAll();
           for (Booking b : bookings) {
               if (b != null) {
                   if (b.getLabUserDto().equals(booking.getLabUserDto()) && b.getDateTime().equals(booking.getDateTime()))
                       return true;
               }
           }
       }
        return false;
    }

}
