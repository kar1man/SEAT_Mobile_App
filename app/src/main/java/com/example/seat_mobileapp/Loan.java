package com.example.seat_mobileapp;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Loan extends class_NavButtons {

    private LinearLayout customContainer;
    private View customAmountView;

    private Button amount1000, amount500, amount250, amount100, amount50, amount20;
    private Button selectedAmountButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.page_loan);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setUpNavBar(Loan.class);
        customAmount();

        HorizontalScrollView horizontalScrollView = findViewById(R.id.horizontal_scroll_view);

        amount1000 = findViewById(R.id.amount_1000);
        amount500 = findViewById(R.id.amount_500);
        amount250 = findViewById(R.id.amount_250);
        amount100 = findViewById(R.id.amount_100);
        amount50 = findViewById(R.id.amount_50);
        amount20 = findViewById(R.id.amount_20);

        Button purchaseButton = findViewById(R.id.purchase_button);
        purchaseButton.setOnClickListener(this::onPurchaseNowClicked);

        amount1000.setOnClickListener(view -> selectAmount(amount1000));
        amount500.setOnClickListener(view -> selectAmount(amount500));
        amount250.setOnClickListener(view -> selectAmount(amount250));
        amount100.setOnClickListener(view -> selectAmount(amount100));
        amount50.setOnClickListener(view -> selectAmount(amount50));
        amount20.setOnClickListener(view -> selectAmount(amount20));

        horizontalScrollView.setOnScrollChangeListener((v, scrollX, scrollY, oldScrollX, oldScrollY) -> {
        });

        ColorStateList colorStateList = getResources().getColorStateList(R.color.button_color_state);
        amount1000.setBackgroundTintList(colorStateList);
        amount500.setBackgroundTintList(colorStateList);
        amount250.setBackgroundTintList(colorStateList);
        amount100.setBackgroundTintList(colorStateList);
        amount50.setBackgroundTintList(colorStateList);
        amount20.setBackgroundTintList(colorStateList);
    }

    private void customAmount() {
        ToggleButton customToggleBtn = findViewById(R.id.customToggle);
        customContainer = findViewById(R.id.custom_amount_container);

        customToggleBtn.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                if(customAmountView == null){
                    customAmountView = LayoutInflater.from(this).inflate(R.layout.popup_custom_amount, customContainer, false);
                    customContainer.addView(customAmountView);
                }
                customAmountView.setVisibility(View.VISIBLE);
            } else {
                if (customAmountView != null) {
                    customAmountView.setVisibility(View.GONE);
                }
            }
        });


    }


    private void selectAmount(Button amountButton) {
        if (selectedAmountButton != null) {
            selectedAmountButton.setSelected(false);
        }
        selectedAmountButton = amountButton;
        selectedAmountButton.setSelected(true);
    }

    public void onPurchaseNowClicked(View view) {
        Intent intent = new Intent(this, TopUpComplete.class);
        startActivity(intent);
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (selectedAmountButton != null) {
            selectedAmountButton.setSelected(false);
            selectedAmountButton = null;
        }
    }
}
