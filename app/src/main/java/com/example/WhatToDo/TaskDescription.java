package com.example.WhatToDo;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TimePicker;


public class TaskDescription extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_description);
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
    }
}
