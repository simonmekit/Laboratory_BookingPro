package org.simon.laboratory_bookingpro.model;

import jakarta.persistence.*;
import lombok.*;
import org.simon.laboratory_bookingpro.dto.Status;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private Long id;
    @Column(name = "firstName", nullable = false)
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "age")
    private int age;
    @Column(name = "gender")
    private String gender;
    @Column(name = "dob")
    private Date dob;
    @Column(name = "affilation")
    private String affiliation;
    @Column(name = "status")
    private Status status;

    @OneToMany(mappedBy = "labUser", cascade = CascadeType.ALL)
    private List<Booking> bookings;

    @OneToMany(mappedBy = "labUser", cascade = CascadeType.ALL)
    private List<AnalysisRequest> analysisRequests;
}
