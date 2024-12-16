package com.teguh.sqlite_f55123046;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.teguh.sqlite_f55123046.databinding.ActivityLoginBinding;
import com.teguh.sqlite_f55123046.utils.DatabaseHelper;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);

        // Login Button
        binding.RBtn1.setOnClickListener(view -> {
            String email = binding.LEdtEmail.getText().toString().trim();
            String password = binding.LEdtPassword.getText().toString().trim();

            boolean res = databaseHelper.checkUser(email, password);

            if (res) {
                Toast.makeText(LoginActivity.this, "Successfully Logged In", Toast.LENGTH_SHORT).show();
                Intent contentIntent = new Intent(LoginActivity.this, ContentActivity.class);
                startActivity(contentIntent);
            } else {
                Toast.makeText(LoginActivity.this, "Email or Password is Incorrect", Toast.LENGTH_SHORT).show();
            }
        });

        // Register Button
        binding.RBtn1.setOnClickListener(view -> {
            Intent registerIntent = new Intent(LoginActivity.this, ContentActivity.class);
            startActivity(registerIntent);
        });
    }
}
