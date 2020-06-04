package com.example.covid;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface covidService {
    @GET("live/country/turkey")
    Call<List<CovidModel>> getData();

}
