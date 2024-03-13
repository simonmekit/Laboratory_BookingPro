package org.perscholas.laboratory_bookingpro.repository;

import org.perscholas.laboratory_bookingpro.model.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleRepository extends JpaRepository<Sample, Long> {
    public Sample findAllById(long id);
}
