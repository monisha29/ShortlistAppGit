package com.example.user.shortlistapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Classes.Candidate;
import Classes.Customer;
import Classes.Employer;

public class Login extends AppCompatActivity {


    private EditText customerid ;
    private EditText password;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    customerid = (EditText)findViewById(R.id.idTxt);
    password = (EditText)findViewById(R.id.pwdTxt);
    button = (Button)findViewById(R.id.btnLogin);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(customerid.getText().toString(),password.getText().toString());
            }
        });
    }


    private void validate(String user, String password)
    {
        Customer customer = new Customer();
        String type =  customer.login(user,password);
        if(type.equals("E"))
        {
            Intent intent = new Intent(Login.this, EmployerActivity.class);
            startActivity(intent);
        }
        else if(type.equals("C"))
        {
            Intent intent = new Intent(Login.this, CandidateActivity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this,"Invalid Credentials",Toast.LENGTH_LONG).show();
        }
    }
}
