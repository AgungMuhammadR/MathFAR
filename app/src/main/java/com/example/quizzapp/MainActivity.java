package com.example.quizzapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

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

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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