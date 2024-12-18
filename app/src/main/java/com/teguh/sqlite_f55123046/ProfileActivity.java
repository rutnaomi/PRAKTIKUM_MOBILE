package com.teguh.sqlite_f55123046;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private ImageView settingsBack;
    private TextView fullNameTextView, emailTextView, passwordTextView;
    private EditText fullNameEditText, emailEditText, passwordEditText;
    private ImageView togglePasswordView;
    private Button btnCancel, btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);  // Link to your XML layout

        // Initialize Views
        settingsBack = findViewById(R.id.settings_back);
        fullNameTextView = findViewById(R.id.kolom_nama);
        emailTextView = findViewById(R.id.email);
        passwordTextView = findViewById(R.id.password);

        fullNameEditText = findViewById(R.id.P_full_name);
        emailEditText = findViewById(R.id.P_email);
        passwordEditText = findViewById(R.id.P_password);
        togglePasswordView = findViewById(R.id.P_toggle_password);

        btnCancel = findViewById(R.id.btn_cancel);
        btnSave = findViewById(R.id.btn_save);

        // Set example data if needed
        fullNameEditText.setText("Admin Kece23");
        emailEditText.setText("adminkece23@gmail.com");

        // Set click listener for toggle password visibility
        togglePasswordView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwordEditText.getInputType() == 129) {
                    // Show password
                    passwordEditText.setInputType(145);
                    togglePasswordView.setImageResource(R.drawable.ic_eye);
                } else {
                    // Hide password
                    passwordEditText.setInputType(129);
                    togglePasswordView.setImageResource(R.drawable.ic_eye);
                }
                passwordEditText.setSelection(passwordEditText.getText().length());
            }
        });

        // Set OnClickListeners for buttons
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle cancel button click
                finish();  // Close the activity
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle save button click
                // Implement your save logic here
            }
        });

        // Set click listener for back button
        settingsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();  // Close the activity
            }
        });
    }
}
