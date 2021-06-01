package com.javacamp.hrms.business.abstracts;

import com.javacamp.hrms.core.utilities.results.DataResult;
import com.javacamp.hrms.core.utilities.results.Result;
import com.javacamp.hrms.entities.concretes.JobPosting;

import java.util.List;

public interface JobPostingService {

    Result add(JobPosting jobPosting);

    DataResult<List<JobPosting>> getAll();

    DataResult<List<JobPosting>> getAllActiveJobsByDate();

    DataResult<List<JobPosting>> getAllActiveJobs();

    DataResult<List<JobPosting>> findActiveJobsByEmployerId(int id);

    Result changeStatus(int id);

}
