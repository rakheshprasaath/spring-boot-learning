package com.rakhesh.jobApp.service;


import com.rakhesh.jobApp.model.JobPost;
import com.rakhesh.jobApp.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    public void addJob(JobPost jobPost)
    {
        repo.addJob(jobPost);
    }

    public List<JobPost> getAllJobs()
    {
        return repo.getAllJobs();
    }

    public JobPost getJob(int jobId)
    {
        return repo.getJob(jobId);
    }

    public void updateJob(JobPost jobPost)
    {
         repo.updatejob(jobPost);
    }

    public void deleteJob(int jobId)
    {
        repo.deleteJob(jobId);
    }
}
