package Classes;

import DTO.JobWrapper;

/**
 * Created by HPPC on 29-10-2017.
 */

public class Job {
    private int jobId;
    private String jobTitle;
    private JobDetails jobDetails;

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public JobDetails getJobDetails() {
        return jobDetails;
    }

    public void setJobDetails(JobDetails jobDetails) {
        this.jobDetails = jobDetails;
    }
    //TODO: MOnisha
    public static Job fetchJob(int jobId) {
        Job job = new Job();
        // connect to DB and fetch and write query select job from jobwrapper where jobid==jobId
        JobWrapper jobDto = null;

        job.jobId = jobDto.jobId;
        job.jobTitle = jobDto.jobTitle;
        JobDetails jobDetails =new JobDetails();
        jobDetails.setApplicationDate(jobDto.applicationDate);
        jobDetails.setEligibility(jobDto.eligibility);
        jobDetails.setJobCity(jobDto.jobCity);
        jobDetails.setJobDescription(jobDto.jobDescription);
        jobDetails.setJobTerm(jobDto.jobTerm);
        jobDetails.setSalary(jobDto.salary);
        job.jobDetails = jobDetails;

        return job;
    }

    public void insertJobToDatabase(Job job) {
        JobWrapper jobDto = new JobWrapper();
        jobDto.jobId = job.jobId;
        jobDto.jobTitle = job.jobTitle;
        jobDto.applicationDate = job.jobDetails.getApplicationDate();
        jobDto.eligibility = job.jobDetails.getEligibility();
        jobDto.jobCity = job.jobDetails.getJobCity();
        jobDto.jobDescription = job.jobDetails.getJobDescription();
        jobDto.jobTerm = job.jobDetails.getJobTerm();
        jobDto.salary = job.jobDetails.getSalary();
        //connect to job table
        //push dto


    }

}
