package org.simon.laboratory_bookingpro.repository;

import org.simon.laboratory_bookingpro.dto.LabLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<LabLocation, Long> {
public LabLocation findByName(String name);
public LabLocation findLabLocationByLocationCode(int code);
}
