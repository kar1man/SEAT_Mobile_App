package com.example.seat_mobileapp;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Support extends class_NavButtons {
    private LinearLayout faq1Container, faq2Container, faq3Container;
    private View faq1View, faq2View, faq3View;
    private Button concernBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.page_support);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setUpNavBar(Support.class);
        faqDropdown();
        personalizedConcern();
    }



    private void faqDropdown() {
        ToggleButton faq1Toggle, faq2Toggle, faq3Toggle;

        faq1Toggle = findViewById(R.id.faq1);
        faq1Container = findViewById(R.id.faq1_container);

        faq1Toggle.setOnCheckedChangeListener((buttonView, isTicked) -> {
            if (isTicked) {
                if (faq1View == null) {
                    faq1View = LayoutInflater.from(this).inflate(R.layout.popup_faq1, faq1Container, false);
                    faq1Container.addView(faq1View);
                }
                faq1View.setVisibility(View.VISIBLE);
            } else {
                if (faq1View != null) {
                    faq1View.setVisibility(View.GONE);
                }
            }
        });

        faq2Toggle = findViewById(R.id.faq2);
        faq2Container = findViewById(R.id.faq2_container);

        faq2Toggle.setOnCheckedChangeListener((buttonView, isTicked2) -> {
            if (isTicked2) {
                if (faq2View == null) {
                    faq2View = LayoutInflater.from(this).inflate(R.layout.popup_faq2, faq2Container, false);
                    faq2Container.addView(faq2View);
                }
                faq2View.setVisibility(View.VISIBLE);
            } else {
                if(faq2View !=null) {
                    faq2View.setVisibility(View.GONE);
                }
            }
        });

        faq3Toggle = findViewById(R.id.faq3);
        faq3Container = findViewById(R.id.faq3_container);

        faq3Toggle.setOnCheckedChangeListener((buttonView, isTicked3) -> {
            if(isTicked3) {
                if(faq3View == null) {
                    faq3View = LayoutInflater.from(this).inflate(R.layout.popup_faq3, faq3Container, false);
                    faq3Container.addView(faq3View);
                }
                faq3View.setVisibility(View.VISIBLE);
            } else {
                if(faq3View != null){
                    faq3View.setVisibility(View.GONE);
                }
            }
        });

    }

    private void personalizedConcern() {
        // Color and concern handler
        ColorStateList btnColor = getResources().getColorStateList(R.color.button_color_state);
        concernBtn = findViewById(R.id.sendConcernBtn);
        concernBtn.setBackgroundTintList(btnColor);

        concernBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent concernIntent = new Intent(Support.this, ConcernReceived.class);
                startActivity(concernIntent);
            }
        });


    }
}