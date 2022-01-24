package com.example.quizzapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.Locale;

public class QuizClass extends AppCompatActivity {

    private String kelasTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_level);

        Intent intent = getIntent();
        String kelas = intent.getStringExtra("KELAS");

        kelasTemp = kelas.replaceAll("\\s","");
        kelasTemp = kelasTemp.toLowerCase(Locale.ROOT);

        TextView textLevel = (TextView) findViewById(R.id.pilih_level);
        textLevel.setText("Pilih Tingkat Kesulitan " + kelas);

        CardView easy = (CardView) findViewById(R.id.easy);
        CardView medium = (CardView) findViewById(R.id.medium);
        CardView hard = (CardView) findViewById(R.id.hard);

        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                KuisDataClass kdc = new KuisDataClass(kelasTemp, "easy");

                Intent intent = new Intent(getApplicationContext(), StartQuizClass.class);
                intent.putExtra("LEVEL", "easy");
                intent.putExtra("SOALKELAS", kelasTemp);
                startActivity(intent);
            }
        });

        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                KuisDataClass kdc = new KuisDataClass(kelasTemp, "medium");

                Intent intent = new Intent(getApplicationContext(), StartQuizClass.class);
                intent.putExtra("LEVEL", "medium");
                intent.putExtra("SOALKELAS", kelasTemp);
                startActivity(intent);
            }
        });

        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                KuisDataClass kdc = new KuisDataClass(kelasTemp, "hard");

                Intent intent = new Intent(getApplicationContext(), StartQuizClass.class);
                intent.putExtra("LEVEL", "hard");
                intent.putExtra("SOALKELAS", kelasTemp);
                startActivity(intent);
            }
        });

    }


}