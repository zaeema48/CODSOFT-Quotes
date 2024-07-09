package com.example.quotes;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class QuotePage extends AppCompatActivity {
    CardView cardView;
    TextView quote, category;
    ImageView likeBtn, shareBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quote_page);

        cardView=findViewById(R.id.quoteCard);
        quote=findViewById(R.id.quote);
        category=findViewById(R.id.Qcategory);
        likeBtn=findViewById(R.id.likeBtn);
        shareBtn=findViewById(R.id.shareBtn);

        Intent intent = getIntent();
        String quoteDisplay = intent.getStringExtra("quote");
        String categoryDisplay = intent.getStringExtra("category");
        boolean isFav = intent.getBooleanExtra("isFav", false);

        quote.setText(quoteDisplay);
        category.setText(categoryDisplay);

        if (isFav) {
            likeBtn.setImageResource(R.drawable.liked);
        } else {
            likeBtn.setImageResource(R.drawable.unlike);
        }

    }
}