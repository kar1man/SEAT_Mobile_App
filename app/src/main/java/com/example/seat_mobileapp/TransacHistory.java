package com.example.seat_mobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TransacHistory extends class_NavButtons {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.page_transaction_history);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setUpNavBar(TransacHistory.class);
        topupOrLoanHandler();

    }

    @Override
    protected void onResume() {
        super.onResume();
        Float updatedBalance = getSharedPreferences("appData", MODE_PRIVATE)
                .getFloat("currentBalance", 0.0f);

        TextView currentBalanceView = findViewById(R.id.currentBalance);
        currentBalanceView.setText("₱" + String.format("%.2f", updatedBalance));
    }

    private void topupOrLoanHandler() {
        Button topupBtn = findViewById(R.id.topupButton);
        Button loanBtn = findViewById(R.id.loanButton);

        topupBtn.setOnClickListener(v -> {
            Intent topupIntent = new Intent(this, TopUp.class);
            startActivity(topupIntent);
        });

        loanBtn.setOnClickListener(v -> {
            Intent loanIntent = new Intent(this, Loan.class);
            startActivity(loanIntent);
        });

    }

}