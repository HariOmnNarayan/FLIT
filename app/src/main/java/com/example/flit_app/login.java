package com.example.flit_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

public class login extends AppCompatActivity {

        EditText username, password;
        Button login,signin;
        DBhelper myDB;

        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login3);
            username = (EditText) findViewById(R.id.usernamelogin);
            password = (EditText) findViewById(R.id.passwordlogin);
            login = (Button) findViewById(R.id.Login);
            signin = (Button) findViewById(R.id.signup);

            myDB = new DBhelper(this);
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String user = username.getText().toString();
                    String pass = password.getText().toString();
                    if (user.equals("") || pass.equals("")) {
                        Toast.makeText(login.this, "please enter the credentials", Toast.LENGTH_SHORT).show();
                    } else {
                        Boolean result = myDB.checkusernamepassword(user, pass);
                        if (result == true) {
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(login.this, "invalid credentials", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

            });

            signin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), signup.class);
                    startActivity(intent);
                }
            });
        }

 }
