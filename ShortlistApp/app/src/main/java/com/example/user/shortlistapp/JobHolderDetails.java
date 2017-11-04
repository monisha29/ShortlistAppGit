package com.example.user.shortlistapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import Data.JobHolderContract;

public class JobHolderDetails extends AppCompatActivity {
    TextView textViewh ;
    TextView textViewd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_holder_details);
        textViewh = (TextView) findViewById(R.id.headernew);
        textViewd = (TextView) findViewById(R.id.deadlinenew);
        textViewh.setText("heading " + getIntent().getStringExtra(JobHolderContract.JobholderEntry.COLUMN_TITLE));
        textViewh.setText("heading " + getIntent().getStringExtra(JobHolderContract.JobholderEntry.COLUMN_DEADLINE));
    }
}
