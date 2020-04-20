package com.example.WhatToDo;


import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class CreateTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);


        final Button btnCreateTask = (Button) findViewById(R.id.button_task);
        final TextView taskName = (TextView) findViewById(R.id.task_name);
        final TextView taskPoints = (TextView) findViewById(R.id.task_point);
    }

}
