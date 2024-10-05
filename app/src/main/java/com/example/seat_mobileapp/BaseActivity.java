package com.example.seat_mobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.seat_mobileapp.home_dashboard;

public class BaseActivity extends AppCompatActivity {
    protected ImageButton loc, sched, announce, topUp, home, profileMenu;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Any specific code to all activities can be added here daw :>
    }

    protected void setUpNavBar() {
        profileMenu = findViewById(R.id.menu);
        loc = findViewById(R.id.location);
        sched = findViewById(R.id.sched);
        announce = findViewById(R.id.announce);
        topUp = findViewById(R.id.topup);
        home = findViewById(R.id.home);

        loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent locIntent = new Intent(BaseActivity.this, current_loc.class);
                startActivity(locIntent);
            }
        });

        sched.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent schedIntent = new Intent(BaseActivity.this, train_sched.class);
                startActivity(schedIntent);
            }
        });

//        announce.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent announceIntent = new Intent(com.example.seat_mobileapp.BaseActivity.this, announce_page.class);
//                startActivity(announceIntent);
//            }
//        });

        topUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent topupIntent = new Intent(com.example.seat_mobileapp.BaseActivity.this, topup_page.class);
                startActivity(topupIntent);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(BaseActivity.this, home_dashboard.class);
                startActivity(homeIntent);
            }
        });

        profileMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu profilePopup = new PopupMenu(BaseActivity.this, profileMenu);
                profilePopup.getMenuInflater().inflate(R.menu.profile_menu, profilePopup.getMenu());

                profilePopup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if (menuItem.getItemId() == R.id.about) {
                            // redirect to about page
                            return true;
                        } else if (menuItem.getItemId() == R.id.logout) {
                            Intent logoutIntent = new Intent(BaseActivity.this, MainActivity.class);
                            startActivity(logoutIntent);
                            return true;
                        } else if (menuItem.getItemId() == R.id.support) {
                            // redirect to support
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
