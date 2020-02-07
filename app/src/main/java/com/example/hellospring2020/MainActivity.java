package com.example.hellospring2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button btnLogin = (Button) findViewById(R.id.btnLogin);
        final TextView usernameLogin = (TextView) findViewById(R.id.txtLogin);
        final TextView passwordLogin = (TextView) findViewById(R.id.passwordTextBox);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameLogin.getText().toString();
                String password = passwordLogin.getText().toString();
                if (username.equals("jdtubbs3"))
                    if (password.equals("password"))
                        Toast.makeText(view.getContext(), "Open Sesame", 2).show();
                    else
                        Toast.makeText(view.getContext(), "Invaid Password. Try again", 2).show();
                else
                    Toast.makeText(view.getContext(), "Invalid username", 2).show();

                usernameLogin.setText("");
                passwordLogin.setText("");
            }
        });

    }
}
