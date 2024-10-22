package org.simon.laboratory_bookingpro.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Set;


/**
 * Model class store data about Analysis Result Entity.
 * Analysis result data is filled by the laboratory technician.
 * Users can access their own analysis information stored in the database after being authenticated.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "analysis_requests")
public class AnalysisRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_user_id")
    private UserDto labUserDto;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "fk_sample_id")
    private Set<Sample> samples;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_test_id")
    private Set<Test> tests;




    // toString method

    @Override
    public String toString() {
        return "AnalysisRequest{" +
                "id=" + id +
                ", labUserDto=" + labUserDto +
                ", samples=" + samples +
                ", tests=" + tests +
                '}';
    }
}
