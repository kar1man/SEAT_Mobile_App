package com.example.seat_mobileapp;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.UUID;

public class Loan extends class_NavButtons {

    private LinearLayout customContainer;
    private View customAmountView;
    private TextView amountDisplay;
    private EditText customAmountInput;
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

        amountDisplay = findViewById(R.id.total_amount);
        initializeButtons();
        customAmount();
    }

    private void initializeButtons() {
        int[] amountButtonIds = {R.id.amount_250, R.id.amount_100, R.id.amount_50, R.id.amount_20};
        for (int id : amountButtonIds) {
            Button button = findViewById(id);
            button.setOnClickListener(view -> selectAmount(button));
            button.setBackgroundTintList(getResources().getColorStateList(R.color.button_color_state));
        }

        Button purchaseButton = findViewById(R.id.purchase_button);
        purchaseButton.setOnClickListener(this::onPurchaseNowClicked);
    }

    private void customAmount() {
        ToggleButton customToggleBtn = findViewById(R.id.customToggle);
        customContainer = findViewById(R.id.custom_amount_container);

        customToggleBtn.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                if (customAmountView == null) {
                    customAmountView = LayoutInflater.from(this).inflate(R.layout.popup_custom_amount, customContainer, false);
                    customContainer.addView(customAmountView);
                    customAmountInput = customAmountView.findViewById(R.id.custom_amount_input);

                    customAmountInput.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {
                            if (selectedAmountButton != null) {
                                selectedAmountButton.setSelected(false);
                                selectedAmountButton = null;
                            }
                            amountDisplay.setText(s.toString().replace("\n", "").trim());
                        }

                        @Override
                        public void afterTextChanged(Editable s) {}
                    });
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
        if (customAmountInput != null) {
            customAmountInput.setText("");
        }

        selectedAmountButton = amountButton;
        selectedAmountButton.setSelected(true);
        amountDisplay.setText(selectedAmountButton.getText().toString().replace("PHP", "").replace("\n", "").trim());
    }

    public void onPurchaseNowClicked(View view) {
        if (amountDisplay == null) {
            return;
        }

        String amount = amountDisplay.getText().toString() + " SEAT Credits";
        String paymentMethod = "Loan";
        String transacID = UUID.randomUUID().toString().substring(0, 12);
        String status = "Success";
        String totalPrice = "Php " + amount;

        Intent finishTransac = new Intent(this, TopUpComplete.class);
        finishTransac.putExtra("amount", amount);
        finishTransac.putExtra("paymentMethod", paymentMethod);
        finishTransac.putExtra("transacId", transacID);
        finishTransac.putExtra("paymentStatus", status);
        finishTransac.putExtra("totalPrice", totalPrice);
        startActivity(finishTransac);
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
