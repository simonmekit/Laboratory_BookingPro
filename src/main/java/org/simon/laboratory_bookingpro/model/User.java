package org.simon.laboratory_bookingpro.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.simon.laboratory_bookingpro.dto.AnalysisRequest;
import org.simon.laboratory_bookingpro.dto.Booking;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private int age;

    private String gender;

    private LocalDate dob;

    private String affiliation;

    private String password;

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
                ", password='" + password + '\''+
                '}';
    }
}
