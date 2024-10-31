package com.example.seat_mobileapp;

import static com.example.seat_mobileapp.R.drawable.shape_round_stroke_43black;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class HomeDashboard extends class_NavButtons {
    private LinearLayout lastClickedLayout = null;
    private ToggleButton trainDirection;

    private LinearLayout dotRoosevelt, dotBalintawak, dotMonumento, dotFifthAve, dotRpapa, dotAbadSantos, dotBlumentritt, dotTayuman, dotBambang, dotDJose, dotCarriedo, dotCentral, dotUNations, dotPGil, dotQuirino, dotVCruz, dotGilPuyat, dotLibertad, dotEdsa, dotBaclaran;
    private Button btnRoosevelt, btnBalintawak, btnMonumento, btnFifthAve, btnRpapa, btnAbadSantos, btnBlumentritt, btnTayuman, btnBambang, btnDJose, btnCarriedo, btnCentral, btnUNations, btnPGil, btnQuirino, btnVCruz, btnGilPuyat, btnLibertad, btnEdsa, btnBaclaran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.page_home_dashboard);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setUpNavBar(HomeDashboard.class);
        stationClickEventHandler();
        topupOrLoanHandler();

        balanceUpdate();

    }

    private void balanceUpdate() {
        Intent backToDashboard = getIntent();

        String addedBalanceString = backToDashboard.getStringExtra("addedBalance");
//        String addedBalanceString = backToDashboard != null ? backToDashboard.getStringExtra("addedBalance") : null;

        if (addedBalanceString != null) {
            TextView currentBalanceView = findViewById(R.id.balanceDisplay);

            Float currentBal = Float.parseFloat(currentBalanceView.getText().toString().replace("₱", "").trim());
            Float addBalance = Float.parseFloat(addedBalanceString.replace(" SEAT Credits", "").trim());
            Float newBalance = currentBal + addBalance;

            getSharedPreferences("appData", MODE_PRIVATE).edit()
                    .putFloat("currentBalance", newBalance)
                    .apply();

            currentBalanceView.setText("₱" + String.format("%.2f", newBalance));
        }

    }

    private void topupOrLoanHandler() {
        Button topupBtn = findViewById(R.id.topupButton);
        Button loanBtn = findViewById(R.id.loanButton);

        topupBtn.setOnClickListener(v -> {
            Intent topupIntent = new Intent(this, TopUp.class);
            startActivity(topupIntent);
        });

        loanBtn.setOnClickListener(v -> {
            Intent loanIntent = new Intent(this, Loan.class);
            startActivity(loanIntent);
        });

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

        trainDirection = findViewById(R.id.toggleDirection);

        trainDirection.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Change the tint color for the checked state
                    trainDirection.setBackgroundResource(shape_round_stroke_43black);
                    trainDirection.setTextColor(ColorStateList.valueOf(Color.parseColor("#FFF3CE")));
                } else {
                    // Change the tint color for the unchecked state
                    trainDirection.setBackgroundResource(R.drawable.shape_round_stroke_43dp);
                    trainDirection.setTextColor(ColorStateList.valueOf(Color.parseColor("#393013")));
                }
            }
        });


        btnRoosevelt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor(dotRoosevelt);

                Station rooseveltStation = new Station("Roosevelt");

                if (trainDirection.isChecked()) { // Northbound data
                    rooseveltStation.addTrain(new Train("Train N131", "12:00", "12:05", "X"));
                    rooseveltStation.addTrain(new Train("Train N322", "12:07", "12:10", "X"));
                    rooseveltStation.addTrain(new Train("Train N233", "12:12", "12:15", "X"));

                } else { // Southbound data
                    rooseveltStation.addTrain(new Train("Train S231", "12:00", "12:05", "X"));
                    rooseveltStation.addTrain(new Train("Train S492", "12:07", "12:10", "X"));
                    rooseveltStation.addTrain(new Train("Train S133", "12:12", "12:15", "X"));

                }

                displayTrainDetails(rooseveltStation);
            }
        });

        btnBalintawak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor(dotBalintawak);

                Station balintawakStation = new Station("Balintawak");

                if (trainDirection.isChecked()) { // Northbound data
                    balintawakStation.addTrain(new Train("Train N231", "12:02", "12:07", "XX"));
                    balintawakStation.addTrain(new Train("Train N422", "12:09", "12:13", "XXX"));
                    balintawakStation.addTrain(new Train("Train N343", "12:15", "12:18", "XX"));

                } else { // Southbound data
                    balintawakStation.addTrain(new Train("Train S331", "12:03", "12:08", "X"));
                    balintawakStation.addTrain(new Train("Train S592", "12:10", "12:14", "XXX"));
                    balintawakStation.addTrain(new Train("Train S143", "12:16", "12:19", "XX"));
                }

                displayTrainDetails(balintawakStation);
            }
        });

        btnMonumento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor(dotMonumento);

                Station monumentoStation = new Station("Monumento");

                if (trainDirection.isChecked()) { // Northbound data
                    monumentoStation.addTrain(new Train("Train N331", "12:05", "12:10", "XXX"));
                    monumentoStation.addTrain(new Train("Train N512", "12:13", "12:17", "X"));
                    monumentoStation.addTrain(new Train("Train N433", "12:19", "12:22", "XX"));

                } else { // Southbound data
                    monumentoStation.addTrain(new Train("Train S431", "12:06", "12:11", "X"));
                    monumentoStation.addTrain(new Train("Train S692", "12:14", "12:18", "XXX"));
                    monumentoStation.addTrain(new Train("Train S253", "12:20", "12:23", "XX"));
                    monumentoStation.addTrain(new Train("Train S364", "12:26", "12:30", "XXX"));
                    monumentoStation.addTrain(new Train("Train S435", "12:39", "12:43", "X"));
                    monumentoStation.addTrain(new Train("Train S526", "12:46", "12:50", "XX"));
                }

                displayTrainDetails(monumentoStation);
            }
        });

        btnFifthAve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor(dotFifthAve);

                Station fifthAveStation = new Station("Fifth Avenue");

                if (trainDirection.isChecked()) { // Northbound data
                    fifthAveStation.addTrain(new Train("Train N431", "12:08", "12:13", "X"));
                    fifthAveStation.addTrain(new Train("Train N612", "12:16", "12:20", "XXX"));
                    fifthAveStation.addTrain(new Train("Train N533", "12:22", "12:25", "XX"));

                } else { // Southbound data
                    fifthAveStation.addTrain(new Train("Train S531", "12:09", "12:14", "XX"));
                    fifthAveStation.addTrain(new Train("Train S792", "12:17", "12:21", "XXX"));
                    fifthAveStation.addTrain(new Train("Train S353", "12:23", "12:26", "X"));
                }

                displayTrainDetails(fifthAveStation);
            }
        });

        btnRpapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor(dotRpapa);

                Station rpapaStation = new Station("R. Papa");

                if (trainDirection.isChecked()) { // Northbound data
                    rpapaStation.addTrain(new Train("Train N151", "12:12", "12:15", "XX"));
                    rpapaStation.addTrain(new Train("Train N263", "12:18", "12:21", "XXX"));
                    rpapaStation.addTrain(new Train("Train N304", "12:24", "12:27", "XX"));

                } else { // Southbound data
                    rpapaStation.addTrain(new Train("Train S251", "12:11", "12:14", "X"));
                    rpapaStation.addTrain(new Train("Train S362", "12:17", "12:20", "XX"));
                    rpapaStation.addTrain(new Train("Train S473", "12:23", "12:26", "X"));

                }

                displayTrainDetails(rpapaStation);
            }
        });

        btnAbadSantos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor(dotAbadSantos);

                Station abadSantosStation = new Station("Abad Santos");

                if (trainDirection.isChecked()) { // Northbound data
                    abadSantosStation.addTrain(new Train("Train N162", "12:17", "12:20", "X"));
                    abadSantosStation.addTrain(new Train("Train N273", "12:23", "12:26", "X"));
                    abadSantosStation.addTrain(new Train("Train N384", "12:29", "12:32", "X"));

                } else { // Southbound data
                    abadSantosStation.addTrain(new Train("Train S262", "12:16", "12:19", "X"));
                    abadSantosStation.addTrain(new Train("Train S373", "12:22", "12:25", "XX"));
                    abadSantosStation.addTrain(new Train("Train S484", "12:28", "12:31", "XXX"));
                }

                displayTrainDetails(abadSantosStation);
            }
        });

        btnBlumentritt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor(dotBlumentritt);

                Station blumentrittStation = new Station("Blumentritt");

                if (trainDirection.isChecked()) { // Northbound data
                    blumentrittStation.addTrain(new Train("Train N334", "12:11", "12:14", "XX"));
                    blumentrittStation.addTrain(new Train("Train N812", "12:16", "12:20", "XXX"));
                    blumentrittStation.addTrain(new Train("Train N173", "12:21", "12:24", "XX"));

                } else { // Southbound data
                    blumentrittStation.addTrain(new Train("Train S273", "12:20", "12:23", "XX"));
                    blumentrittStation.addTrain(new Train("Train S384", "12:26", "12:29", "X"));
                    blumentrittStation.addTrain(new Train("Train S495", "12:32", "12:35", "XXX"));
                }

                displayTrainDetails(blumentrittStation);
            }
        });

        btnTayuman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor(dotTayuman);

                Station tayumanStation = new Station("Tayuman");

                if (trainDirection.isChecked()) { // Northbound data
                    tayumanStation.addTrain(new Train("Train N184", "12:25", "12:28", "X"));
                    tayumanStation.addTrain(new Train("Train N295", "12:31", "12:34", "XX"));
                    tayumanStation.addTrain(new Train("Train N406", "12:37", "12:40", "XXX"));

                } else { // Southbound data
                    tayumanStation.addTrain(new Train("Train S284", "12:24", "12:27", "XXX"));
                    tayumanStation.addTrain(new Train("Train S395", "12:30", "12:33", "XX"));
                    tayumanStation.addTrain(new Train("Train S506", "12:36", "12:39", "X"));
                }

                displayTrainDetails(tayumanStation);
            }
        });

        btnBambang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor(dotBambang);

                Station bambangStation = new Station("Bambang");

                if (trainDirection.isChecked()) { // Northbound data
                    bambangStation.addTrain(new Train("Train N194", "12:29", "12:32", "XX"));
                    bambangStation.addTrain(new Train("Train N305", "12:35", "12:38", "X"));
                    bambangStation.addTrain(new Train("Train N416", "12:41", "12:44", "XXX"));

                } else { // Southbound data
                    bambangStation.addTrain(new Train("Train S294", "12:28", "12:31", "XXX"));
                    bambangStation.addTrain(new Train("Train S405", "12:34", "12:37", "XX"));
                    bambangStation.addTrain(new Train("Train S516", "12:40", "12:43", "XXX"));
                }

                displayTrainDetails(bambangStation);
            }
        });

        btnDJose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor(dotDJose);

                Station djoseStation = new Station("Doroteo Jose");

                if (trainDirection.isChecked()) { // Northbound data
                    djoseStation.addTrain(new Train("Train N204", "12:33", "12:36", "XXX"));
                    djoseStation.addTrain(new Train("Train N315", "12:39", "12:42", "XXX"));
                    djoseStation.addTrain(new Train("Train N426", "12:45", "12:48", "XX"));

                } else { // Southbound data
                    djoseStation.addTrain(new Train("Train S304", "12:32", "12:35", "XXX"));
                    djoseStation.addTrain(new Train("Train S415", "12:38", "12:41", "XXX"));
                    djoseStation.addTrain(new Train("Train S526", "12:44", "12:47", "XXX"));
                }

                displayTrainDetails(djoseStation);
            }
        });

        btnCarriedo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor(dotCarriedo);

                Station carriedoStation = new Station("Carriedo");

                if (trainDirection.isChecked()) { // Northbound data
                    carriedoStation.addTrain(new Train("Train N214", "12:37", "12:40", "XX"));
                    carriedoStation.addTrain(new Train("Train N325", "12:43", "12:46", "XXX"));
                    carriedoStation.addTrain(new Train("Train N436", "12:49", "12:52", "XX"));

                } else { // Southbound data
                    carriedoStation.addTrain(new Train("Train S314", "12:36", "12:39", "XX"));
                    carriedoStation.addTrain(new Train("Train S425", "12:42", "12:45", "XXX"));
                    carriedoStation.addTrain(new Train("Train S536", "12:48", "12:51", "XX"));
                }

                displayTrainDetails(carriedoStation);
            }
        });

        btnCentral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor(dotCentral);

                Station centralStation = new Station("Central");

                if (trainDirection.isChecked()) { // Northbound data
                    centralStation.addTrain(new Train("Train N224", "12:41", "12:44", "XX"));
                    centralStation.addTrain(new Train("Train N335", "12:47", "12:50", "XX"));
                    centralStation.addTrain(new Train("Train N446", "12:53", "12:56", "X"));

                } else { // Southbound data
                    centralStation.addTrain(new Train("Train S324", "12:40", "12:43", "XXX"));
                    centralStation.addTrain(new Train("Train S435", "12:46", "12:49", "XXX"));
                    centralStation.addTrain(new Train("Train S546", "12:52", "12:55", "X"));
                }

                displayTrainDetails(centralStation);
            }
        });

        btnUNations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor(dotUNations);

                Station unationsStation = new Station("United Nations");

                if (trainDirection.isChecked()) { // Northbound data
                    unationsStation.addTrain(new Train("Train N234", "12:45", "12:48", "XX"));
                    unationsStation.addTrain(new Train("Train N345", "12:51", "12:54", "X"));
                    unationsStation.addTrain(new Train("Train N456", "12:57", "13:00", "XXX"));

                } else { // Southbound data
                    unationsStation.addTrain(new Train("Train S334", "12:44", "12:47", "XX"));
                    unationsStation.addTrain(new Train("Train S445", "12:50", "12:53", "X"));
                    unationsStation.addTrain(new Train("Train S556", "12:56", "12:59", "XXX"));
                }

                displayTrainDetails(unationsStation);
            }
        });

        btnPGil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor(dotPGil);

                Station pedroGilStation = new Station("Pedro Gil");

                if (trainDirection.isChecked()) { // Northbound data
                    pedroGilStation.addTrain(new Train("Train N128", "12:00", "12:05", "XXX"));
                    pedroGilStation.addTrain(new Train("Train N337", "12:10", "12:15", "XX"));
                    pedroGilStation.addTrain(new Train("Train N482", "12:20", "12:25", "X"));

                } else { // Southbound data
                    pedroGilStation.addTrain(new Train("Train S309", "12:05", "12:10", "XX"));
                    pedroGilStation.addTrain(new Train("Train S487", "12:15", "12:20", "XXX"));
                    pedroGilStation.addTrain(new Train("Train S556", "12:25", "12:30", "X"));
                }

                displayTrainDetails(pedroGilStation);
            }
        });

        btnQuirino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor(dotQuirino);

                Station quirinoStation = new Station("Quirino");

                if (trainDirection.isChecked()) { // Northbound data
                    quirinoStation.addTrain(new Train("Train N214", "12:05", "12:10", "XX"));
                    quirinoStation.addTrain(new Train("Train N371", "12:15", "12:20", "XXX"));
                    quirinoStation.addTrain(new Train("Train N492", "12:25", "12:30", "X"));

                } else { // Southbound data
                    quirinoStation.addTrain(new Train("Train S218", "12:10", "12:15", "XX"));
                    quirinoStation.addTrain(new Train("Train S390", "12:20", "12:25", "X"));
                    quirinoStation.addTrain(new Train("Train S469", "12:30", "12:35", "XXX"));
                }

                displayTrainDetails(quirinoStation);
            }
        });

        btnVCruz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor(dotVCruz);

                Station vitoCruzStation = new Station("Vito Cruz");

                if (trainDirection.isChecked()) { // Northbound data
                    vitoCruzStation.addTrain(new Train("Train N215", "12:10", "12:15", "XX"));
                    vitoCruzStation.addTrain(new Train("Train N399", "12:20", "12:25", "XXX"));
                    vitoCruzStation.addTrain(new Train("Train N479", "12:30", "12:35", "X"));

                } else { // Southbound data
                    vitoCruzStation.addTrain(new Train("Train S309", "12:15", "12:20", "XX"));
                    vitoCruzStation.addTrain(new Train("Train S452", "12:25", "12:30", "X"));
                    vitoCruzStation.addTrain(new Train("Train S513", "12:35", "12:40", "XXX"));
                }

                displayTrainDetails(vitoCruzStation);
            }
        });

        btnGilPuyat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor(dotGilPuyat);

                Station gilPuyatStation = new Station("Gil Puyat");

                if (trainDirection.isChecked()) { // Northbound data
                    gilPuyatStation.addTrain(new Train("Train N155", "12:15", "12:20", "XX"));
                    gilPuyatStation.addTrain(new Train("Train N237", "12:25", "12:30", "XXX"));
                    gilPuyatStation.addTrain(new Train("Train N348", "12:35", "12:40", "X"));

                } else { // Southbound data
                    gilPuyatStation.addTrain(new Train("Train S119", "12:20", "12:25", "XX"));
                    gilPuyatStation.addTrain(new Train("Train S251", "12:30", "12:35", "X"));
                    gilPuyatStation.addTrain(new Train("Train S358", "12:40", "12:45", "XXX"));
                }

                displayTrainDetails(gilPuyatStation);
            }
        });

        btnLibertad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor(dotLibertad);

                Station libertadStation = new Station("Libertad");

                if (trainDirection.isChecked()) { // Northbound data
                    libertadStation.addTrain(new Train("Train N123", "12:25", "12:30", "XX"));
                    libertadStation.addTrain(new Train("Train N276", "12:35", "12:40", "XXX"));
                    libertadStation.addTrain(new Train("Train N354", "12:45", "12:50", "X"));

                } else { // Southbound data
                    libertadStation.addTrain(new Train("Train S207", "12:30", "12:35", "XX"));
                    libertadStation.addTrain(new Train("Train S359", "12:40", "12:45", "XXX"));
                    libertadStation.addTrain(new Train("Train S460", "12:50", "12:55", "X"));

                }

                displayTrainDetails(libertadStation);
            }
        });

        btnEdsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor(dotEdsa);

                Station edsaStation = new Station("EDSA");

                if (trainDirection.isChecked()) { // Northbound data
                    edsaStation.addTrain(new Train("Train N387", "12:05", "12:10", "XX"));
                    edsaStation.addTrain(new Train("Train N493", "12:15", "12:20", "XXX"));
                    edsaStation.addTrain(new Train("Train N605", "12:25", "12:30", "X"));

                } else { // Southbound data
                    edsaStation.addTrain(new Train("Train S224", "12:10", "12:15", "X"));
                    edsaStation.addTrain(new Train("Train S334", "12:20", "12:25", "XX"));
                    edsaStation.addTrain(new Train("Train S468", "12:30", "12:35", "X"));
                }

                displayTrainDetails(edsaStation);
            }
        });

        btnBaclaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor(dotBaclaran);

                Station baclaranStation = new Station("Baclaran");

                if (trainDirection.isChecked()) { // Northbound data
                    baclaranStation.addTrain(new Train("Train N236", "12:20", "12:25", "X"));
                    baclaranStation.addTrain(new Train("Train N384", "12:30", "12:35", "X"));
                    baclaranStation.addTrain(new Train("Train N429", "12:40", "12:45", "X"));

                } else { // Southbound data
                    baclaranStation.addTrain(new Train("Train S113", "12:25", "12:30", "X"));
                    baclaranStation.addTrain(new Train("Train S275", "12:35", "12:40", "XX"));
                    baclaranStation.addTrain(new Train("Train S348", "12:45", "12:50", "X"));
                }

                displayTrainDetails(baclaranStation);
            }
        });

    }

    private void displayTrainDetails(Station station) {
        ArrayList<Train> trains = station.getTrains();
        for (int i = 0; i < 3; i++) {
            Train train = trains.get(i);

            String trainId = "train_" + (i + 1);
            String arrivalId = "arrival_" + (i + 1);
            String departureId = "departure_" + (i + 1);
            String congestionId = "congestion_" + (i + 1);

            TextView trainTextView = findViewById(getResources().getIdentifier(trainId, "id", getPackageName()));
            TextView arrivalTextView = findViewById(getResources().getIdentifier(arrivalId, "id", getPackageName()));
            TextView departureTextView = findViewById(getResources().getIdentifier(departureId, "id", getPackageName()));
            TextView congestionTextView = findViewById(getResources().getIdentifier(congestionId, "id", getPackageName()));

            trainTextView.setText(train.getTrainNumber());
            arrivalTextView.setText(train.getArrivalTime());
            departureTextView.setText(train.getDepartureTime());
            congestionTextView.setText(train.getCongestionLevel());

            String congestionLevel = train.getCongestionLevel();
            if ("XXX".equals(congestionLevel)) {
                trainTextView.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#D32F2F")));
            } else if ("XX".equals(congestionLevel)) {
                trainTextView.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFB74D")));
            } else if ("X".equals(congestionLevel)) {
                trainTextView.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#AED581")));
            }

        }
    }

    private void changeColor(LinearLayout layout) {
        if (lastClickedLayout != null) {
            lastClickedLayout.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFF3CE")));
        }
        layout.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#393013")));
        lastClickedLayout = layout;
    }


}
