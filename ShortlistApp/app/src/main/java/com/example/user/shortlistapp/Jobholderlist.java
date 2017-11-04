package com.example.user.shortlistapp;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import Adapters.JobHolderAdapter;
import Adapters.JobHolderWrapper;
import Classes.JobHolder;
import Model.TestDb;

public class Jobholderlist extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    List<JobHolder> listofJobHoldersOfAnEmployee;
    Context ctx = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobholderlist);
      //  String obj = TestDb.getAllDocuments("jobholder",this);

         new GetData().execute();
     //   List<JobHolder> formedListJobHolder = JobHolderWrapper.parseJson(obj);
//        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(ctx));
//
//        adapter = new JobHolderAdapter(formedListJobHolder,this);
//        recyclerView.setAdapter(adapter);

    }



    class GetData extends AsyncTask<String,Void,String> {

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
         //  jsonemp.setText(s);
            try {
                List<JobHolderWrapper> formedListJobHolder = new ArrayList<>();
                JSONArray jobHolderDocuments = new JSONArray(s);
                for(int i = 0 ; i < jobHolderDocuments.length() ; i++)
                {
                    JSONObject document = new JSONObject();
                    document = jobHolderDocuments.getJSONObject(i);

                    JobHolderWrapper jobHolder = new JobHolderWrapper();
                 //   jobHolder.jobHolderTitle = (document.get(JobHolderContract.JobholderEntry.COLUMN_TITLE).toString());
                 //   jobHolder.deadlineDate = (document.get(JobHolderContract.JobholderEntry.COLUMN_DEADLINE).toString());
                    jobHolder.jobHolderTitle = document.get("jobholderdesc").toString();
                    jobHolder.deadlineDate = document.get("deadline").toString();
                    //jsonemp.setText(jobHolder.jobHolderTitle + " : " + jobHolder.deadlineDate);
                    formedListJobHolder.add(jobHolder);
                }

                recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(ctx));
                adapter = new JobHolderAdapter(formedListJobHolder,ctx);
                recyclerView.setAdapter(adapter);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }

        @Override
        protected String doInBackground(String... strings) {
            String op = "dummy";
            try {
//                URL url = new URL("http://10.0.2.2:9200/jobholder/external/_search?q=check");
//                HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
//                if(urlConnection.getResponseCode()==200)
//                {
//                    InputStream in = new BufferedInputStream(urlConnection.getInputStream());
//                    BufferedReader r = new BufferedReader(new InputStreamReader(in));
//                    String line ;
//                    StringBuilder sb = new StringBuilder();
//                    while((line=r.readLine())!=null)
//                        sb.append(line);
//                    op = sb.toString();
//                    urlConnection.disconnect();
//                }
//                else
//                {
//                    Toast.makeText(getBaseContext(),"Something went wrong",Toast.LENGTH_LONG).show();
//                }
                op = TestDb.getAllDocuments("jobholder",ctx);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            return op;
        }


    }
}
