package com.example.quotes;

import static com.example.quotes.MainActivity.adapter;
import static com.example.quotes.MainActivity.quotesList;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.quotes.roomDB.AppDB;
import com.example.quotes.roomDB.Quote;
import com.example.quotes.roomDB.QuotesDao;

public class QuotePage extends AppCompatActivity {
    CardView cardView;
    TextView quoteText, category;
    ImageView likeBtn, shareBtn;
    private AppDB db;
    private QuotesDao quotesDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quote_page);

        cardView=findViewById(R.id.quoteCard);
        quoteText=findViewById(R.id.quote);
        category=findViewById(R.id.Qcategory);
        likeBtn=findViewById(R.id.likeBtn);
        shareBtn=findViewById(R.id.shareBtn);

        db=AppDB.getInstance(this);
        quotesDao=db.quotesdao();

        Intent intent = getIntent();
        Quote quote=(Quote) intent.getSerializableExtra("quote");

        quoteText.setText(quote.getQuote());
        category.setText(quote.getCategory());

        if (quote.isLiked()) {
            likeBtn.setImageResource(R.drawable.liked);
        } else {
            likeBtn.setImageResource(R.drawable.unlike);
        }


        likeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quote.isLiked()) {
                    quote.setLiked(false);
                    quotesDao.insert(quote);

                    likeBtn.setImageResource(R.drawable.unlike);
                } else {
                    quote.setLiked(true);
                    quotesDao.insert(quote);

                    likeBtn.setImageResource(R.drawable.liked);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        quotesList.clear();
        quotesList.addAll(quotesDao.getRandom());
        adapter.notifyDataSetChanged();
        super.onBackPressed();
    }
}