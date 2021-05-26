package com.javacamp.hrms.dataAccess.abstracts;

import com.javacamp.hrms.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployerDao extends JpaRepository<Employer, Integer> {

    Optional<Employer> findByEmail(String email);

}
