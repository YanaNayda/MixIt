package com.example.mixit;

import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogIn extends AppCompatActivity {

    private boolean isPasswordVisible = false;
    private FirebaseAuth mAuth; // Initialize FirebaseAuth


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        Button buttonForgotYourPassword =(Button) findViewById(R.id.buttonForgotPassword);
        Button buttonNewAccount = (Button) findViewById(R.id.buttonNewAccount);
        Button buttonLogIn =(Button)findViewById(R.id.buttonLogIn);
        ImageButton  buttonEye =(ImageButton)findViewById(R.id.eyeButton);
        EditText  editPassword =(EditText)findViewById(R.id.editTextPasswordSignIn);
        EditText editEmail = (EditText)findViewById(R.id.editTextEmailSign) ;
        TextView textLogInWith=(TextView)findViewById(R.id.textLogInWith);
        mAuth = FirebaseAuth.getInstance();



        // Line under textView "textLogInWith"
        String textLogwithLine = (String) textLogInWith.getText();
        SpannableString LineForTextLogWith =new SpannableString(textLogwithLine);
        LineForTextLogWith.setSpan(new UnderlineSpan(), 0,textLogwithLine.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textLogInWith.setText(LineForTextLogWith);


        // Line under text in the button "buttonForgotPassword"
        String textForgotYourPassword = (String) buttonForgotYourPassword.getText();
        SpannableString LineForForgotButton =new SpannableString(textForgotYourPassword);
        LineForForgotButton.setSpan(new UnderlineSpan(), 0,textForgotYourPassword.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        buttonForgotYourPassword.setText(LineForForgotButton);

        //editPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
       // buttonEye.setImageResource(R.drawable.eye_close_ic);


        buttonEye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if( isPasswordVisible){
                   editPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                   buttonEye.setImageResource(R.drawable.eye_close_ic);
                   isPasswordVisible = false;
               }
               else{
                   editPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                   buttonEye.setImageResource(R.drawable.eye_open_ic);
                   isPasswordVisible = true;
               }

            }
        });

        buttonNewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(LogIn.this,
                        CreateAccount.class);
                startActivity(myIntent);
            }
        });
        buttonLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = editPassword.getText().toString();
                String email = editEmail.getText().toString();

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LogIn.this, "Please fill in all fields.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Call the login method
                loginUser(email, password);
            }
        });


    }

    private void loginUser(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, navigate to main activity
                        FirebaseUser user = mAuth.getCurrentUser();
                        Toast.makeText(LogIn.this, "Authentication successful.", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LogIn.this, Home.class));
                        finish();
                    } else {
                        // If sign in fails, display a message to the user
                        Toast.makeText(LogIn.this, "Authentication failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

    }

}