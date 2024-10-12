package com.example.seat_mobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeDashboard extends class_NavButtons {

    Button loanBtn, transcationBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.page_home_dashboard);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setUpNavBar(HomeDashboard.class);

        onButtonListener();
    }

    private void onButtonListener() {
        loanBtn = findViewById(R.id.loan);
        // Not yet implemented

        transcationBtn = findViewById(R.id.otherTransac);
        transcationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent transactionIntent = new Intent(HomeDashboard.this, TransacHistory.class);
                startActivity(transactionIntent);
            }
        });

    }
}