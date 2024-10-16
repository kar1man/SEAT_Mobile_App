package com.example.seat_mobileapp;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TopUp extends class_NavButtons {

    private Button gcashButton, mayaButton, bdoButton, visaButton, grabPayButton, sevenElevenButton;
    private Button amount1000, amount500, amount250, amount100, amount50, amount20;
    private Button selectedPaymentMethod = null;
    private Button selectedAmountButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.page_top_up);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setUpNavBar(TopUp.class);

        HorizontalScrollView horizontalScrollView = findViewById(R.id.horizontal_scroll_view);

        gcashButton = findViewById(R.id.gcash_button);
        mayaButton = findViewById(R.id.maya_button);
        bdoButton = findViewById(R.id.bdo_button);
        visaButton = findViewById(R.id.visa_button);
        grabPayButton = findViewById(R.id.grabpay_button);
        sevenElevenButton = findViewById(R.id.seven_eleven_button);

        amount1000 = findViewById(R.id.amount_1000);
        amount500 = findViewById(R.id.amount_500);
        amount250 = findViewById(R.id.amount_250);
        amount100 = findViewById(R.id.amount_100);
        amount50 = findViewById(R.id.amount_50);
        amount20 = findViewById(R.id.amount_20);
        
        Button purchaseButton = findViewById(R.id.purchase_button);
        purchaseButton.setOnClickListener(this::onPurchaseNowClicked);

        gcashButton.setOnClickListener(view -> selectPaymentMethod(gcashButton));
        mayaButton.setOnClickListener(view -> selectPaymentMethod(mayaButton));
        bdoButton.setOnClickListener(view -> selectPaymentMethod(bdoButton));
        visaButton.setOnClickListener(view -> selectPaymentMethod(visaButton));
        grabPayButton.setOnClickListener(view -> selectPaymentMethod(grabPayButton));
        sevenElevenButton.setOnClickListener(view -> selectPaymentMethod(sevenElevenButton));

        amount1000.setOnClickListener(view -> selectAmount(amount1000));
        amount500.setOnClickListener(view -> selectAmount(amount500));
        amount250.setOnClickListener(view -> selectAmount(amount250));
        amount100.setOnClickListener(view -> selectAmount(amount100));
        amount50.setOnClickListener(view -> selectAmount(amount50));
        amount20.setOnClickListener(view -> selectAmount(amount20));

        horizontalScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
            }
        });

        ColorStateList colorStateList = getResources().getColorStateList(R.color.button_color_state);
        amount1000.setBackgroundTintList(colorStateList);
        amount500.setBackgroundTintList(colorStateList);
        amount250.setBackgroundTintList(colorStateList);
        amount100.setBackgroundTintList(colorStateList);
        amount50.setBackgroundTintList(colorStateList);
        amount20.setBackgroundTintList(colorStateList);

        gcashButton.setBackgroundTintList(colorStateList);
        mayaButton.setBackgroundTintList(colorStateList);
        bdoButton.setBackgroundTintList(colorStateList);
        visaButton.setBackgroundTintList(colorStateList);
        grabPayButton.setBackgroundTintList(colorStateList);
        sevenElevenButton.setBackgroundTintList(colorStateList);
    }


    private void selectAmount(Button amountButton) {
        if (selectedAmountButton != null) {
            selectedAmountButton.setSelected(false);
        }
        selectedAmountButton = amountButton;
        selectedAmountButton.setSelected(true);
    }

    private void selectPaymentMethod(Button paymentButton) {
        if (selectedPaymentMethod != null) {
            selectedPaymentMethod.setSelected(false);
        }
        selectedPaymentMethod = paymentButton;
        selectedPaymentMethod.setSelected(true);
    }

    public void onPurchaseNowClicked(View view) {
        Intent intent = new Intent(this, TopUpComplete.class);
        startActivity(intent);
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (selectedPaymentMethod != null) {
            selectedPaymentMethod.setSelected(false);
            selectedPaymentMethod = null;
        }
        if (selectedAmountButton != null) {
            selectedAmountButton.setSelected(false);
            selectedAmountButton = null;
        }
    }
}
