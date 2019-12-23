package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class register extends AppCompatActivity {
EditText newemail , newuser, newpass , reenternewpass;
Button registerbutton;
SharedPreferences pref;
SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        newemail = findViewById(R.id.email);
        newuser = findViewById(R.id.username);
        newpass = findViewById(R.id.password);
        reenternewpass = findViewById(R.id.newpassword);
        registerbutton = findViewById(R.id.register);
        pref = getSharedPreferences("registration",
                MODE_PRIVATE);
        editor = pref.edit();
        registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String useremail = newemail.getText().toString();
                String userpassword = newpass.getText().toString();
                String username= newuser.getText().toString();
                String reenteruserpassword = reenternewpass.getText().toString();
                if (useremail.length()>0 && userpassword.length()>0 && reenteruserpassword.equals(userpassword)){
                    editor.putString("email",useremail);
                    editor.putString("password",userpassword);
                    editor.putString("username",username);
                    editor.apply();
                    Intent i= new Intent(register.this, MainActivity.class);
                    startActivity(i);
                }
                else
                    Toast.makeText(getApplicationContext(), "wrong entries", Toast.LENGTH_SHORT).show();
                newemail.setText("");
                newpass.setText("");
                newuser.setText("");
                reenternewpass.setText("");
            }
        });
    }
}
