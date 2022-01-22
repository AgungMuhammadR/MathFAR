package com.example.quizzapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterClass extends AppCompatActivity {

    private EditText username, email, password;
    private String txtMail, txtUsr, txtPsw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

    }

    public void moveLogin (View v) {

        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
    }

    public void signUp (View v) {

        username = (EditText) findViewById(R.id.etUsername);
        password = (EditText) findViewById(R.id.etPassword);
        email = (EditText) findViewById(R.id.etEmail);

        txtMail = email.getText().toString();
        txtPsw = password.getText().toString();
        txtUsr = username.getText().toString();

        FirebaseClass frb = new FirebaseClass();
        frb.inputData(txtUsr, txtMail, txtPsw);

        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);

    }
}
