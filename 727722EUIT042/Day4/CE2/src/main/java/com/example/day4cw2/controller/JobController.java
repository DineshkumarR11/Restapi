package com.example.day4cw2.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.day4cw2.model.Job;
import com.example.day4cw2.services.JobService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class JobController {
    public JobService jobService;
    public JobController(JobService jobService)
    {
        this.jobService = jobService;
    }
    @PostMapping("/api/job")
    public ResponseEntity<Job> postMethodName(@RequestBody Job job) {
        if(jobService.saveJob(job)==true)
        {
            return new ResponseEntity<>(job,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/api/job")
    public ResponseEntity<List<Job>> getMethodName() {
        List<Job> j =  jobService.getJobs();
        if(j.size() == 0)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(j,HttpStatus.OK);
    }

    @GetMapping("/api/job/{jobId}")
    public ResponseEntity<Job> jobId(@PathVariable("jobId") int id) {
        Job j = jobService.getJobById(id);
        if(j==null)
        {
            return new ResponseEntity<>(null,HttpStatus.OK);
        }
        return new ResponseEntity<>(j,HttpStatus.OK);
    }
    
    
    
}
