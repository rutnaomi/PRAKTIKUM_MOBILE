package com.teguh.sqlite_f55123046;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.teguh.sqlite_f55123046.utils.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin, btnRegister;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize DatabaseHelper
        databaseHelper = new DatabaseHelper(this);

        // Bind UI components
        btnLogin = findViewById(R.id.btn_1);
        btnRegister = findViewById(R.id.btn_2);

        // Set up button listeners
        btnLogin.setOnClickListener(view -> {
            Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(loginIntent);
        });

        btnRegister.setOnClickListener(view -> {
            Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(registerIntent);
        });
    }
}
