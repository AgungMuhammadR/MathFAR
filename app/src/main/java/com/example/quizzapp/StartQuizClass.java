package com.example.quizzapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class StartQuizClass extends AppCompatActivity {

    private ModelKuis modelKuis;
    private ArrayList <String> pertanyaan = new ArrayList<String>();
    private ArrayList <String> jawaban = new ArrayList<String>();
    private int nomorSoal = 0;
    private int nilaiAkhir = 0;
    private String level, pilihKelas;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        Intent getFromKelas = getIntent();

        TextView textView = (TextView) findViewById(R.id.question_example);
        Button btnNext = (Button) findViewById(R.id.next_soal);

        CardView [] crdOption = {(CardView) findViewById(R.id.chooseA), (CardView) findViewById(R.id.chooseB), (CardView) findViewById(R.id.chooseC), (CardView) findViewById(R.id.chooseD)};
        TextView [] txtOption = {(TextView) findViewById(R.id.textA), (TextView) findViewById(R.id.textB), (TextView) findViewById(R.id.textC), (TextView) findViewById(R.id.textD)};

        Intent getDataIntent = getIntent();
        this.nomorSoal = getDataIntent.getIntExtra("NOMOR_SOAL",this.nomorSoal);
        this.nilaiAkhir = getDataIntent.getIntExtra("SKOR", this.nilaiAkhir);
        this.level = getDataIntent.getStringExtra("LEVEL");
        this.pilihKelas = getDataIntent.getStringExtra("SOALKELAS");


        if (this.nomorSoal > 3) {
            Intent end = new Intent(getApplicationContext(), EndQuizClass.class);
            end.putExtra("SKORAKHIR",String.valueOf(nilaiAkhir));
            startActivity(end);
        }

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection(this.pilihKelas)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        for (QueryDocumentSnapshot document : task.getResult()) {
                            pertanyaan.add(document.getString("question"));
                            jawaban.add(document.getString("answer"));
                        }

                        modelKuis = new ModelKuis(pertanyaan, jawaban);
                        textView.setText(modelKuis.pertanyaan.get(nomorSoal));
                        modelKuis.setCurrJawaban(Integer.parseInt(modelKuis.jawaban.get(nomorSoal)));

                        List<Integer> arrindex = new ArrayList<Integer>();
                        int temp = Integer.parseInt(modelKuis.jawaban.get(nomorSoal));
                        for (int i=0; i<4; i++) {
                            arrindex.add(temp+i);
                        }
                        Collections.shuffle(arrindex);

                        txtOption[0].setText(arrindex.get(0).toString());
                        txtOption[1].setText(arrindex.get(1).toString());
                        txtOption[2].setText(arrindex.get(2).toString());
                        txtOption[3].setText(arrindex.get(3).toString());

                        crdOption[0].setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                TextView userJwb = txtOption[0];
                                int jawab = Integer.parseInt(userJwb.getText().toString());
                                boolean check = modelKuis.checkJawaban(jawab);

                                Intent intent = new Intent(getApplicationContext(), StartQuizClass.class);
                                intent.putExtra("NOMOR_SOAL", nomorSoal + 1);
                                if (check) {
                                    intent.putExtra("SKOR", nilaiAkhir+20);
                                }
                                else {
                                    intent.putExtra("SKOR", nilaiAkhir);
                                }
                                intent.putExtra("LEVEL", level);
                                intent.putExtra("SOALKELAS", pilihKelas);

                                startActivity(intent);
                            }
                        });

                        crdOption[1].setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                TextView userJwb = txtOption[1];
                                int jawab = Integer.parseInt(userJwb.getText().toString());
                                boolean check = modelKuis.checkJawaban(jawab);

                                Intent intent = new Intent(getApplicationContext(), StartQuizClass.class);
                                intent.putExtra("NOMOR_SOAL", nomorSoal + 1);
                                if (check) {
                                    intent.putExtra("SKOR", nilaiAkhir+20);
                                }
                                else {
                                    intent.putExtra("SKOR", nilaiAkhir);
                                }

                                intent.putExtra("LEVEL", level);
                                intent.putExtra("SOALKELAS", pilihKelas);
                                startActivity(intent);
                            }
                        });

                        crdOption[2].setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                TextView userJwb = txtOption[2];
                                int jawab = Integer.parseInt(userJwb.getText().toString());
                                boolean check = modelKuis.checkJawaban(jawab);

                                Intent intent = new Intent(getApplicationContext(), StartQuizClass.class);
                                intent.putExtra("NOMOR_SOAL", nomorSoal + 1);
                                if (check) {
                                    intent.putExtra("SKOR", nilaiAkhir+20);
                                }
                                else {
                                    intent.putExtra("SKOR", nilaiAkhir);
                                }

                                intent.putExtra("LEVEL", level);
                                intent.putExtra("SOALKELAS", pilihKelas);
                                startActivity(intent);
                            }
                        });

                        crdOption[3].setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                TextView userJwb = txtOption[3];
                                int jawab = Integer.parseInt(userJwb.getText().toString());
                                boolean check = modelKuis.checkJawaban(jawab);

                                Intent intent = new Intent(getApplicationContext(), StartQuizClass.class);
                                intent.putExtra("NOMOR_SOAL", nomorSoal + 1);
                                if (check) {
                                    intent.putExtra("SKOR", nilaiAkhir+20);
                                }
                                else {
                                    intent.putExtra("SKOR", nilaiAkhir);
                                }

                                intent.putExtra("LEVEL", level);
                                intent.putExtra("SOALKELAS", pilihKelas);
                                startActivity(intent);
                            }
                        });

                        btnNext.setText("Nilai : " + String.valueOf(nilaiAkhir));
                    }
                });


    }


}
