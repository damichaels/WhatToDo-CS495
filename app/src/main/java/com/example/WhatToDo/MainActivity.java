package com.example.WhatToDo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        final Button btnLogin = (Button) findViewById(R.id.btnLogin);
        final Button btnRegister = (Button) findViewById(R.id.registerbtn);
        final TextView usernameLogin = (TextView) findViewById(R.id.txtLogin);
        final TextView passwordLogin = (TextView) findViewById(R.id.passwordTextBox);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = usernameLogin.getText().toString();
                String password = passwordLogin.getText().toString();
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @SuppressLint("WrongConstant")
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Intent intent1 = new Intent(getBaseContext(), gList.class);
                                    startActivity(intent1);
                                } else {
                                    Toast.makeText(MainActivity.this, "Invalid Password. Try again", 2).show();
                                    usernameLogin.setText("");
                                    passwordLogin.setText("");
                                }
                            }
                        });
            }
        });

            /*    if (username.equals("user")) {
                    if (password.equals("password")) {
                        Toast.makeText(view.getContext(), "Open Sesame", 2).show();
                        Intent intent1 = new Intent(getBaseContext(), gList.class);
                        startActivity(intent1);
                    }
                    else
                    Toast.makeText(view.getContext(), "Invalid Password. Try again", 2).show();
                }
                else
                    Toast.makeText(view.getContext(), "Invalid username", 2).show();

                usernameLogin.setText("");
                passwordLogin.setText("");
                */

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getBaseContext(), Register.class);
                startActivity(myIntent);
            }

        });
    }

/*   public void basicReadWrite() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
*/
}

