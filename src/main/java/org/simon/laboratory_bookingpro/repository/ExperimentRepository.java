package org.simon.laboratory_bookingpro.repository;

import org.simon.laboratory_bookingpro.dto.Experiment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperimentRepository extends JpaRepository<Experiment, Long> {

}
