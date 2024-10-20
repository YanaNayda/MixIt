package com.example.mixit;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.UnderlineSpan;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        Button buttonForgotYourPassword =(Button) findViewById(R.id.buttonForgotPassword);
        TextView textLogInWith=(TextView)findViewById(R.id.textLogInWith);

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



    }
}