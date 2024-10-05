package com.example.seat_mobileapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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
        setUpNavBar();
        stationPicker();
    }

    private void stationPicker() {
        Spinner stationMenu = findViewById(R.id.station_dropdown);
        stationMenu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String station = adapterView.getItemAtPosition(position).toString();
                Toast.makeText(train_sched.this, "Selected Station: " + station, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        String[] stationList = {"Abad Santos", "Bluementritt", "Tayuman", "Bambang", "Doroteo Jose", "Carriedo", "Central Terminal", "United Nations"};

        ArrayAdapter<String> stationAdapter = new ArrayAdapter<>(this, R.layout.custom_spinner, stationList);
        stationAdapter.setDropDownViewResource(R.layout.custom_spinner);
        stationMenu.setAdapter(stationAdapter);
    }


}