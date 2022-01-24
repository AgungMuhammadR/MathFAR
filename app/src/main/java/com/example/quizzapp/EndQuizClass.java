package com.example.quizzapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class EndQuizClass extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_kuis);

        TextView txtScore = (TextView) findViewById(R.id.skorAkhir);
        Intent intent = getIntent();

        String finalScore = intent.getStringExtra("SKORAKHIR");
        txtScore.setText(finalScore);

        int newScore = Integer.parseInt(UserDataClass.skor) + Integer.parseInt(finalScore);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Map<String, Object> userMap = new HashMap<>();

        userMap.put("skor", String.valueOf(newScore));
        UserDataClass.skor = String.valueOf(newScore);
        db.collection("users").document(UserDataClass.id).update(userMap);


        Button btnBack = (Button) findViewById(R.id.returnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomeClass.class);
                startActivity(intent);
            }
        });


    }

}
