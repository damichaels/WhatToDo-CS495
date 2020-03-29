package com.example.WhatToDo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class memberInfo extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ArrayList<taskItem> taskList = new ArrayList<>();
    private taskItemAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_info);
        final TextView points = findViewById(R.id.pointValue);
        taskList.add(new taskItem("Mow Lawn", "50"));
        taskList.add(new taskItem("Wash Dishes", "10"));
        taskList.add(new taskItem("Feed Cat", "20"));
        taskList.add(new taskItem("Fold Laundry", "20"));
        taskList.add(new taskItem("Fold Laundry", "20"));
        taskList.add(new taskItem("Fold Laundry", "20"));
        taskList.add(new taskItem("Fold Laundry", "20"));
        taskList.add(new taskItem("Fold Laundry", "20"));
        taskList.add(new taskItem("Fold Laundry", "20"));
        mRecyclerView = findViewById(R.id.recycler_view4);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new taskItemAdapter(taskList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new taskItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent myIntent1 = new Intent(getBaseContext(), TaskDescription.class);
                startActivity(myIntent1);
            }
        });
        /*final Button buttonT = (Button) findViewById(R.id.button1);
       buttonT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getBaseContext(), TaskDescription.class);
                startActivity(myIntent);
            }

        });*/
    }

}
