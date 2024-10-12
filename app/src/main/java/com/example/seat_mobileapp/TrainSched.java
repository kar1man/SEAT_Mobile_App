package com.example.seat_mobileapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TrainSched extends class_NavButtons {

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
        stationPicker();
    }

    private void stationPicker() {
        ImageView stationView = findViewById(R.id.train_deets);
        Spinner stationMenu = findViewById(R.id.station_dropdown);

        stationMenu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String station = adapterView.getItemAtPosition(position).toString();

                switch (station) {
                    case "Select Station":
                        Toast.makeText(getApplicationContext(),"Please select station you want to check!", Toast.LENGTH_SHORT).show();
                        break;
                    case "Abad Santos":
                        stationView.setImageResource(R.drawable.station_abad_santos);
                        break;
                    case "Blumentritt":
                        stationView.setImageResource(R.drawable.station_blumentritt);
                        break;
                    case "Tayuman":
                        stationView.setImageResource(R.drawable.station_tayuman);
                        break;
                    case "Bambang":
                        stationView.setImageResource(R.drawable.station_bambang);
                        break;
                    case "Doroteo Jose":
                        stationView.setImageResource(R.drawable.station_doroteo_jose);
                        break;
                    case "Carriedo":
                        stationView.setImageResource(R.drawable.station_carriedo);
                        break;
                    case "Central Terminal":
                        stationView.setImageResource(R.drawable.station_central_terminal);
                        break;
                    case "United Nations":
                        stationView.setImageResource(R.drawable.station_united_nations);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        String[] stationList = {"Select Station","Abad Santos", "Blumentritt", "Tayuman", "Bambang", "Doroteo Jose", "Carriedo", "Central Terminal", "United Nations"};

        ArrayAdapter<String> stationAdapter = new ArrayAdapter<>(this, R.layout.custom_station_dropdown, stationList);
        stationAdapter.setDropDownViewResource(R.layout.custom_station_dropdown);
        stationMenu.setAdapter(stationAdapter);
    }


}