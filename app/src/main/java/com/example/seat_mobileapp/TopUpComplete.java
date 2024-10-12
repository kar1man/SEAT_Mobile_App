package com.example.seat_mobileapp;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TopUpComplete extends class_NavButtonsFunction {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ImageButton dashboardBtn;

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.page_top_up_complete);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setUpNavBar(TopUpComplete.class); // for navigation buttons


        // To be implemented once topup ui was completed
//        dashboardBtn = findViewById(R.id.dashboard);
//        dashboardBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent backToDashBoard = new Intent(topup_complete.this, home_dashboard.class);
//                startActivity(backToDashBoard);
//            }
//        });

    }
}