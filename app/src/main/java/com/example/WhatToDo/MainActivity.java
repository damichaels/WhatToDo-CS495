package com.example.WhatToDo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button btnLogin = (Button) findViewById(R.id.btnLogin);
        final Button btnRegister = (Button) findViewById(R.id.registerbtn);
        final TextView usernameLogin = (TextView) findViewById(R.id.txtLogin);
        final TextView passwordLogin = (TextView) findViewById(R.id.passwordTextBox);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameLogin.getText().toString();
                String password = passwordLogin.getText().toString();
                if (username.equals("user")) {
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
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getBaseContext(), Register.class);
                startActivity(myIntent);
            }

        });
    }
}
