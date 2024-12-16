package com.teguh.sqlite_f55123046;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.teguh.sqlite_f55123046.databinding.ActivityRegisterBinding;
import com.teguh.sqlite_f55123046.utils.DatabaseHelper;

public class RegisterActivity extends AppCompatActivity {
    private ActivityRegisterBinding binding;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Initialize DatabaseHelper
        databaseHelper = new DatabaseHelper(this);

        // Handle register button click
        binding.RBtn1.setOnClickListener(view -> {
            // Get input values
            String fullName = binding.edtName.getText().toString().trim();
            String email = binding.edtEmail.getText().toString().trim();
            String password = binding.edtPassword1.getText().toString().trim();
            String confPass = binding.edtPassword2.getText().toString().trim();

            // Validate inputs
            if (fullName.isEmpty() || email.isEmpty() || password.isEmpty() || confPass.isEmpty()) {
                Toast.makeText(RegisterActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!password.equals(confPass)) {
                Toast.makeText(RegisterActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                return;
            }

            // Register user in database
            long result = databaseHelper.addUser(fullName, password);

            if (result > 0) {
                Toast.makeText(RegisterActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                Intent moveToLogin = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(moveToLogin);
                finish();
            } else {
                Toast.makeText(RegisterActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
