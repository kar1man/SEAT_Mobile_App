package com.example.seat_mobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class class_NavButtonsFunction extends AppCompatActivity {
    protected ImageButton loc, sched, announce, topUp, home, profileMenu;
    private Class<?> currentActivity;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Any specific code to all activities can be added here daw :>
    }

    protected void setUpNavBar(Class<?> currentActivity) {
        this.currentActivity = currentActivity;

        profileMenu = findViewById(R.id.menu);
        loc = findViewById(R.id.location);
        sched = findViewById(R.id.sched);
        announce = findViewById(R.id.announce);
        topUp = findViewById(R.id.topup);
        home = findViewById(R.id.home);

        // Nav button's functionalities
        setupButton(loc, LocationTracker.class);
        setupButton(sched, TrainSched.class);
//        setupButton(announce, announce_page.class); --> No page yet
        setupButton(topUp, TopUp.class); // --> to be complete
        setupButton(home, HomeDashboard.class);

        profileMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu profilePopup = new PopupMenu(class_NavButtonsFunction.this, profileMenu);
                profilePopup.getMenuInflater().inflate(R.menu.profile_menu, profilePopup.getMenu());

                profilePopup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if (menuItem.getItemId() == R.id.about) {
                            // redirect to about page
                            return true;
                        } else if (menuItem.getItemId() == R.id.logout) {
                            Intent logoutIntent = new Intent(class_NavButtonsFunction.this, Login.class);
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

    private void setupButton(ImageButton button, Class<?> targetActivity) {
        if (currentActivity == targetActivity) {
            button.setEnabled(false);
        } else {
            button.setEnabled(true);
            button.setOnClickListener(view -> {
                Intent redirectIntent = new Intent(class_NavButtonsFunction.this, targetActivity);
                startActivity(redirectIntent);
            });
        }
    }


}
