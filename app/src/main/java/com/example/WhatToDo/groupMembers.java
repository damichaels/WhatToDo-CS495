package com.example.WhatToDo;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;


public class groupMembers extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    private MemberNameAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_members);
        final Button btnAdd = (Button) findViewById(R.id.button_add);
        ArrayList<MemberName> memberList = new ArrayList<>();
        memberList.add(new MemberName("Mike"));
        memberList.add(new MemberName("Joey"));
        memberList.add(new MemberName("Tommy"));
        memberList.add(new MemberName("Susan"));
        mRecyclerView = findViewById(R.id.recycle_view3);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new MemberNameAdapter(memberList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new MemberNameAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent myIntent1 = new Intent(getBaseContext(), memberInfo.class);
                startActivity(myIntent1);
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent myIntent2 = new Intent(getBaseContext(), memberInfo.class);
                startActivity(myIntent2);
            }
        });
    }

}
