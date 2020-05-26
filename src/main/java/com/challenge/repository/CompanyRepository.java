package com.challenge.repository;

import com.challenge.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query("select c from Company c where c.id = :id")
    Optional<Company> findById(@Param("id") Long id);

    @Query("select distinct c.id.company from Candidate c where c.id.acceleration.id = :accelerationId ")
    List<Company> findByAccelerationId(@Param("accelerationId") Long accelerationId);

    @Query("select distinct c.id.company from Candidate c where c.id.user.id = :userId")
    List<Company> findByUserId(@Param("userId") Long userId);

}
