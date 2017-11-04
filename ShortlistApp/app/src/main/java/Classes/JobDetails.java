package Classes;

import java.util.Date;

/**
 * Created by HPPC on 29-10-2017.
 */

public class JobDetails {
    private String jobDescription;
    private String jobCity;
    private double salary;
    private Date applicationDate;
    private String jobType;
    private String eligibility;
    private int jobTerm;

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobCity() {
        return jobCity;
    }

    public void setJobCity(String jobCity) {
        this.jobCity = jobCity;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getEligibility() {
        return eligibility;
    }

    public void setEligibility(String eligibility) {
        this.eligibility = eligibility;
    }

    public int getJobTerm() {
        return jobTerm;
    }

    public void setJobTerm(int jobTerm) {
        this.jobTerm = jobTerm;
    }

    public JobDetails addJobDetail(String jobDescription , Date date, String jobCity, Double salary, String eligibility, String jobType, int jobTerm) {

        JobDetails jobDetails = new JobDetails();
        jobDetails.jobDescription = jobDescription;
        jobDetails.applicationDate = date;
        jobDetails.jobCity = jobCity;
        jobDetails.salary = salary;
        jobDetails.eligibility = eligibility;
        jobDetails.jobType = jobType;
        jobDetails.jobTerm = jobTerm;
        return jobDetails;
    }


}
