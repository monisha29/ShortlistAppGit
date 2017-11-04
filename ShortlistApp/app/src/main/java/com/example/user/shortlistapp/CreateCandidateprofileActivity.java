package com.example.user.shortlistapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import Classes.Candidate;


public class CreateCandidateprofileActivity extends AppCompatActivity {
    EditText firstname;
    EditText middlename;
    EditText lastname;
    EditText skills;
    EditText proficiency;
    EditText email;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_candidateprofile);
        firstname=(EditText) findViewById(R.id.fname);
        middlename=(EditText) findViewById(R.id.mname);
        lastname=(EditText) findViewById(R.id.lname);
        skills=(EditText) findViewById(R.id.cskill);
        proficiency=(EditText) findViewById(R.id.) ;
        btn=(Button) findViewById(R.id.addprofilebtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Candidate candidate  = new Candidate();
                candidate.setFirstName(firstname.getText().toString());
                candidate.setMiddleName(middlename.getText().toString());
                candidate.setLastName(lastname.getText().toString());
                candidate.setSkill(skills.getText().toString());
                candidate.setProficiency(proficiency.getText().toString());
                candidate.setEmail(email.getText().toString());


            }
        });


    }


    }
}
