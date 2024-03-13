package org.perscholas.laboratory_bookingpro.repository;

import org.perscholas.laboratory_bookingpro.model.Experiment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperimentRepository extends JpaRepository<Experiment, Long> {

}
