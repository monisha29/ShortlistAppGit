package Classes;

import DTO.CandidateWrapper;

/**
 * Created by HPPC on 29-10-2017.
 */

public class Academics
{
    private float highSchoolPercentage;
    private float seniorSecondaryPercentage;
    private float graduationPercentage;
    private float postGraduationPercentage;


    public float getHighSchoolPercentage() {
        return highSchoolPercentage;
    }

    public void setHighSchoolPercentage(float highSchoolPercentage) {
        this.highSchoolPercentage = highSchoolPercentage;
    }

    public float getSeniorSecondaryPercentage() {
        return seniorSecondaryPercentage;
    }

    public void setSeniorSecondaryPercentage(float seniorSecondaryPercentage) {
        this.seniorSecondaryPercentage = seniorSecondaryPercentage;
    }

    public float getGraduationPercentage() {
        return graduationPercentage;
    }

    public void setGraduationPercentage(float graduationPercentage) {
        this.graduationPercentage = graduationPercentage;
    }

    public float getPostGraduationPercentage() {
        return postGraduationPercentage;
    }

    public void setPostGraduationPercentage(float postGraduationPercentage) {
        this.postGraduationPercentage = postGraduationPercentage;
    }
    public Academics addAcademics(float highSchoolPercentage, float seniorSecondaryPercentage, float graduationPercentage, float postGraduationPercentage) {   Academics academics = new Academics();
        academics.highSchoolPercentage=highSchoolPercentage;
        academics.seniorSecondaryPercentage=seniorSecondaryPercentage;
        academics.graduationPercentage=graduationPercentage;
        academics.postGraduationPercentage=postGraduationPercentage;
        return academics;

    }
    public Academics fetchAcademicDetails(int candidateId) { Academics academics = new Academics();
        CandidateWrapper candidateWrapperDto = new CandidateWrapper();
        academics.highSchoolPercentage=candidateWrapperDto.highSchoolPercentage;
        academics.seniorSecondaryPercentage=candidateWrapperDto.seniorSecondaryPercentage;
        academics.graduationPercentage=candidateWrapperDto.graduationPercentage;
        academics.postGraduationPercentage=candidateWrapperDto.postGraduationPercentage;
        return academics;
    }
}
