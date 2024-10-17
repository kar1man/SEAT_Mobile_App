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

public class HomeDashboard extends class_NavButtons {

    ImageButton topUpBtn;
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

        topUpBtn = findViewById(R.id.topUpButton);
        topUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent topUpIntent = new Intent(HomeDashboard.this, TopUp.class);
                startActivity(topUpIntent);
            }
        });

        loanBtn = findViewById(R.id.loan);
        loanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loanIntent = new Intent(HomeDashboard.this, Loan.class);
                startActivity(loanIntent);
            }
        });

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
