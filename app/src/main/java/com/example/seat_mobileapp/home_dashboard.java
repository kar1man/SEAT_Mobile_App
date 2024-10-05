package com.example.seat_mobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class home_dashboard extends AppCompatActivity {

    ImageButton loc, sched, announce, topUp, home, profileMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_dashboard);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        navBarButtons();

    }

    private void navBarButtons() {
        profileMenu = findViewById(R.id.menu);

        loc = findViewById(R.id.location);
        sched = findViewById(R.id.sched);
        announce = findViewById(R.id.announce);
        topUp = findViewById(R.id.topup);
        home = findViewById(R.id.home);

        loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent locationIntent = new Intent(home_dashboard.this, current_loc.class);
                startActivity(locationIntent);
            }
        });

        sched.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent schedIntent = new Intent(home_dashboard.this, train_sched.class);
                startActivity(schedIntent);
            }
        });

//        announce.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent announceIntent = new Intent(home_dashboard.this, MainActivity.class);
//                startActivity(announceIntent);
//            }
//        });
//
//        topUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent topUpIntent = new Intent(home_dashboard.this, MainActivity.class);
//                startActivity(topUpIntent);
//            }
//        });

//        home.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent homeIntent = new Intent(home_dashboard.this, home_dashboard.class);
//                startActivity(homeIntent);
//            }
//        });


        profileMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu profilePopup = new PopupMenu(home_dashboard.this, profileMenu);
                profilePopup.getMenuInflater().inflate(R.menu.profile_menu, profilePopup.getMenu());

                profilePopup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if (menuItem.getItemId() == R.id.about) {
                            // Handle profile click
                            return true;

                        } else if (menuItem.getItemId() == R.id.logout) {
                            Intent logoutIntent = new Intent(home_dashboard.this, MainActivity.class);
                            startActivity(logoutIntent);
                            return true;

                        } else if (menuItem.getItemId() == R.id.support) {
                            // Handle support click
                            return true;
                        }
                        return false;
                    }
                });

                profilePopup.show();
            }
        });




    }


}