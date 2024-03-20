package org.simon.laboratory_bookingpro.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserDto {
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
    private LocalDate dob;
    @Column(name = "affilation")
    private String affiliation;

    @Column(name = "password")
    @NotEmpty(message = "Required")
    private String password;
    @Column(name = "matchingPassword")
    private String matchingPassword;

    @OneToMany(mappedBy = "labUserDto", cascade = CascadeType.ALL)
    private List<Booking> bookings;

    @OneToMany(mappedBy = "labUserDto", cascade = CascadeType.ALL)
    private List<AnalysisRequest> analysisRequests;

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", dob=" + dob.toString() +
                ", affiliation='" + affiliation + '\'' +
                ", password='" + password + '\'' +
                ", bookings=" + bookings +
                ", analysisRequests=" + analysisRequests +
                '}';
    }
}
