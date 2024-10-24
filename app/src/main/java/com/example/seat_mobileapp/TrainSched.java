package com.example.seat_mobileapp;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TrainSched extends class_NavButtons {

    private LinearLayout lastClickedLayout = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.page_train_sched);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setUpNavBar(TrainSched.class);
        stationClickEventHandler();

    }

    private void stationClickEventHandler() {
        // Arrays to store station buttons
        Button[] stationButtons = {
                findViewById(R.id.roosevelt), findViewById(R.id.balintawak),
                findViewById(R.id.monumento), findViewById(R.id.fifthAve),
                findViewById(R.id.rPapa), findViewById(R.id.abadSantos),
                findViewById(R.id.blumentritt), findViewById(R.id.tayuman),
                findViewById(R.id.bambang), findViewById(R.id.doroteoJose),
                findViewById(R.id.carriedo), findViewById(R.id.central),
                findViewById(R.id.unitedNations), findViewById(R.id.pedroGil),
                findViewById(R.id.quirino), findViewById(R.id.vitoCruz),
                findViewById(R.id.gilPuyat), findViewById(R.id.libertad),
                findViewById(R.id.edsa), findViewById(R.id.baclaran)
        };

        // Arrays to store station buttons
        View[] stationDots = {
                findViewById(R.id.roosevelt_dot), findViewById(R.id.balintawak_dot),
                findViewById(R.id.monumento_dot), findViewById(R.id.fiftAve_dot),
                findViewById(R.id.rPapa_dot), findViewById(R.id.abadSantos_dot),
                findViewById(R.id.blumentritt_dot), findViewById(R.id.tayuman_dot),
                findViewById(R.id.bambang_dot), findViewById(R.id.doroteoJose_dot),
                findViewById(R.id.carriedo_dot), findViewById(R.id.central_dot),
                findViewById(R.id.unitedNations_dot), findViewById(R.id.pedroGil_dot),
                findViewById(R.id.quirino_dot), findViewById(R.id.vitoCruz_dot),
                findViewById(R.id.gilPuyat_dot), findViewById(R.id.libertad_dot),
                findViewById(R.id.edsa_dot), findViewById(R.id.baclaran_dot)
        };

        // Set click listeners using a loop
        for (int i = 0; i < stationButtons.length; i++) {
            final View dot = stationDots[i];  // Final reference for lambda
            stationButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changeColor((LinearLayout) dot);
                }
            });
        }
    }

    private void changeColor(LinearLayout layout) {
        if (lastClickedLayout != null) {
            lastClickedLayout.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFF3CE")));
        }
        layout.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#61542D")));
        lastClickedLayout = layout;
    }


}