package com.example.quizzapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class QuizClass extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_level);

        Intent intent = getIntent();
        String kelas = intent.getStringExtra("KELAS");

        TextView textLevel = (TextView) findViewById(R.id.pilih_level);
        textLevel.setText("Pilih Tingkat Kesulitan " + kelas);

        CardView easy = (CardView) findViewById(R.id.easy);
        CardView medium = (CardView) findViewById(R.id.medium);
        CardView hard = (CardView) findViewById(R.id.hard);

        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }


}