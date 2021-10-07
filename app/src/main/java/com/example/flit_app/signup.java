package com.example.flit_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    EditText username1, password1, renterpassword;
    Button signup1, signin1;
    DBhelper myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username1 = (EditText) findViewById(R.id.username1);
        password1 = (EditText) findViewById(R.id.password1);
        renterpassword = (EditText) findViewById(R.id.password2);

        signup1 = (Button) findViewById(R.id.signup1);
        signin1 = (Button) findViewById(R.id.signin1);

        myDB = new DBhelper(this);

        signup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username1.getText().toString();
                String pass = password1.getText().toString();
                String repass = renterpassword.getText().toString();

                if (user.equals("") || pass.equals("") || repass.equals("")) {
                    Toast.makeText(signup.this, "FILL ALL THE DETAILS", Toast.LENGTH_SHORT).show();
                } else {
                    if (pass.equals(repass)) {
                        Boolean usercheckresult = myDB.checkusername(user);
                        if (usercheckresult==false)
                        {
                            Boolean regresult=  myDB.insertData(user,pass);
                            if (regresult==true)
                            {
                                Toast.makeText(signup.this, "Registration successful ", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),login.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(signup.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(signup.this, "User already exists.\n please sign in ", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(signup.this, "PASSWORD NOT MATCHED ", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
        signin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),login.class);
                startActivity(intent);
            }
        });
    }

}
