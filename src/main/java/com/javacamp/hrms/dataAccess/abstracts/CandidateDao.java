package com.javacamp.hrms.dataAccess.abstracts;

import com.javacamp.hrms.entities.concretes.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CandidateDao extends JpaRepository<Candidate, Integer> {

    Optional<Candidate> findByEmail(String email);
    Optional<Candidate> findByIdentityNumber(String identityNumber);
}
