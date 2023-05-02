package ch.zhaw.freelancer4u.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.freelancer4u.model.Job;
import ch.zhaw.freelancer4u.model.JobCreateDTO;
import ch.zhaw.freelancer4u.model.JobStateAggregation;
import ch.zhaw.freelancer4u.model.JobType;
import ch.zhaw.freelancer4u.repository.JobRepository;

@RestController
@RequestMapping("/api")
public class JobController {
    @Autowired
    JobRepository jobRepository;

    @PostMapping("/job")
    @Secured("ROLL_admin")
    public ResponseEntity<Job> createJob(
            @RequestBody JobCreateDTO jDTO) {
        Job jDAO = new Job(jDTO.getDescription(), jDTO.getEarnings(), jDTO.getJobType());
        Job j = jobRepository.save(jDAO);
        return new ResponseEntity<>(j, HttpStatus.CREATED);
    }

    @GetMapping("/job")
    public ResponseEntity<List<Job>> getAllJobs(@RequestParam(required = false) Double min,
            @RequestParam(required = false) JobType type) {
        List<Job> allFree = null;
        if (min == null && type == null) {
            allFree = jobRepository.findAll();
        }
        if (min != null) {
            allFree = jobRepository.findByEarningsGreaterThan(min);
        }
        if (type != null) {
            if (type != JobType.IMPLEMENT || type != JobType.REVIEW || type != JobType.OTHER || type != JobType.TEST) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            allFree = jobRepository.findByJobType(type);
        }
        if (type != null && min != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(allFree, HttpStatus.OK);
    }

    @GetMapping("/job/aggregation/state")
    public List<JobStateAggregation> getJobStateAggregation() {
        return jobRepository.getJobStateAggregation();
    }



}
