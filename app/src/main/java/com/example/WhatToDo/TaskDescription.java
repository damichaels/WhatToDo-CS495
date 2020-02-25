package com.example.WhatToDo;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TimePicker;


public class TaskDescription extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_description);
        final Button btnC = findViewById(R.id.changeBtn);
        final Switch mSwitch = findViewById(R.id.switch1);
        final TimePicker mTime = findViewById(R.id.timePicker);
        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mTime.setVisibility(View.VISIBLE);
                }
                else
                    mTime.setVisibility(View.INVISIBLE);
            }
        });
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getBaseContext(), taskSchedule.class);
                startActivity(myIntent);
            }

        });
    }
}
