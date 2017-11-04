package Classes;

import java.util.ArrayList;
import java.util.List;

import DTO.EmployerWrapper;

/**
 * Created by HPPC on 29-10-2017.
 */

public class Employer extends Customer {
    private int employerId;
    private String employerName;
    private List<JobHolder> listOfJobHolders;

    public List<JobHolder> getListOfJobHolders() {
        return listOfJobHolders;
    }

    public void setListOfJobHolders(List<JobHolder> listOfJobHolders) {
        this.listOfJobHolders = listOfJobHolders;
    }
    public Employer fetchEmployer(int employerId) {   Employer employer=new Employer();
        //connect to DB fetch Employer write query select Employer From EmployerWrapper where empId=employerId
        EmployerWrapper employerDto=null;
        employer.employerId=employerDto.employerId;
        employer.employerName=employerDto.employerName;
        List<JobHolder> list = new ArrayList<JobHolder>();
        //connect to DB fetch JobHolderID from EmployerJobholder wrppaer table where empId==employerId
        List<Integer> listOfJobHolderId=null;
        for(int i:listOfJobHolderId)
        {
            JobHolder jobHolder = new JobHolder();
            jobHolder= JobHolder.fetchJobHolder(i);
            list.add(jobHolder);

        }
        employer.listOfJobHolders=list;

       return employer;


    }

}
