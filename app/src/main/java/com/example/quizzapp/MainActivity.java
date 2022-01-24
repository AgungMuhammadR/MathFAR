package com.example.quizzapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;

import java.lang.reflect.Type;
import java.util.List;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.graphics.drawable.Drawable;
import android.widget.TableLayout;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
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
    TabLayout tabLayout;
    ViewPager viewPager;
    Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }


    public boolean checkLogin (String xd, String y) {

        boolean x;

        if ( (this.textMail.equals(xd)) && (this.textPsw.equals(y)) ) {
            x = true;
        }

        else {
            x = false;
        }
        return x;

    }


    public void signIn (View v) {

        email = (EditText) findViewById(R.id.etLoginEmail);
        password = (EditText) findViewById(R.id.etLoginPassword);

        this.textMail = email.getText().toString();
        this.textPsw = password.getText().toString();

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        boolean loggedIn = false;
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                loggedIn = checkLogin(document.getString("email"), document.getString("password"));

                                if(loggedIn) {
                                    break;
                                }
                            }
                        }

                        if (loggedIn) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setMessage("Email atau Password Anda benar!").setNegativeButton("Tutup", null).create().show();
                            Intent i = new Intent(getApplicationContext(),HomeClass.class);
                            startActivity(i);
                        }

                        else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setMessage("Email atau Password Anda salah!").setNegativeButton("Tutup", null).create().show();

                        }

                    }
                });

    }

    public void moveDaftar(View v)  {

        Intent i = new Intent(getApplicationContext(),RegisterClass.class);
        startActivity(i);

    }

}