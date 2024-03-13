package org.perscholas.laboratory_bookingpro.model;

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

    @OneToMany(mappedBy = "experiment", cascade = CascadeType.ALL)
    private List<Sample> samples;

    @OneToMany(mappedBy = "experiment", cascade = CascadeType.ALL)
    private List<Test> tests;

    @ManyToOne
    @JoinColumn(name = "lab_location_id")
    private LabLocation labLocation;
}
