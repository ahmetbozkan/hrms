package com.javacamp.hrms.dataAccess.abstracts;

import com.javacamp.hrms.entities.concretes.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer> {

    JobPosting findById(int id);

    List<JobPosting> findByIsActiveTrue();

    List<JobPosting> findByIsActiveTrueOrderByCreationDateDesc();

    List<JobPosting> findByEmployer_IdAndIsActiveTrue(int employerId);
}
