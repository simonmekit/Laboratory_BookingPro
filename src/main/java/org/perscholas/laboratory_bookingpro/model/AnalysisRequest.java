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
@Table(name = "analysisrequests")
public class AnalysisRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lab_user_id")
    private User labUser;

    @OneToMany(mappedBy = "analysisRequest", cascade = CascadeType.ALL)
    private List<Sample> samples;

    @OneToMany(mappedBy = "analysisRequest", cascade = CascadeType.ALL)
    private List<Test> tests;




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
