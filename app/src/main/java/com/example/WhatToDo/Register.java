package com.example.WhatToDo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
//import android.support.v7.app.AppCompatActivity;

public class Register extends AppCompatActivity {
    private FirebaseFirestore db;
  //  private FirebaseDatabase mDatabase;
   // private DatabaseReference mDatabaseReference;
    private FirebaseAuth mAuth;
    private int numUsers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //Have to fix these inputs

//        mDatabase = FirebaseDatabase.getInstance();
 //       mDatabaseReference = mDatabase.getReference();
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        final Button btnSubmit = (Button) findViewById(R.id.submitbtn);
 //       final TextView usernameText = (TextView) findViewById(R.id.usernameInput);
        final TextView passwordText = (TextView) findViewById(R.id.passwordInput);
        final TextView passwordConfirmText = (TextView) findViewById(R.id.confirmPWInput);
        final TextView emailText = (TextView) findViewById(R.id.emailInput);
        final TextView firstnameText = (TextView) findViewById(R.id.firstnameInput);
        final TextView lastnameText = (TextView) findViewById(R.id.lastnameInput);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //            mDatabaseReference = mDatabase.getReference().child("Groups");
                //              mDatabaseReference.removeValue();  //Used for LG Doomsday
                //       String username = usernameText.getText().toString();
                String password = passwordText.getText().toString();
                String passwordConfirm = passwordConfirmText.getText().toString();
                String email = emailText.getText().toString();
                final String firstname = firstnameText.getText().toString();
                final String lastname = lastnameText.getText().toString();

                final String name = firstname + " " + lastname;
//                User user = new User(username, password, firstname, lastname, email);
//                mDatabaseReference = mDatabase.getReference().child("name" + numUsers);
//                mDatabaseReference.setValue(name);
//                mDatabaseReference.child("users").setValue(user);
                if (password.equals(passwordConfirm)) {
                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        //                         int count;
                                        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                                .setDisplayName(name).build();
                                        user.updateProfile(profileUpdates)
                                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<Void> task) {

                                                    }
                                                });

                                        Intent intent1 = new Intent(getBaseContext(), MainActivity.class);
                                        String uid = user.getUid();
                                        String email = user.getEmail();
//                                    String name = user.getDisplayName(); //Doesn't work for some reason
                                        String name = firstname + " " + lastname;
                                        final User newUser = new User(uid, name, email);
                                        db.collection("users").document(uid).set(newUser);
                                        //                                   mDatabaseReference = mDatabase.getReference().child("users").child(newUser.getuID());
//                                    mDatabaseReference.child("users").setValue(user);
//                                    mDatabaseReference = mDatabase.getReference().child("users").child("count");
//                                    mDatabaseReference.setValue(count + 1);
                                        //                                  mDatabaseReference = mDatabase.getReference().child("users").child(Integer.toString(count+1));
                                        //                                 mDatabaseReference.setValue(newUser);
                                        startActivity(intent1);
                                    } else {
                                        Toast.makeText(Register.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                    numUsers++;
                    //Until database is setup, these strings would be stored in a text file.
                    //               Intent intent1 = new Intent(getBaseContext(), MainActivity.class);
                    //               startActivity(intent1);
                }
                else {
                    Toast.makeText(Register.this, "Passwords do not match. Try again", 2).show();
                    passwordText.setText("");
                    passwordConfirmText.setText("");
                }
            }
        });
    }
}
