package com.example.quizzapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import java.util.List;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.graphics.drawable.Drawable;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText email, password;
    private String textMail, textPsw;
    private String strUsr, strEmail, strPsw;
    private FirebaseAuth mAuth;
    private boolean statusLogin = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

//        Context context;
//        List<ItemObjectKelas> listItem;
//        RecyclerView recyclerView, recyclerView2;
//        RecyclerView.Adapter recyclerViewAdapter;
//        RecyclerView.LayoutManager recylerViewLayoutManager;
//        String[] subjects = {"Kelas 1", "Kelas 2", "Kelas 3", "Kelas 4", "Kelas 5", "Kelas 6"};
//        Drawable [] drwImg = {getResources().getDrawable(R.drawable.kelas1), getResources().getDrawable(R.drawable.kelas2),
//                getResources().getDrawable(R.drawable.kelas3),getResources().getDrawable(R.drawable.kelas4),
//                getResources().getDrawable(R.drawable.kelas5),getResources().getDrawable(R.drawable.kelas6)};
//
//        listItem = new ArrayList<>();
//        for (int i=0; i<6; i++) {
//            listItem.add(new ItemObjectKelas(subjects[i], drwImg[i]));
//        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

//        context = getApplicationContext();
//
//        recyclerView = findViewById(R.id.recyclerView);
//        recylerViewLayoutManager = new LinearLayoutManager(context);
//        recyclerView.setLayoutManager(recylerViewLayoutManager);
//
//        recyclerViewAdapter = new AdapterRecyclerView(context, listItem);
//        recyclerView.setAdapter(recyclerViewAdapter);

    }

    public void signIn (View v) {

        email = (EditText) findViewById(R.id.etLoginEmail);
        password = (EditText) findViewById(R.id.etLoginPassword);

        textMail = email.getText().toString();
        textPsw = password.getText().toString();

        FirebaseClass frb = new FirebaseClass();
        statusLogin = frb.authLogin(textPsw, textMail);

        if (statusLogin) {
            Intent myIntent = new Intent(getApplicationContext(), HomeClass.class);
            startActivity(myIntent);
        }

        else {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("Email atau Password Anda salah!").setNegativeButton("Tutup", null).create().show();
        }

    }

    public void moveDaftar(View v)  {

        Intent i = new Intent(getApplicationContext(),RegisterClass.class);
        startActivity(i);

    }

}