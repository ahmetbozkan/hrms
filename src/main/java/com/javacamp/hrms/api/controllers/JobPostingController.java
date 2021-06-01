package com.javacamp.hrms.api.controllers;

import com.javacamp.hrms.business.abstracts.JobPostingService;
import com.javacamp.hrms.core.utilities.results.DataResult;
import com.javacamp.hrms.core.utilities.results.Result;
import com.javacamp.hrms.entities.concretes.JobPosting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobPostings")
public class JobPostingController {

    private final JobPostingService jobPostingService;

    @Autowired
    public JobPostingController(JobPostingService jobPostingService) {
        this.jobPostingService = jobPostingService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobPosting jobPosting) {
        return jobPostingService.add(jobPosting);
    }

    @GetMapping("/getall")
    public DataResult<List<JobPosting>> getAll() {
        return jobPostingService.getAll();
    }

    @GetMapping("/getAllActiveJobsByDate")
    public DataResult<List<JobPosting>> getAllActiveJobsByDate() {
        return jobPostingService.getAllActiveJobsByDate();
    }

    @GetMapping("/getAllActiveJobs")
    public DataResult<List<JobPosting>> getAllActiveJobs() {
        return jobPostingService.getAllActiveJobs();
    }

    @GetMapping("/findActiveJobsByEmployerId")
    public DataResult<List<JobPosting>> findActiveJobsByEmployerId(int id) {
        return jobPostingService.findActiveJobsByEmployerId(id);
    }

    @PostMapping("/changeStatus")
    public Result changeStatus(int id) {
        return jobPostingService.changeStatus(id);
    }

}
