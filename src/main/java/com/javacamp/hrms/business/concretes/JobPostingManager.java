package com.javacamp.hrms.business.concretes;

import com.javacamp.hrms.business.abstracts.JobPostingService;
import com.javacamp.hrms.core.utilities.results.DataResult;
import com.javacamp.hrms.core.utilities.results.Result;
import com.javacamp.hrms.core.utilities.results.SuccessDataResult;
import com.javacamp.hrms.core.utilities.results.SuccessResult;
import com.javacamp.hrms.dataAccess.abstracts.JobPostingDao;
import com.javacamp.hrms.entities.concretes.JobPosting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPostingManager implements JobPostingService {

    private final JobPostingDao jobPostingDao;

    @Autowired
    public JobPostingManager(JobPostingDao jobPostingDao) {
        this.jobPostingDao = jobPostingDao;
    }

    @Override
    public Result add(JobPosting jobPosting) {
        jobPostingDao.save(jobPosting);

        return new SuccessResult("Job posting is added.");
    }

    @Override
    public DataResult<List<JobPosting>> getAll() {
        return new SuccessDataResult<>(
                jobPostingDao.findAll(),
                "Job postings successfully listed."
        );
    }

    @Override
    public DataResult<List<JobPosting>> getAllActiveJobsByDate() {
        return new SuccessDataResult<>(
                jobPostingDao.findByIsActiveTrueOrderByCreationDateDesc(),
                "Job postings successfully listed."
        );
    }

    @Override
    public DataResult<List<JobPosting>> getAllActiveJobs() {
        return new SuccessDataResult<>(
                jobPostingDao.findByIsActiveTrue(),
                "All active jobs are listed."
        );
    }

    @Override
    public DataResult<List<JobPosting>> findActiveJobsByEmployerId(int id) {

        return new SuccessDataResult<>(
                jobPostingDao.findByEmployer_IdAndIsActiveTrue(id),
                "Postings uccessfully listed"
        );
    }

    @Override
    public Result changeStatus(int id) {
        JobPosting jobPosting = jobPostingDao.findById(id);
        boolean isActive = jobPosting.isActive();
        jobPosting.setActive(!isActive);

        jobPostingDao.save(jobPosting);

        return new SuccessResult("Jobposting is now " + jobPosting.isActive());
    }
}
