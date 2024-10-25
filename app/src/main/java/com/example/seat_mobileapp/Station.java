package com.example.seat_mobileapp;

import java.util.ArrayList;

public class Station {
    private String stationName;
    private ArrayList<Train> trains;

    public Station(String stationName) {
        this.stationName = stationName;
        this.trains = new ArrayList<>();
    }

    public void addTrain(Train train) {
        if (trains.size() < 6) {
            trains.add(train);
        } else {
            System.out.println("Sobra na ya!");
        }
    }

    public ArrayList<Train> getTrains() {
        return trains;
    }

    public String getStationName() {
        return stationName;
    }

}
