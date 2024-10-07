package com.example.seat_mobileapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class train_sched extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_train_sched);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setUpNavBar(train_sched.class);
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
                        stationView.setImageResource(R.drawable.abad_santos_deets);
                        break;
                    case "Blumentritt":
                        stationView.setImageResource(R.drawable.blumentritt_deets);
                        break;
                    case "Tayuman":
                        stationView.setImageResource(R.drawable.tayuman_deets);
                        break;
                    case "Bambang":
                        stationView.setImageResource(R.drawable.bambang_deets);
                        break;
                    case "Doroteo Jose":
                        stationView.setImageResource(R.drawable.djose_deets );
                        break;
                    case "Carriedo":
                        stationView.setImageResource(R.drawable.carriedo_deets);
                        break;
                    case "Central Terminal":
                        stationView.setImageResource(R.drawable.central_deets );
                        break;
                    case "United Nations":
                        stationView.setImageResource(R.drawable.united_nations_deets );
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        String[] stationList = {"Select Station","Abad Santos", "Blumentritt", "Tayuman", "Bambang", "Doroteo Jose", "Carriedo", "Central Terminal", "United Nations"};

        ArrayAdapter<String> stationAdapter = new ArrayAdapter<>(this, R.layout.custom_spinner, stationList);
        stationAdapter.setDropDownViewResource(R.layout.custom_spinner);
        stationMenu.setAdapter(stationAdapter);
    }


}