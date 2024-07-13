package com.example.quotes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quotes.roomDB.AppDB;
import com.example.quotes.roomDB.Quote;
import com.example.quotes.roomDB.QuotesDao;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private AppDB db;
    private QuotesDao quotesDao;

    public class ViewHolder extends RecyclerView.ViewHolder {
        //ViewHolder class is taking the views from quote layout

        TextView quotes, category;
        CardView cardView;
        ImageView likeBtn, shareBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            quotes = itemView.findViewById(R.id.quotes);
            category = itemView.findViewById(R.id.category);
            cardView = itemView.findViewById(R.id.cardView);
            likeBtn = itemView.findViewById(R.id.likeBtn);
            shareBtn=itemView.findViewById(R.id.shareBtn);
        }
    }

    Context context;
    List<Quote> modelClassArrayList=new ArrayList<>();

    public RecyclerAdapter(Context context, List<Quote> modelClassArrayList) {
        this.context = context;
        this.modelClassArrayList = modelClassArrayList;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Layout inflator converts the xml into actual views
        View view = LayoutInflater.from(context).inflate(R.layout.quote_layout, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int pos) {
        db=AppDB.getInstance(context);
        quotesDao=db.quotesdao();
        holder.quotes.setText(modelClassArrayList.get(pos).getQuote());
        holder.category.setText(modelClassArrayList.get(pos).getCategory());

        if(modelClassArrayList.get(pos).isLiked()==true){
            holder.likeBtn.setImageResource(R.drawable.liked);
        }
        else{
            holder.likeBtn.setImageResource(R.drawable.unlike);
        }


        holder.likeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (modelClassArrayList.get(pos).isLiked()) {
                    modelClassArrayList.get(pos).setLiked(false);
                    quotesDao.insert(modelClassArrayList.get(pos));

                    holder.likeBtn.setImageResource(R.drawable.unlike);
                } else {
                    modelClassArrayList.get(pos).setLiked(true);
                    quotesDao.insert(modelClassArrayList.get(pos));

                    holder.likeBtn.setImageResource(R.drawable.liked);
                }
            }
        });

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context, QuotePage.class);
                // Passing data to the new activity
                intent.putExtra("quote", modelClassArrayList.get(pos));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return modelClassArrayList.size();
    }
}