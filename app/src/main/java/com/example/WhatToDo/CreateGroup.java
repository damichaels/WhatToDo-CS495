package com.example.WhatToDo;

//import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CreateGroup extends AppCompatActivity {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mDatabaseReference;
    public int count;
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
               // final User newUser = (User) getIntent().getSerializableExtra("user");
//                mDatabaseReference = mDatabase.getReference().child("users").child(newUser.getuID());
                String group = groupText.getText().toString();
                String gID = newUser.getuID() + 0;
                Group newGroup = new Group(group, gID);
                mDatabaseReference = mDatabase.getReference().child("Groups").child(gID);
                mDatabaseReference.setValue(newGroup);
/*                mDatabaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        count = Integer.valueOf(dataSnapshot.child("groupCount").getValue().toString());
                        String group = groupText.getText().toString();
                        String gID = newUser.getuID() + 0;
                        Group newGroup = new Group(group, gID);

                        mDatabaseReference = mDatabase.getReference().child("Groups").child(gID);
                        mDatabaseReference.setValue(newGroup);
                        mDatabaseReference = mDatabase.getReference().child("Groups").child(gID).child("Members").child(newUser.getuID());
                        mDatabaseReference.setValue(newUser.getName());
                        mDatabaseReference = mDatabase.getReference().child("Groups").child(gID).child("Members").child("count");
                        mDatabaseReference.setValue(1);
                        mDatabaseReference = mDatabase.getReference().child("users").child(newUser.getuID()).child("groupCount");
                        mDatabaseReference.setValue(count + 1);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
  */



            //    newUser.addGroup(newGroup);
            //    newGroup.addMember(newUser);
//                mDatabaseReference.child(newUser.getuID()).child("Groups").setValue(newGroup);

                Intent intent1 = new Intent(getBaseContext(), gList.class);
                intent1.putExtra("user", newUser);
                startActivity(intent1);
            }
        });
    }
}
