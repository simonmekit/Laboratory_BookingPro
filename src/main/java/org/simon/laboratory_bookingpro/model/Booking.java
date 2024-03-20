package org.simon.laboratory_bookingpro.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

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

    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    private User labUser;

    @ManyToOne
    @JoinColumn(name = "fk_location_id")
    private LabLocation labLocation;

    private LocalDateTime dateTime;
}
