package com.example.WhatToDo;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;

public class TodayTaskList extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private  ArrayList<taskItem> taskList = new ArrayList<>();
    private taskItemAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private TabLayout tabL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_list);
        final Button btnMember = (Button) findViewById(R.id.btnMembers);
        taskList.add(new taskItem("Mow Lawn", "50"));
        taskList.add(new taskItem("Wash Dishes", "10"));
        taskList.add(new taskItem("Feed Cat", "20"));
        taskList.add(new taskItem("Fold Laundry", "20"));
        mRecyclerView = findViewById(R.id.recycle_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new taskItemAdapter(taskList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        tabL= findViewById(R.id.tabLayout);


        mAdapter.setOnItemClickListener(new taskItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Ganesh();
            }
        });


        tabL.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int i=tab.getPosition();
                if (i==1){
                    taskList.clear();
                    taskList.add(new taskItem("Dust", "30"));
                    taskList.add(new taskItem("Vacuum", "50"));
                    mAdapter.notifyDataSetChanged();
                }
                else {
                    taskList.clear();
                    taskList.add(new taskItem("Mow Lawn", "50"));
                    taskList.add(new taskItem("Wash Dishes", "10"));
                    taskList.add(new taskItem("Feed Cat", "20"));
                    taskList.add(new taskItem("Fold Laundry", "20"));
                    mAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
         btnMember.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent myIntent1 = new Intent(getBaseContext(), groupMembers.class);
                startActivity(myIntent1);
            }
        });
    }

    public void Ganesh(){
        Intent ganesh = new Intent(getBaseContext(), YourTaskList.class);
        startActivity(ganesh);
    }
}
