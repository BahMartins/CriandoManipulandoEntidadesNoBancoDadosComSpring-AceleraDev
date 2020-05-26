package com.challenge.repository;

import com.challenge.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.id = :userId")
    Optional<User> findById(@Param("userId") Long userId);

    @Query("select c.id.user from Candidate c where c.id.acceleration.id = " +
            "(select a.id from Acceleration a where a .name like :name)")
    List<User> findByAccelerationName(@Param("name") String name);

    @Query("select c.id.user from Candidate c where c.id.company.id = :companyId")
    List<User> findByCompanyId(@Param("companyId") Long companyId);

}
