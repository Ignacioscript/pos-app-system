package org.ignacioScript.co.service;

import org.ignacioScript.co.dao.JobDAO;
import org.ignacioScript.co.dto.JobDTO;
import org.ignacioScript.co.model.Job;

import java.util.List;
import java.util.stream.Collectors;

public class JobService {

    private final JobDAO jobDAO;

    public JobService(JobDAO jobDAO) {
        this.jobDAO = jobDAO;
    }

    public void saveJob(JobDTO jobDTO){
        Job job = createJobFromDTO(jobDTO);
        jobDAO.save(job);
    }

    public void updateJob(JobDTO jobDTO, int id){
        Job job = createJobFromDTO(jobDTO);
        jobDAO.update(job, id);
    }

    public void deleteJob(int id) {
        jobDAO.delete(id);
    }

    public List<JobDTO> getAllJobs() {
        return jobDAO.findAll().stream()
                .map(job -> new JobDTO(
                        job.getJobTitle(),
                        job.getSalary()))
                .collect(Collectors.toList());
    }

    public JobDTO getJobById(int id) {
        Job job = jobDAO.findById(id);
        return new JobDTO(
                job.getJobTitle(),
                job.getSalary());
    }

    //HELPERS
    protected Job createJobFromDTO(JobDTO jobDTO){
        return new Job(
                jobDTO.getJobTitle(),
                jobDTO.getSalary()
        );
    }


}
