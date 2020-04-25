package com.example.WhatToDo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class JoinGroup extends AppCompatActivity{
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    public int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_join);
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        FirebaseUser user = mAuth.getCurrentUser();
        final Button btnJoinGroup = (Button) findViewById(R.id.joingroup);

        final TextView groupCode = (TextView) findViewById(R.id.groupCode);

        btnJoinGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final User newUser = (User) getIntent().getSerializableExtra("user");
                final String gCode = groupCode.getText().toString();
                DocumentReference docRef = db.collection("groups").document(gCode);
                docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        final Group myGroup = documentSnapshot.toObject(Group.class);
                        final int mCount = myGroup.getMemberCount();
                        myGroup.setMemberCount(mCount + 1);
                        DocumentReference docRef1 = db.collection("users").document(newUser.getuID());
                        docRef1.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                User myUser = documentSnapshot.toObject(User.class);
                                int count = myUser.getGroupCount();
                                newUser.setGroupCount(count + 1);
                                db.collection("groups").document(gCode).set(myGroup);
                                db.collection("users").document(newUser.getuID()).set(newUser);
                                db.collection("users").document(newUser.getuID()).collection("groups").document(String.valueOf(count + 1)).set(myGroup);
                                db.collection("groups").document(gCode).collection("members").document(String.valueOf(mCount + 1)).set(newUser);
                            }
                        });
                        Intent intent1 = new Intent(getBaseContext(), gList.class);
                        intent1.putExtra("user", newUser);
                        intent1.putExtra("group", myGroup);
                        startActivity(intent1);
                    }
                });

            }
        });

    }
}
