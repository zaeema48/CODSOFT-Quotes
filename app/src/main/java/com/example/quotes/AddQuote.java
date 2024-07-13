package com.example.quotes;

//import static com.example.quotes.MainActivity.db;

import static com.example.quotes.MainActivity.adapter;
import static com.example.quotes.MainActivity.quotesList;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.quotes.roomDB.AppDB;
import com.example.quotes.roomDB.Quote;
import com.example.quotes.roomDB.QuotesDao;

public class AddQuote extends AppCompatActivity {
    private AppDB db;
    private QuotesDao quotesDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_quote);

        EditText quoteText=findViewById(R.id.quoteText1);
        EditText categoryText=findViewById(R.id.categoryText1);
        TextView submit=findViewById(R.id.submit);
        db=AppDB.getInstance(this);
        quotesDao=db.quotesdao();
//        QuotesDao quotesDao=db.quotesdao();


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String quote=quoteText.getText().toString();
                String category=categoryText.getText().toString();

//                Toast.makeText(AddQuote.this,quote+ " "+category, Toast.LENGTH_SHORT).show();
                if(!quote.isEmpty() && !category.isEmpty()){
                    Quote newQuote=new Quote(quote,category);
                    newQuote.setLiked(false);
                    quotesDao.insert(newQuote);
                    quotesList.clear();
                    quotesList.addAll(quotesDao.getRandom());
                    adapter.notifyDataSetChanged();
                    finish();
                }
                else{
                    Toast.makeText(AddQuote.this, "Error!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}