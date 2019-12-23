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

public class MainActivity extends AppCompatActivity {
EditText useremail,userpassword;
Button loginbutton , registerbutton ;
SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        useremail = findViewById(R.id.email);
        userpassword = findViewById(R.id.password);
   loginbutton = findViewById(R.id.login);
   registerbutton = findViewById(R.id.register);
   registerbutton.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           Intent intent= new Intent(MainActivity.this, register.class);
           startActivity(intent);
       }
   });
   pref=getSharedPreferences("registration",MODE_PRIVATE);
   final String email = pref.getString("email",null);
   final String pass = pref.getString("password",null);
   loginbutton.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           if (useremail.getText().toString().equals(email) && userpassword.getText().toString().equals(pass)){
               Intent a = new Intent(MainActivity.this, finalpage.class);
               startActivity(a);
           }
            else
               Toast.makeText(getApplicationContext(), "wrong entries", Toast.LENGTH_SHORT).show();
       }
   });
    }
}
