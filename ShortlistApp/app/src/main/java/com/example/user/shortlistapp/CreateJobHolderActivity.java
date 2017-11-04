package com.example.user.shortlistapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Classes.JobHolder;
import Data.JobHolderDBHelper;
import Model.TestDb;

public class CreateJobHolderActivity extends AppCompatActivity {
    EditText jobholdertitle;
    EditText jobholderDesc;
    EditText deadline;
    Button btn ;
    Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //mapping frontend backebnd start
        setContentView(R.layout.activity_create_job_holder);
        jobholdertitle = (EditText)findViewById(R.id.jbtitle);
        jobholderDesc =  (EditText)findViewById(R.id.jbdesc);
        deadline = (EditText)findViewById(R.id.jbdeadline);
        btn = (Button)findViewById(R.id.addjbbtn);
        //END
        //ON CLICK OF CREATE BUTTON
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                JobHolder jobHolder = new JobHolder();
                jobHolder.setJobHolderTitle(jobholdertitle.getText().toString());
                jobHolder.setDeadline(deadline.getText().toString());
                new addJobHolderToDb().execute(jobHolder);

             }
        });

    }


    public class addJobHolderToDb extends AsyncTask<JobHolder,Void,String> {

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(s.equals("Success"))
                Toast.makeText(context,"Successfully added",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(context,"Something went wrong",Toast.LENGTH_LONG).show();
        }

        @Override
        protected String doInBackground(JobHolder... params) {
           String s =  TestDb.insertDocument("jobholder",context,params[0]);
            return  s;
        }
    }
}
