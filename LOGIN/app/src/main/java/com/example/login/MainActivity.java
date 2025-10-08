package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username,editTextTextPersonName2,inputPassword,inputConfirmPassword;
    Button btnRegister,btnlogin;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=findViewById(R.id.username);
        DB = new DBHelper(this);
        editTextTextPersonName2=findViewById(R.id.editTextTextPersonName2);
        inputPassword=findViewById(R.id.inputPassword);
        inputConfirmPassword=findViewById(R.id.inputConfirmPassword);
        btnRegister=findViewById(R.id.btnRegister);
        btnlogin=findViewById(R.id.btnlogin);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameValue = username.getText().toString();
                String editTextTextPersonName2Value = editTextTextPersonName2.getText().toString();
                String inputPasswordValue = inputPassword.getText().toString();
                String inputConfirmPasswordValue = inputConfirmPassword.getText().toString();

                if (usernameValue.equals("") || editTextTextPersonName2Value.equals("") || inputPasswordValue.equals("")) {
                    Toast.makeText(MainActivity.this, "Blank not allowed", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean checkinsertdata = DB.insertuserdata(usernameValue, editTextTextPersonName2Value, inputPasswordValue);
                    if (checkinsertdata == true)
                        Toast.makeText(MainActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(MainActivity.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
                }
            }});

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent send = new Intent(MainActivity.this, SignIn.class);
                startActivity(send);
            }
        });
    }
    }
