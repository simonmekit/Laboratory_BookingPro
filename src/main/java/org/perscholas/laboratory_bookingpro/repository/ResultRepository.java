package org.perscholas.laboratory_bookingpro.repository;

import org.perscholas.laboratory_bookingpro.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {
    public Result findAllById(long id);
}
