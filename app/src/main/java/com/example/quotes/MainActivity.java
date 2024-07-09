 package com.example.quotes;

import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quotes.roomDB.AppDB;

import java.util.ArrayList;

 public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        private AppDB db;

        @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.Layout.quote_layout);
        }

        //Setting adapter to recycler view
        EditText editText=findViewById(R.id.search_bar);
        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        ArrayList<Model>quotesList= new ArrayList<>();  //2.
        Model model1=new Model("Happiness is not something readymade; it comes from your own actions.", "Motivational");
        Model model2= new Model("Education is the most powerful weapon which you can use to change the world.", "Educational");
        Model model3= new Model("We cannot solve problems with the kind of thinking we employed when we came up with them", "Inspiring");
        Model model4=new Model("Happiness is not something readymade; it comes from your own actions.", "Motivational");
        Model model5= new Model("Education is the most powerful weapon which you can use to change the world.", "Educational");
        Model model6= new Model("We cannot solve problems with the kind of thinking we employed when we came up with them", "Inspiring");

        quotesList.add(model1);
        quotesList.add(model2);
        quotesList.add(model3);
        quotesList.add(model4);
        quotesList.add(model5);
        quotesList.add(model6);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));   //1.

        RecyclerAdapter adapter= new RecyclerAdapter(this, quotesList);     //3.
        recyclerView.setAdapter(adapter);   //4.

    }
}