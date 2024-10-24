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

    private LinearLayout dotRoosevelt, dotBalintawak, dotMonumento, dotFifthAve, dotRpapa, dotAbadSantos, dotBlumentritt, dotTayuman, dotBambang, dotDJose, dotCarriedo, dotCentral, dotUNations, dotPGil, dotQuirino, dotVCruz, dotGilPuyat, dotLibertad, dotEdsa, dotBaclaran;
    private Button btnRoosevelt, btnBalintawak, btnMonumento, btnFifthAve, btnRpapa, btnAbadSantos, btnBlumentritt, btnTayuman, btnBambang, btnDJose, btnCarriedo, btnCentral, btnUNations, btnPGil, btnQuirino, btnVCruz, btnGilPuyat, btnLibertad, btnEdsa, btnBaclaran;

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
        // Circular color
        dotRoosevelt = findViewById(R.id.roosevelt_dot);
        dotBalintawak = findViewById(R.id.balintawak_dot);
        dotMonumento = findViewById(R.id.monumento_dot);
        dotFifthAve = findViewById(R.id.fiftAve_dot);
        dotRpapa = findViewById(R.id.rPapa_dot);
        dotAbadSantos = findViewById(R.id.abadSantos_dot);
        dotBlumentritt = findViewById(R.id.blumentritt_dot);
        dotTayuman = findViewById(R.id.tayuman_dot);
        dotBambang = findViewById(R.id.bambang_dot);
        dotDJose = findViewById(R.id.doroteoJose_dot);
        dotCarriedo = findViewById(R.id.carriedo_dot);
        dotCentral = findViewById(R.id.central_dot);
        dotUNations = findViewById(R.id.unitedNations_dot);
        dotPGil = findViewById(R.id.pedroGil_dot);
        dotQuirino = findViewById(R.id.quirino_dot);
        dotVCruz = findViewById(R.id.vitoCruz_dot);
        dotGilPuyat = findViewById(R.id.gilPuyat_dot);
        dotLibertad = findViewById(R.id.libertad_dot);
        dotEdsa = findViewById(R.id.edsa_dot);
        dotBaclaran = findViewById(R.id.baclaran_dot);

        // Station buttons
        btnRoosevelt = findViewById(R.id.roosevelt);
        btnBalintawak = findViewById(R.id.balintawak);
        btnMonumento = findViewById(R.id.monumento);
        btnFifthAve = findViewById(R.id.fifthAve);
        btnRpapa = findViewById(R.id.rPapa);
        btnAbadSantos = findViewById(R.id.abadSantos);
        btnBlumentritt = findViewById(R.id.blumentritt);
        btnTayuman = findViewById(R.id.tayuman);
        btnBambang = findViewById(R.id.bambang);
        btnDJose = findViewById(R.id.doroteoJose);
        btnCarriedo = findViewById(R.id.carriedo);
        btnCentral = findViewById(R.id.central);
        btnUNations = findViewById(R.id.unitedNations);
        btnPGil = findViewById(R.id.pedroGil);
        btnQuirino = findViewById(R.id.quirino);
        btnVCruz = findViewById(R.id.vitoCruz);
        btnGilPuyat = findViewById(R.id.gilPuyat);
        btnLibertad = findViewById(R.id.libertad);
        btnEdsa = findViewById(R.id.edsa);
        btnBaclaran = findViewById(R.id.baclaran);

        btnRoosevelt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor(dotRoosevelt);
            }
        });

        btnBalintawak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor(dotBalintawak);
            }
        });

        btnMonumento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeColor(dotMonumento);
            }
        });


    }

    private void changeColor(LinearLayout layout) {
        if (lastClickedLayout != null) {
            lastClickedLayout.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFF3CE")));
        }
        layout.setBackgroundTintList(ColorStateList.valueOf(Color.BLACK));
        lastClickedLayout = layout;
    }


}