package com.example.WhatToDo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
//import android.support.v7.app.AppCompatActivity;

public class Register extends AppCompatActivity {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mDatabaseReference;
    private int numUsers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //Have to fix these inputs

        mDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mDatabase.getReference();
        final Button btnSubmit = (Button) findViewById(R.id.submitbtn);
        final TextView usernameText = (TextView) findViewById(R.id.usernameInput);
        final TextView passwordText = (TextView) findViewById(R.id.passwordInput);
        final TextView passwordConfirmText = (TextView) findViewById(R.id.confirmPWInput);
        final TextView emailText = (TextView) findViewById(R.id.emailInput);
        final TextView firstnameText = (TextView) findViewById(R.id.firstnameInput);
        final TextView lastnameText = (TextView) findViewById(R.id.lastnameInput);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameText.getText().toString();
                String password = passwordText.getText().toString();
                String passwordConfirm = passwordConfirmText.getText().toString();
                String email = emailText.getText().toString();
                String firstname = firstnameText.getText().toString();
                String lastname = lastnameText.getText().toString();

                String name = firstname + " " + lastname;
                mDatabaseReference = mDatabase.getReference().child("name" + numUsers);
                mDatabaseReference.setValue(name);
                numUsers++;
                //Until database is setup, these strings would be stored in a text file.
                Intent intent1 = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent1);
            }
        });
    }
}
