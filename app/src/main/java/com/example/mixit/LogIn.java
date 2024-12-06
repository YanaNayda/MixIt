package com.example.mixit;

import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class LogIn extends AppCompatActivity {

    private boolean isPasswordVisible = false;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        FirebaseFirestore db = FirebaseFirestore.getInstance();


        setContentView(R.layout.activity_welcome);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        Button buttonStart = findViewById(R.id.StartButton);
        buttonStart.setOnClickListener(v -> showLogInScreen());
    }

    private void showLogInScreen() {

        setContentView(R.layout.activity_log_in);

        mAuth = FirebaseAuth.getInstance();

        Button buttonForgotYourPassword = findViewById(R.id.buttonForgotPassword);
        Button buttonNewAccount = findViewById(R.id.buttonNewAccount);
        Button buttonLogIn = findViewById(R.id.buttonLogIn);
        ImageButton buttonEye = findViewById(R.id.eyeButton);
        EditText editPassword = findViewById(R.id.editTextPasswordSignIn);
        EditText editEmail = findViewById(R.id.editTextEmailSign);
        TextView textLogInWith = findViewById(R.id.textLogInWith);

        // Подчеркивание текста
        underlineText(textLogInWith);
        underlineText(buttonForgotYourPassword);

        // Обработка видимости пароля
        buttonEye.setOnClickListener(v -> togglePasswordVisibility(editPassword, buttonEye));

        // Переход на экран регистрации
        buttonNewAccount.setOnClickListener(v -> {
            Intent myIntent = new Intent(LogIn.this, CreateAccount.class);
            startActivity(myIntent);
        });

        // Логин
        buttonLogIn.setOnClickListener(v -> {
            String password = editPassword.getText().toString();
            String email = editEmail.getText().toString();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(LogIn.this, "Please fill in all fields.", Toast.LENGTH_SHORT).show();
                return;
            }



            loginUser(email, password);
        });
    }

    private void underlineText(TextView textView) {
        String text = textView.getText().toString();
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new UnderlineSpan(), 0, text.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);
    }

    private void togglePasswordVisibility(EditText editPassword, ImageButton buttonEye) {
        if (isPasswordVisible) {
            editPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            buttonEye.setImageResource(R.drawable.eye_close_ic);
            isPasswordVisible = false;
        } else {
            editPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            buttonEye.setImageResource(R.drawable.eye_open_ic);
            isPasswordVisible = true;
        }
    }

    private void loginUser(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser user = mAuth.getCurrentUser();
                        Toast.makeText(LogIn.this, "Authentication successful.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LogIn.this, Home.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(LogIn.this, "Authentication failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
