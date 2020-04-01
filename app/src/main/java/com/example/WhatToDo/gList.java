package com.example.WhatToDo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class gList extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    private GroupListAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_list);
        final Button btnCreateGroup = (Button) findViewById(R.id.button_create);
        final User newUser = (User) getIntent().getSerializableExtra("user");
        //Use the uID to find the groups associated with the uID
        ArrayList<GroupName> groupList = new ArrayList<>();
        groupList.add(new GroupName("Smith Family Chores"));
        groupList.add(new GroupName("Bama Roommates"));
        groupList.add(new GroupName("The Office"));
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new GroupListAdapter(groupList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new GroupListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent today = new Intent(getBaseContext(), TodayTaskList.class);
                startActivity(today);
            }
        });

        btnCreateGroup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getBaseContext(), CreateGroup.class);
                myIntent.putExtra("user", newUser);
                startActivity(myIntent);
            }
        });
    }


}
