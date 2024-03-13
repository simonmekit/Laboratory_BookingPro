package org.perscholas.laboratory_bookingpro.repository;

import org.perscholas.laboratory_bookingpro.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
    public Test findAllById(long id);
}
