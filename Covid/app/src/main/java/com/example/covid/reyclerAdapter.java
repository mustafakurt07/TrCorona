package com.example.covid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class reyclerAdapter extends RecyclerView.Adapter< reyclerAdapter.RowHolder> {
    private ArrayList<CovidModel> covidList;
    private String[] colors = {"#a3ff00","#ff00aa","#b4a7d6","#a4c2f4","#8ee5ee","#cd950c","#f5f5f5","#f47932"};


    public reyclerAdapter(ArrayList<CovidModel> covidList) {
        this.covidList = covidList;
    }

    @NonNull
    @Override
    public RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_tasarim,parent,false);

        return new RowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RowHolder holder, int position) {
        holder.bind(covidList.get(position),position);
    }

    @Override
    public int getItemCount() {
        return covidList.size();
    }

    public class RowHolder extends RecyclerView.ViewHolder {
        private TextView textViewCase;
        private  TextView textViewTotalCase;
        private  TextView textViewDeaths;
        private  TextView textViewTest;
        private  TextView textViewTotalTest;
        private  TextView textViewDate;
        private CardView cardView;

        public RowHolder(@NonNull View itemView) {
            super(itemView);

        }
        public void bind(CovidModel genels,Integer position)
        {//itemView.setBackgroundColor(Color.parseColor(colors[position %8]));
            textViewCase=itemView.findViewById(R.id.textViewCase);
            textViewTotalCase=itemView.findViewById(R.id.textViewTotalCase);
            textViewDeaths=itemView.findViewById(R.id.deaths);
            textViewTest=itemView.findViewById(R.id.textViewTest);
            textViewTotalTest=itemView.findViewById(R.id.textViewTotalTest);
            textViewDate=itemView.findViewById(R.id.textViewDate);
            cardView=itemView.findViewById(R.id.kitap_card);
            textViewCase.setText(genels.Country);
            textViewTotalCase.setText("T.Vaka :"+genels.Case);
            textViewDeaths.setText("T.Olum :"+genels.deaths);
            textViewTest.setText("T.İyilesen :"+genels.test);
            textViewTotalTest.setText("Active:"+genels.totalTests);
            textViewDate.setText("Date :"+genels.date);




        }
    }
}
