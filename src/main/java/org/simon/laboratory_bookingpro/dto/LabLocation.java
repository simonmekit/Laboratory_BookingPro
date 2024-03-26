package org.simon.laboratory_bookingpro.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lablocations")
public class LabLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int locationCode;

    public LabLocation(String name, int locationCode){
        this.name = name;
        this.locationCode = locationCode;
    }

    @OneToMany(mappedBy = "labLocation")
    private List<Booking> bookings;
}
