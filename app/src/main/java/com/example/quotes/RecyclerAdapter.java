package com.example.quotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        //ViewHolder class is taking the views from quote layout

        TextView quotes, category;
        CardView cardView;
        ImageView likeBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            quotes = itemView.findViewById(R.id.quotes);
            category = itemView.findViewById(R.id.category);
            cardView = itemView.findViewById(R.id.cardView);
            likeBtn = itemView.findViewById(R.id.likeBtn);
        }
    }
    Context context;
    ArrayList<Model>modelClassArrayList;
    public RecyclerAdapter(Context context, ArrayList<Model> modelClassArrayList) {
        this.context = context;
        this.modelClassArrayList = modelClassArrayList;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Layout inflator converts the xml into actual views
        View view= LayoutInflater.from(context).inflate(R.layout.quote_layout, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
