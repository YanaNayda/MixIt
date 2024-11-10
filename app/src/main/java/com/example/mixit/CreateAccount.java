package com.example.mixit;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ValueEventListener;


public class CreateAccount extends AppCompatActivity {

    private boolean isPasswordVisible = false;
    private boolean isPasswordConfirmVisible = false;
    private DatabaseReference databaseReference;
    private FirebaseAuth mAuth;
    private boolean isNameValid = false; // Track name validity
    private boolean isEmailValid = false;
    private boolean isPassValid= false;
    private boolean isPassConfValid =false;// Track email validity





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_account);


        ImageButton buttonBack = (ImageButton) findViewById(R.id.buttonBack);
        ImageButton buttonEyePass = (ImageButton) findViewById(R.id.buttonEyePass);
        ImageButton buttonEyeConfirm = (ImageButton) findViewById(R.id.buttonEyeConfirm);
        EditText editPassword = (EditText) findViewById(R.id.editPassword);
        EditText editConfirmPassword = (EditText) findViewById(R.id.editConfirmPassword);
        EditText editName = (EditText) findViewById(R.id.editName);
        EditText editEmail = (EditText) findViewById(R.id.editEmail);
        Button buttonRegister = (Button) findViewById(R.id.buttonRegister);
        TextView textvalidPass = (TextView) findViewById(R.id.textvalid);

        // Initialize Firebase Database reference pointing to "users" node
        databaseReference = FirebaseDatabase.getInstance().getReference("users");
        mAuth = FirebaseAuth.getInstance();


        editName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String name = s.toString();
                if (name.matches("[a-zA-Z_ ]+")) {
                    setStrokeColor("#3C966C", editName);
                    isNameValid=true;

                } else {
                    // If input is invalid (contains non-letter characters), set background to red
                    editName.setError("Name must contain letters only");
                    setStrokeColor("#F44336", editName);
                    isNameValid=false;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        editEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String email = s.toString().trim();
                checkEmailExists(email.trim());

                if (email.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")) {
                    setStrokeColor("#3C966C", editEmail);
                    isEmailValid= true;
                }
                else {
                    editEmail.setError("Invalid email");
                    setStrokeColor("#F44336", editEmail);
                    isEmailValid= false;

                }
            }
            private void checkEmailExists(String emailToCheck){
                databaseReference.orderByChild("email").equalTo(emailToCheck)
                        .addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                if (dataSnapshot.exists()) {
                                    // Show error directly on the email input field
                                    editEmail.setError("Email is already registered");
                                    setStrokeColor("#F44336", editEmail);
                                    isEmailValid=false;
                                } else
                                    isEmailValid= true;
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {
                                Log.e("EmailCheck", "Database error: " + databaseError.getMessage());
                            }
                        });
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        editPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String password = s.toString();
                String strength = getPasswordStrength(password);
                textvalidPass.setText(strength);

                if (strength.equals("Strong password")) {
                    setStrokeColor("#3C966C", editPassword);
                    textvalidPass.setTextColor(Color.parseColor("#3C966C"));
                    isPassValid=true;
                } else if (strength.equals("Moderate password")) {
                    setStrokeColor("#FFA500", editPassword); // Orange color for moderate
                    textvalidPass.setTextColor(Color.parseColor("#FFA500"));
                    isPassValid=true;
                } else { // Weak
                    setStrokeColor("#FF0000", editPassword); // Red color for weak
                    textvalidPass.setTextColor(Color.parseColor("#FF0000"));
                    isPassValid=false;
                }




            }

            private String getPasswordStrength(String password) {
                int score = 0;

                // Password length of at least 8 characters
                if (password.length() >= 8) score++;
                // Contains at least one uppercase letter
                if (password.matches(".*[A-Z].*")) score++;
                // Contains at least one lowercase letter
                if (password.matches(".*[a-z].*")) score++;
                // Contains at least one digit
                if (password.matches(".*[0-9].*")) score++;
                // Contains at least one special character
                if (password.matches(".*[!@#\\$%\\^&\\*].*")) score++;

                // Return a string based on the score
                if (score <= 2) return "Weak password";
                else if (score <= 4) return "Moderate password";
                else return "Strong password";
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(CreateAccount.this,
                        LogIn.class);
                startActivity(myIntent);

            }
        });

        buttonEyePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPasswordVisible) {
                    editPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    buttonEyePass.setImageResource(R.drawable.eye_close_ic);
                    isPasswordVisible = false;
                } else {
                    editPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    buttonEyePass.setImageResource(R.drawable.eye_open_ic);
                    isPasswordVisible = true;
                }

            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editEmail.getText().toString();
                String password = editPassword.getText().toString();
                String name = editName.getText().toString();
                String passConfirm= editConfirmPassword.getText().toString();

                if (password.equals(passConfirm)){
                    isPassConfValid =true;

                }

                if (!isNameValid){
                    setStrokeColor("#FF0000", editName);
                } if (!isEmailValid){
                    setStrokeColor("#FF0000", editEmail);
                } if (!isPassValid){
                    setStrokeColor("#FF0000", editPassword);
                }


                if (isEmailValid && isNameValid& isPassConfValid & isPassValid){
                    SignUser(email, password, name);
                }
                else{
                    Toast.makeText(CreateAccount.this, "Please correct the errors", Toast.LENGTH_SHORT).show();
                }


            }

        });

        buttonEyeConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPasswordConfirmVisible) {
                    editConfirmPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    buttonEyeConfirm.setImageResource(R.drawable.eye_close_ic);
                    isPasswordConfirmVisible = false;
                } else {
                    editConfirmPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    buttonEyeConfirm.setImageResource(R.drawable.eye_open_ic);
                    isPasswordConfirmVisible = true;
                }

            }

        });



    }


    private void SignUser(String email, String password, String name) {
        // Use createUserWithEmailAndPassword to register a new user
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Registration was successful
                        FirebaseUser user = mAuth.getCurrentUser();

                        if (user != null) {
                            // Create User object with user details (don't save password for security reasons)
                            User userData = new User(name, email,password); // Create the user with name and email only

                            // Write user data to the database under their unique ID
                            databaseReference.child(user.getUid()).setValue(userData)
                                    .addOnCompleteListener(dbTask -> {
                                        if (dbTask.isSuccessful()) {
                                            Toast.makeText(CreateAccount.this, "Data saved in database.", Toast.LENGTH_SHORT).show();

                                            // Redirect to main activity after saving user data
                                            startActivity(new Intent(CreateAccount.this, LogIn.class));
                                            finish();
                                        } else {
                                            Toast.makeText(CreateAccount.this, "Failed to save data.", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                        }
                    } else {
                        // Registration failed
                        Toast.makeText(CreateAccount.this, "Registration failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

    }

    public void setStrokeColor(String color, EditText text) {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(GradientDrawable.RECTANGLE);
        drawable.setColor(Color.TRANSPARENT);
        drawable.setStroke(4, Color.parseColor(color)); // Set stroke width and color
        drawable.setCornerRadius(70); // Set rounded corners
        text.setBackground(drawable);

    }

}