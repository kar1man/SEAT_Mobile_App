package com.example.seat_mobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class TopUpComplete extends class_NavButtons {

    String addedAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.page_top_up_complete);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Get data from topup and display it
        getDataFromTopup();

        // Going back to dashboard
        backToDashboard();
    }

    private void getDataFromTopup() {
        // getting the data
        Intent finishTransac = getIntent();

        // local views where data will be displayed
        TextView totalAmount = findViewById(R.id.seatAmountDisplay);
        TextView paymentMethod = findViewById(R.id.payMethodDisplay);
        TextView transacID = findViewById(R.id.transacIdDisplay);
        TextView transacStatus = findViewById(R.id.payStatDisplay);
        TextView totalPrice = findViewById(R.id.totalPrice);

        totalAmount.setText(getIntent().getStringExtra("amount"));
        paymentMethod.setText(getIntent().getStringExtra("paymentMethod"));
        transacID.setText(getIntent().getStringExtra("transacId"));
        transacStatus.setText(getIntent().getStringExtra("paymentStatus"));
        totalPrice.setText(getIntent().getStringExtra("totalPrice").replace(" SEAT Credits", "").trim());

        addedAmount = finishTransac.getStringExtra("amount");
    }


    private void backToDashboard() {
        Button dashboardBtn = findViewById(R.id.backHomeButton);
        dashboardBtn.setOnClickListener(v -> {
            Intent backToDashBoard = new Intent(TopUpComplete.this, HomeDashboard.class);
            backToDashBoard.putExtra("addedBalance", addedAmount);
            startActivity(backToDashBoard);
        });
    }
}