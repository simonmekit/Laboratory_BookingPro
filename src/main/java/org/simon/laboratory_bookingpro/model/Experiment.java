package org.simon.laboratory_bookingpro.model;

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
@Table(name = "experiments")
public class Experiment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany
    @JoinColumn(name = "fk_sample_id")
    private List<Sample> samples;

    @OneToMany
    @JoinColumn(name = "fk_test_id")
    private List<Test> tests;

    @ManyToOne
    @JoinColumn(name = "fk_location_id")
    private LabLocation labLocation;
}
