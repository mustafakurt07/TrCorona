package com.example.covid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.SyncRequest;
import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ArrayList<CovidModel> covidModels;
    RecyclerView recyclerView;
    Retrofit retrofit;
    reyclerAdapter recyclerViewAdapter;
    private String BASE_URL="https://api.covid19api.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        //retrofit and gson
        Gson gson=new GsonBuilder().setLenient().create();
        retrofit=new  Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        loadData();
    }
    private  void loadData()
    {
        covidService covidService=retrofit.create(covidService.class);//servisi olusturdum.
        Call<List<CovidModel>> call=covidService.getData();//veriyi alma islemi
        call.enqueue(new Callback<List<CovidModel>>() {
            @Override
            public void onResponse(Call<List<CovidModel>> call, Response<List<CovidModel>> response) {
                if(response.isSuccessful())
                {
                    List<CovidModel>responseList=response.body();
                    covidModels=new ArrayList<>(responseList);
                    recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
                    recyclerViewAdapter= new reyclerAdapter(covidModels);
                    recyclerView.setAdapter(recyclerViewAdapter);
                }

            }

            @Override
            public void onFailure(Call<List<CovidModel>> call, Throwable t) {
                t.printStackTrace();

            }
        });

    }
}
