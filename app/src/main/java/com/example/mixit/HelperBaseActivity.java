package com.example.mixit;

import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public  class HelperBaseActivity extends AppCompatActivity {
    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.helper_base);

            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            ImageView logo = findViewById(R.id.logo);
            logo.setVisibility(View.VISIBLE);


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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.profile_settings) {
            // Handle profile settings click
            return true;
        }
        return super.onOptionsItemSelected(item);
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

