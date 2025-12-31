package com.rakhesh.jobApp;

import com.rakhesh.jobApp.model.JobPost;
import com.rakhesh.jobApp.model.User;
import com.rakhesh.jobApp.service.JobService;
import com.rakhesh.jobApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin("http://localhost")
@RestController
public  class JobRestController {

    private final JobService service;

    public JobRestController(JobService jobService) {
        this.service = jobService;
    }

    @GetMapping("jobPost")
    public List<JobPost> getAlljobs(){
        return service.getAllJobs();
    }

    @GetMapping("jobPost/{jobId}")
    public JobPost getJobPost(@PathVariable("jobId") int jobId)
    {
        System.out.print(service.getJob(jobId));
        return service.getJob(jobId);

    }

    @PostMapping("jobPost")
    public ResponseEntity<String> addJobPost(@RequestPart("job") JobPost jobPost, @RequestPart("imageFile") MultipartFile imageFile)
    {
        System.out.print("add");
        try {
            service.addJob(jobPost, imageFile);
            return new ResponseEntity<>("succesfully added",HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("jobPost/{jobId}")
    public  ResponseEntity<String> updateJobById(@RequestPart("job") JobPost jobPost, @RequestPart("imageFile") MultipartFile imageFile, @PathVariable("jobId") int jobId)
    {
        System.out.print("add");
        try {
            service.updateJob(jobPost, imageFile, jobId);
            return new ResponseEntity<>("succesfully updated",HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @DeleteMapping("jobPost/{jobId}")
    public  ResponseEntity<String> deleteJob(@PathVariable("jobId") int jobId)
    {

        service.deleteJob(jobId);
        return ResponseEntity.ok("deleted successfully");

    }

    @PostMapping("load")
    public  ResponseEntity<String> loadJob()
    {
        service.load();

        return ResponseEntity.ok("jobs loaded successfully");
    }

    @PostMapping("search/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword)
    {
        return service.searchByKeyword(keyword);
    }


//    }



}