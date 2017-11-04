package Classes;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import Adapters.JobHolderWrapper;
import  DTO.JobWrapper;
import Data.JobHolderContract;
import Data.JobHolderDBHelper;

/**
 * Created by HPPC on 29-10-2017.
 */

public class JobHolder {
    private int jobHolderId;
    private String jobHolderTitle;
    private String deadline;

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }


    public int getJobHolderId() {
        return jobHolderId;
    }

    public void setJobHolderId(int jobHolderId) {
        this.jobHolderId = jobHolderId;
    }

    public String getJobHolderTitle() {
        return jobHolderTitle;
    }

    public void setJobHolderTitle(String jobHolderTitle) {
        this.jobHolderTitle = jobHolderTitle;
    }

    public String getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(String deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    private String deadlineDate;
    private List<Job> listOfJobs;

    public List<Job> getListOfJobs() {
        return listOfJobs;
    }

    public void setListOfJobs(List<Job> listOfJobs) {
        this.listOfJobs = listOfJobs;
    }

    //TODO: Sonali
    public JobHolder viewAJobHolder(int JobHolderId) {
        JobHolder jobHolder = new JobHolder();
        return jobHolder;
    }

    public void insertJobHolder() {






    }
    public static JobHolder fetchJobHolder(int jobHolderId) {  JobHolder jobHolder= new JobHolder();
        //connect to DB fetch johholder write query select jobHolder from jobHolder
       JobHolderWrapper jobHolderDto=null;
        JobWrapper jobDto=null;
       jobHolder.jobHolderId=jobHolderDto.jobHolderId;
       jobHolder.jobHolderTitle=jobHolderDto.jobHolderTitle;
       //jobHolder.deadlineDate=jobHolderDto.deadlineDate;
        List<Job> list = new ArrayList<Job>();
        //Connect db return List<Id> from job where jobholderid = jobHolderId
        List<Integer> relatedJObs = null;
        for(int Id : relatedJObs)
        {
            Job newJob = new Job();
            newJob = Job.fetchJob(Id);
            list.add(newJob);
        }
        jobHolder.listOfJobs = list;
        return jobHolder;
    }

    public static JSONObject generateJsonObject(JobHolder jobHolder)
    {
        JSONObject document = new JSONObject();
        try {

            document.put("jobholderdesc", jobHolder.jobHolderTitle);
            document.put("deadline",jobHolder.deadline);
            return document;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return document;
    }

}

