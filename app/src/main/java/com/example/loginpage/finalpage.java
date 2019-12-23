package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class finalpage extends AppCompatActivity {
TextView usernametextview;
SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalpage);
        pref = getSharedPreferences("registration",MODE_PRIVATE);
        usernametextview = findViewById(R.id.usernameview);
        usernametextview.setText("hello"+" "+pref.getString("username",null));
    }
}
