package org.simon.laboratory_bookingpro.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Model class to store lab users booking information.
 * This is the core functionality of the system.
 * Contains attributes and associations with other entity objects
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;

    private int labLocationCode;

    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    private UserDto labUserDto;

    @ManyToOne
    @JoinColumn(name = "fk_location_id")
    private LabLocation labLocation;

    private LocalDateTime dateTime;
}
