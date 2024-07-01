package com.example.quotes;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.airbnb.lottie.LottieAnimationView;

public class Animation extends AppCompatActivity {
    LottieAnimationView lottie;
    TextView gobtn;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_animation);

        lottie=findViewById(R.id.lottieView);
        gobtn=findViewById(R.id.goBtn);
        textView=findViewById(R.id.quotes);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                lottie.setAnimation(R.raw.quotelottie);
                lottie .playAnimation();
            }
        }, 3000);

        gobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Animation.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}