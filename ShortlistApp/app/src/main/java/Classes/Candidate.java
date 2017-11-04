package Classes;

import java.util.ArrayList;
import java.util.List;

import DTO.AppliedJobWrapper;
import DTO.CandidateWrapper;

/**
 * Created by HPPC on 29-10-2017.
 */

public class Candidate extends Customer
{   private int candidateId;
    private String firstName;
   private String middleName;
   private String lastName;
   private Qualification qualification;
   private Contact contact;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName)
    {
        this.middleName = middleName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public Qualification getQualification()
    {
        return qualification;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }

    public Contact getContact()
    {
        return contact;
    }

    public void setAcademics(Contact contact)
    {
        this.contact = contact;
    }

    public void addProfile() {
       // Qualification qualification= new Qualification();
       // Contact contact= new Contact();
        CandidateWrapper candidateWrapperDto =new CandidateWrapper();
        candidateWrapperDto.candidateId=candidateId;
        candidateWrapperDto.firstName= firstName;
        candidateWrapperDto.lastName=lastName;
        candidateWrapperDto.middleName=middleName;
        candidateWrapperDto.experience=qualification.getExperience();
        candidateWrapperDto.pastWork=qualification.getPastWork();
        candidateWrapperDto.email=contact.getEmail();
        candidateWrapperDto.alternateEmail=contact.getAlternateEmail();
        candidateWrapperDto.phoneNo=contact.getPhoneNo();
        candidateWrapperDto.alternatePhoneNo=contact.getAlternatePhoneNo();
        candidateWrapperDto.address=contact.getAddress();
        //insert into database



    }
    public Candidate fetchCandidateProfile(int candidateId) {  Candidate candidate = new Candidate();
       //connect to Db fetch candidate profile write query select candidateprofile from candidateWrapper where candidateId=candidateId
       CandidateWrapper candidateWrapperDto = null;
       candidate.candidateId=candidateWrapperDto.candidateId;
       candidate.firstName=candidateWrapperDto.firstName;
       candidate.middleName=candidateWrapperDto.middleName;
       candidate.lastName=candidateWrapperDto.lastName;
       Qualification qualification = new Qualification();
       candidate.qualification= qualification.fetchQualification(candidateId) ;


        return candidate;

    }
    //TODO : 1.Sonali
    public void applyForJob(int jobId) {
        //add entry in appliedjobwrapper
        AppliedJobWrapper appliedJobWrapperDto = new AppliedJobWrapper();
        appliedJobWrapperDto.candidateId=candidateId;


    }
    public List<Job> viewAppliedJobs() {
       List<Job> listOfJobsAppliedByACandidate = new ArrayList<Job>();
        //Connect to AppliedJobWrapper
        List<Integer> listOfJobIds = null;
        for(int id : listOfJobIds)
        {
            Job job = new Job();
            job = Job.fetchJob(id);
            listOfJobsAppliedByACandidate.add(job);
        }

        return  listOfJobsAppliedByACandidate;
    }
}
