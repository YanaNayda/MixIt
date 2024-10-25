package com.example.mixit;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class CreateAccount extends AppCompatActivity {

    private boolean isPasswordVisible = false;
    private boolean isPasswordConfirmVisible = false;
    private DatabaseReference databaseReference;
    private FirebaseAuth mAuth;  // Initialize FirebaseAuth




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_account);

        ImageButton  buttonBack = (ImageButton)findViewById(R.id.buttonBack);
        ImageButton  buttonEyePass = (ImageButton)findViewById(R.id.buttonEyePass);
        ImageButton buttonEyeConfirm =(ImageButton)findViewById(R.id.buttonEyeConfirm);
        EditText editPassword = (EditText)findViewById(R.id.editPassword);
        EditText editConfirmPassword =(EditText)findViewById(R.id.editConfirmPassword);
        EditText editName = (EditText)findViewById(R.id.editName);
        EditText editEmail = (EditText)findViewById(R.id.editEmail);
        Button buttonRegister= (Button)findViewById(R.id.buttonRegister);

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
                if (s.toString().matches("[a-zA-Z_ ]+")) {
                    setStrokeColor("#3C966C",editName);

                } else {
                    // If input is invalid (contains non-letter characters), set background to red
                    editName.setError("Name must contain letters only");
                    setStrokeColor("#F44336",editName);
                }

            }

            private void setStrokeColor(String color, EditText text) {
                GradientDrawable drawable = new GradientDrawable();
                drawable.setShape(GradientDrawable.RECTANGLE);
                drawable.setColor(Color.TRANSPARENT);
                drawable.setStroke(4, Color.parseColor(color)); // Set stroke width and color
                drawable.setCornerRadius(70); // Set rounded corners
                text.setBackground(drawable);

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
                if( isPasswordVisible){
                    editPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    buttonEyePass.setImageResource(R.drawable.eye_close_ic);
                    isPasswordVisible = false;
                }
                else{
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
                SignUser(email,password,name);
            }

        });




        buttonEyeConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( isPasswordConfirmVisible){
                    editConfirmPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    buttonEyeConfirm.setImageResource(R.drawable.eye_close_ic);
                    isPasswordConfirmVisible = false;
                }
                else{
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

}