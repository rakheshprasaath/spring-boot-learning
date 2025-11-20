package com.rakhesh.jobApp;

import com.rakhesh.jobApp.model.JobPost;
import com.rakhesh.jobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public  class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping("jobPost")
    @ResponseBody
    public List<JobPost> getAlljobs(){
        return service.getAllJobs();
    }

    @GetMapping("jobPost/{jobId}")
    @ResponseBody
    public JobPost getJobPost(@PathVariable("jobId") int jobId)
    {
        System.out.print(service.getJob(jobId));
        return service.getJob(jobId);

    }

    @PostMapping("/jobPost")
    public ResponseEntity<String> addJobPost(@RequestBody JobPost jobPost)
    {
        System.out.print("add");
        service.addJob(jobPost);
        return ResponseEntity.ok("added successfully");
    }

    @PutMapping("jobPost")
    public  ResponseEntity<String> updateJob(@RequestBody JobPost jobPost)
    {

        service.updateJob(jobPost);
        return ResponseEntity.ok("updated successfully");

    }


    @DeleteMapping("jobPost/{jobId}")
    public  ResponseEntity<String> deleteJob(@PathVariable("jobId") int jobId)
    {

        service.deleteJob(jobId);
        return ResponseEntity.ok("deleted successfully");

    }





}