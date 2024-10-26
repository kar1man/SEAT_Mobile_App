package com.example.seat_mobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TopUpComplete extends class_NavButtons {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button dashboardBtn;

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.page_top_up_complete);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        dashboardBtn = findViewById(R.id.backHomeButton);
        dashboardBtn.setOnClickListener(v -> {
            Intent backToDashBoard = new Intent(TopUpComplete.this, HomeDashboard.class);
            startActivity(backToDashBoard);
        });

    }
}