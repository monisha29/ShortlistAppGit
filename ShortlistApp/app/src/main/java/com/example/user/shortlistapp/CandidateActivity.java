package com.example.user.shortlistapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CandidateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button  CreateProfilebtn;
        Button Viewprofilebtn;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate);
        CreateProfilebtn=(Button) findViewById(R.id.cbutton1);
        Viewprofilebtn=(Button) findViewById(R.id.cbutton2);


        CreateProfilebtn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CandidateActivity.this,CreateCandidateprofileActivity.class);
            }
        }));

    }
    }


