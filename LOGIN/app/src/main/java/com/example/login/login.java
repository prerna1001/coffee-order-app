package com.example.login;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.app.ProgressDialog.show;

public class login extends AppCompatActivity {

    EditText password,username;
    Button login;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        password=findViewById(R.id.password);
        username=findViewById(R.id.username);
        login=findViewById(R.id.login);
        DB = new DBHelper(this);
        login=findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String usernameValue =username.getText().toString();
                String passwordValue =password.getText().toString();


                if(usernameValue.equals("")||passwordValue.equals(""))
                    Toast.makeText(login.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();

            else

            {

                Boolean checkuserpass = DB.checkusername(usernameValue, passwordValue);
                Toast.makeText(login.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();

                if (checkuserpass == true) {
                    Toast.makeText(login.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(login.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }
            }
            }

        });

    }
}