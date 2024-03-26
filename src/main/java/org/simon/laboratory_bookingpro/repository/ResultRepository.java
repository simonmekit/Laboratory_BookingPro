package org.simon.laboratory_bookingpro.repository;

import org.simon.laboratory_bookingpro.dto.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {
    public List<Result> findAllById(long id);
}
