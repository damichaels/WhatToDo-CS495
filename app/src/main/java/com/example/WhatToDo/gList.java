package com.example.WhatToDo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
/*
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
*/
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class gList extends AppCompatActivity {
    private FirebaseFirestore db;
    private RecyclerView mRecyclerView;

    private GroupListAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public ArrayList<GroupName> groupList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_list);

        db = FirebaseFirestore.getInstance();
        final Button btnCreateGroup = (Button) findViewById(R.id.button_create);
        final Button btnJoinGroup = (Button) findViewById(R.id.button_join);
        final User newUser = (User) getIntent().getSerializableExtra("user");

        DocumentReference docRef = db.collection("users").document(newUser.getuID());
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                User myUser = documentSnapshot.toObject(User.class);
                int x, y = myUser.getGroupCount();

                for (x = 1; x <= y; x++) {
                    DocumentReference docRef1 = db.collection("users").document(newUser.getuID()).collection("groups").document(String.valueOf(x));
              /*    Task<DocumentSnapshot> ds = docRef1.get();
                    DocumentSnapshot ds1 = ds.getResult();
                    Group myGroup = ds1.toObject(Group.class);
                    groupList.add(new GroupName(myGroup.getgName()));
                    */
                    docRef1.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            Group myGroup = documentSnapshot.toObject(Group.class);
                            groupList.add(new GroupName(myGroup.getgName()));
                        }
                    });
                }
            }
        });

      //  groupList.add(new GroupName("Smith Family Chores"));
      //  groupList.add(new GroupName("Bama Roommates"));
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
        btnJoinGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getBaseContext(), JoinGroup.class);
                myIntent.putExtra("user", newUser);
                startActivity(myIntent);
            }
        });
    }


}
