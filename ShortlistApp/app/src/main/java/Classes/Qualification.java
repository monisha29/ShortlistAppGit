package Classes;

import DTO.CandidateWrapper;

/**
 * Created by HPPC on 29-10-2017.
 */

public class Qualification
{  private int experience;
   private String pastWork;
   private Academics academics;

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getPastWork() {
        return pastWork;
    }

    public void setPastWork(String pastWork) {
        this.pastWork = pastWork;
    }

    public Academics getAcademics() {
        return academics;
    }

    public void setAcademics(Academics academics) {
        this.academics = academics;
    }
    public Qualification addQualification(int experience, String pastWork) {  Qualification qualification= new Qualification();
       qualification.experience=experience;
        qualification.pastWork=pastWork;
        return qualification;
    }
    public Qualification fetchQualification(int candidateId) {    Qualification qualification = new Qualification();
        CandidateWrapper candidateWrapperDto = new CandidateWrapper();
        qualification.experience =candidateWrapperDto.experience;
        qualification.pastWork=candidateWrapperDto.pastWork;
        Academics academics = new Academics();
        qualification.academics =academics.fetchAcademicDetails(candidateId);
        return qualification;
    }





}
