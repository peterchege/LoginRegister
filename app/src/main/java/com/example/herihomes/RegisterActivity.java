package com.example.herihomes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;



public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextEmail, editTextPassword, editTextName, editTextSchool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        editTextEmail = findViewById(R.id.eT_email);
        editTextPassword = findViewById(R.id.eT_password);
        editTextName = findViewById(R.id.eT_name);
        editTextSchool = findViewById(R.id.eT_school);

        findViewById(R.id.buttonSignUp).setOnClickListener(this);
        findViewById(R.id.tv_login).setOnClickListener(this);
    }

    private  void userSignUp(){
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String name = editTextName.getText().toString().trim();
        String school = editTextSchool.getText().toString().trim();
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.buttonSignUp:
                userSignUp();
                break;
            case R.id.tv_login:
                break;
        }
    }
}
