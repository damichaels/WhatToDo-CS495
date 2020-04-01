package com.example.WhatToDo;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class groupMembers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_members);
        final Button btnInfo = (Button) findViewById(R.id.button1);
        btnInfo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent myIntent1 = new Intent(getBaseContext(), memberInfo.class);
                startActivity(myIntent1);
            }
        });
    }

}
