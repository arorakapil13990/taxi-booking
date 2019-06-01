package com.example.kmart.dto;

public class CancellationRateResponse {

    private String day;
    private String cancellationRate;

    public CancellationRateResponse() {
    }

    public CancellationRateResponse(String day, String cancellationRate) {
        this.day = day;
        this.cancellationRate = cancellationRate;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getCancellationRate() {
        return cancellationRate;
    }

    public void setCancellationRate(String cancellationRate) {
        this.cancellationRate = cancellationRate;
    }

}
