package com.example.quotes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.ExecutorService;

import com.example.quotes.roomDB.AppDB;
import com.example.quotes.roomDB.Quote;
import com.example.quotes.roomDB.QuotesDao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    private AppDB db;
    private QuotesDao quotesDao;
    public static RecyclerAdapter adapter;
    public static List<Quote>quotesList;

    private ExecutorService executorService; //chat-gpt
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView addBtn= findViewById(R.id.addBtn);
        TextView randomBtn=findViewById(R.id.randomBtn);

        //Setting adapter to recycler view
        EditText searchQuerry=findViewById(R.id.searchQuerry);
        ImageView searchBtn=findViewById(R.id.searchBtn);
        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));   //1.
        quotesList= new ArrayList<>();  //2.
        db=AppDB.getInstance(this);


//        Quote model1=new Quote("Happiness is not something readymade; it comes from your own actions.", "Motivational");
//        Quote model2= new Quote("Education is the most powerful weapon which you can use to change the world.", "Educational");
//        Quote model3= new Quote("We cannot solve problems with the kind of thinking we employed when we came up with them", "Inspiring");
//        Quote model4=new Quote("Happiness is not something readymade; it comes from your own actions.", "Motivational");
//        Quote model5= new Quote("Education is the most powerful weapon which you can use to change the world.", "Educational");
//        Quote model6= new Quote("We cannot solve problems with the kind of thinking we employed when we came up with them", "Inspiring");

        quotesDao=db.quotesdao();
        quotesList=quotesDao.getRandom();


        adapter= new RecyclerAdapter(this, quotesList);     //3.
        recyclerView.setAdapter(adapter);   //4.

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, AddQuote.class);
                startActivity(intent);
                adapter.notifyDataSetChanged();
//                finish();
            }
        });

        executorService = Executors.newSingleThreadExecutor();

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String search=searchQuerry.getText().toString();

                if(!search.isEmpty()){
                    List<Quote> tempList=new ArrayList<>();
                    tempList.addAll(quotesList);
                    executorService.execute(() -> {
                        quotesList.clear();
                        quotesList.addAll(quotesDao.searchQuote("%"+search+"%"));
                        runOnUiThread(() -> {
                            adapter.notifyDataSetChanged();
                        });
                    });

                }
            }
        });

        randomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quotesList.clear();
                quotesList.addAll(quotesDao.getRandom());
                adapter.notifyDataSetChanged();
            }
        });

    }

}