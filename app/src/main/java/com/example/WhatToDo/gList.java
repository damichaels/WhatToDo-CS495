package com.example.WhatToDo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class gList extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mDatabaseReference;
    private GroupListAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public ArrayList<GroupName> groupList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_list);
        mDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mDatabase.getReference();
        final Button btnCreateGroup = (Button) findViewById(R.id.button_create);
        final User newUser = (User) getIntent().getSerializableExtra("user");
        //Use the uID to find the groups associated with the uID
        final String gID = newUser.getuID() + newUser.getGroupCount();
        mDatabaseReference = mDatabase.getReference().child("Groups")
        ;
        //ArrayList<GroupName> groupList = new ArrayList<>();
        mDatabaseReference.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
//                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Group group = new Group();
//                    group.setgName(ds.child(gID).getValue(Group.class).getgName());
                    group.setgName(dataSnapshot.child(gID).child("gName").getValue().toString());
                    groupList.add(new GroupName(group.getgName()));
 //               }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
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
