package Adapters;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Classes.JobHolder;

/**
 * Created by HPPC on 29-10-2017.
 */

public class JobHolderWrapper {
       public int jobHolderId;
       public String jobHolderTitle;
       public String   deadlineDate;


      public static List<JobHolder> parseJson(String json)
      {

          List<JobHolder> list = new ArrayList<JobHolder>();
          try {


              JSONArray jobHolderDocuments = new JSONArray(json);
              for (int i = 0; i < jobHolderDocuments.length(); i++) {
                  JSONObject document = new JSONObject();
                  document = jobHolderDocuments.getJSONObject(i);

                  JobHolder jobHolder = new JobHolder();
                  //   jobHolder.jobHolderTitle = (document.get(JobHolderContract.JobholderEntry.COLUMN_TITLE).toString());
                  //   jobHolder.deadlineDate = (document.get(JobHolderContract.JobholderEntry.COLUMN_DEADLINE).toString());
                  jobHolder.setJobHolderTitle(document.get("jobholderdesc").toString());
                  jobHolder.setDeadline(document.get("deadline").toString());
                  list.add(jobHolder);
              }

          }
          catch (Exception e)
          {
              e.printStackTrace();
          }
          return  list;

      }

}
