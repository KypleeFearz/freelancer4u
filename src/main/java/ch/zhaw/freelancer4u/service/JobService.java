package ch.zhaw.freelancer4u.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.zhaw.freelancer4u.model.Freelancer;
import ch.zhaw.freelancer4u.model.Job;
import ch.zhaw.freelancer4u.model.JobState;
import ch.zhaw.freelancer4u.repository.FreelancerRepository;
import ch.zhaw.freelancer4u.repository.JobRepository;

@Service
public class JobService {
    @Autowired
    JobRepository jobRepository;
    @Autowired
    FreelancerRepository freelancerRepository;

    public Optional<Job> assignJob(String jobId, String freelancerEmail) {
        Optional<Job> jobToAssign = jobRepository.findById(jobId);
        Freelancer freelancerToFind = freelancerRepository.findFirstByEmail(freelancerEmail);
        if (jobToAssign.isPresent()) {
            Job job = jobToAssign.get();
            if (job.getJobState() == JobState.NEW) {
                if (freelancerToFind != null) {
                    job.setJobState(JobState.ASSIGNED);
                    job.setFreelancerId(freelancerToFind.getId());
                    jobRepository.save(job);
                    return Optional.of(job);
                }
            }
        }
        return Optional.empty();
    }

    public Optional<Job> completeJob(String jobId, String freelancerEmail) {
        Optional<Job> jobToComplete = jobRepository.findById(jobId);
        Freelancer freelancerToFind = freelancerRepository.findFirstByEmail(freelancerEmail);
        if (jobToComplete.isPresent()) {
            Job job = jobToComplete.get();
            if (job.getJobState() == JobState.ASSIGNED) {
                if (freelancerToFind != null && job.getFreelancerId().equals(freelancerToFind.getId())) {
                    job.setJobState(JobState.DONE);
                    jobRepository.save(job);
                    return Optional.of(job);
                }
            }
        }
        return Optional.empty();
    }
}