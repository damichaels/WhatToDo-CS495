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


public class CreateTask extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    public int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        FirebaseUser user = mAuth.getCurrentUser();
        final Button btnCreateTask = (Button) findViewById(R.id.button_task);
        final TextView taskName = (TextView) findViewById(R.id.task_name);
        final TextView taskPoints = (TextView) findViewById(R.id.task_point);

        btnCreateTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final User newUser = (User) getIntent().getSerializableExtra("user");
                final Group newGroup = (Group) getIntent().getSerializableExtra("group");
                final String tName = taskName.getText().toString();
                final String tPoints = taskPoints.getText().toString();
                DocumentReference docRef = db.collection("groups").document(newGroup.getgCode());
                docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        final Group myGroup = documentSnapshot.toObject(Group.class);
                        final int tCount = myGroup.getTaskCount();
                        Task myTask = new Task(tName, tPoints);
                        db.collection("groups").document(myGroup.getgCode()).set(myGroup);
                        db.collection("groups").document(myGroup.getgCode()).collection("tasks").document(String.valueOf(tCount + 1)).set(myTask);

                        myGroup.setTaskCount(tCount + 1);
                        Intent intent1 = new Intent(getBaseContext(), TodayTaskList.class); //NEEDS TO CHANGE
                        intent1.putExtra("user", newUser); //NEEDS TO CHANGE
                        intent1.putExtra("group", myGroup);
                        intent1.putExtra("task", myTask);
                        startActivity(intent1); // NEEDS TO CHANGE
                    }
                });

            }
        });
    }

}
