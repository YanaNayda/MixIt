package com.example.mixit;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public  class HelperBaseActivity extends AppCompatActivity {
    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

            bottomNavigationView.setOnItemSelectedListener(item -> {
                int itemId = item.getItemId();
                if (itemId == R.id.home_settings) {
                    startActivity(new Intent(this, Home.class));
                    return true;
                } else if (itemId == R.id.game_settings) {
                    startActivity(new Intent(this, Home.class));
                    return true;
                } else if (itemId == R.id.diy_settings) {
                    startActivity(new Intent(this, Home.class));
                    return true;
                } else if (itemId == R.id.advice_settings) {
                    startActivity(new Intent(this, Home.class));
                    return true;
                } else if (itemId == R.id.cocktails_settings) {
                    startActivity(new Intent(this, Home.class));
                    return true;
                }
                return false;
            });
        }
}



        // Toolbar toolbar = activity.findViewById(R.id.toolbar);
        //
        //
        // if (toolbar == null) {
        //     throw new IllegalStateException("Toolbar not found in layout.");
        // }
        // toolbar.setTitle("Home");
        //
        // // Example button setup
        //
        // // Set up each button’s action
        // toolbar.findViewById(R.id.game_button).setOnClickListener(view -> {
        //     Intent intent = new Intent(activity, Home.class);
        //     activity.startActivity(intent);
        // });
        //
        // toolbar.findViewById(R.id.cocktail_button).setOnClickListener(view -> {
        //     Intent intent = new Intent(activity, Home.class);
        //     activity.startActivity(intent);
        // });
        //
        // toolbar.findViewById(R.id.home_button).setOnClickListener(view -> {
        //     Intent intent = new Intent(activity,Home.class);
        //     activity.startActivity(intent);
        // });
        //
        // toolbar.findViewById(R.id.advice_button).setOnClickListener(view->{
        //     Intent intent = new Intent (activity, Home.class);
        //     activity.startActivity(intent);
        // });
        //
        // toolbar.findViewById(R.id.diy_button).setOnClickListener(view->{
        //     Intent intent = new Intent (activity, Home.class);
        //     activity.startActivity(intent);
        // });
        //

