package org.simon.laboratory_bookingpro.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;
import java.util.Set;

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
    private User labUser;

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
                ", labUser=" + labUser +
                ", samples=" + samples +
                ", tests=" + tests +
                '}';
    }
}
