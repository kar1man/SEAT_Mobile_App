package com.example.seat_mobileapp;

public class Train {
    private String trainNumber,arrivalTime, departureTime, congestionLevel;

    public Train(String trainNumber, String arrivalTime, String departureTime, String congestionLevel) {
        this.trainNumber = trainNumber;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.congestionLevel = congestionLevel;
    }

    // Get
    public String getTrainNumber() {
        return trainNumber;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getCongestionLevel() {
        return congestionLevel;
    }

    // Set
    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public void setCongestionLevel(String congestionLevel) {
        this.congestionLevel = congestionLevel;
    }

}
