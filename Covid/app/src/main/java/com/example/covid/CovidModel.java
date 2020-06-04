package com.example.covid;

import android.hardware.SensorEventListener;

import com.google.gson.annotations.SerializedName;

public class CovidModel {
    @SerializedName("Country")
    String Country;
    @SerializedName("Confirmed")
    String Case;
    @SerializedName("Deaths")
    String deaths;
    @SerializedName("Recovered")
    String test;
    @SerializedName("Active")
    String totalTests;
    @SerializedName("Date")
    String date;




}
