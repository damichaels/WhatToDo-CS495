package com.example.WhatToDo;

//import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateGroup extends AppCompatActivity {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mDatabaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_group);
        mDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mDatabase.getReference();
        final Button btnCreateGroup = (Button) findViewById(R.id.button);
        final User newUser = (User) getIntent().getSerializableExtra("user");
        /* assert(newUser == null); */
        final TextView groupText = (TextView) findViewById(R.id.editText5);

        btnCreateGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                User newUser = (User) getIntent().getSerializableExtra("user");
                String group = groupText.getText().toString();
                String gID = newUser.getuID() + newUser.getGroupCount();
                Group newGroup = new Group(group, gID);
            //    newUser.addGroup(newGroup);
            //    newGroup.addMember(newUser);
//                mDatabaseReference.child(newUser.getuID()).child("Groups").setValue(newGroup);
                mDatabaseReference = mDatabase.getReference().child("Groups").child(gID);
                mDatabaseReference.setValue(newGroup);
                mDatabaseReference = mDatabase.getReference().child("Groups").child(gID).child("Members").child(newUser.getuID());
                mDatabaseReference.setValue(newUser.getName());

                Intent intent1 = new Intent(getBaseContext(), gList.class);
                startActivity(intent1);
            }
        });
    }
}
