package com.example.quizzapp;

import android.os.Bundle;

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
import android.widget.TextView;

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

public class HomeClass extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    Toolbar toolbar;
    Context context;
    List<ItemObjectKelas> listItem;
    RecyclerView recyclerView, recyclerView2;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recylerViewLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        recyclerView = findViewById(R.id.recyclerView);
//
//        tabLayout = findViewById(R.id.tablayout);
//        viewPager = findViewById(R.id.viewpager);
//        toolbar =  findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
//        getTabs();

        setData();
        setAdapter();


    }

    private void setData() {
        String[] subjects = {"Kelas 1", "Kelas 2", "Kelas 3", "Kelas 4", "Kelas 5", "Kelas 6"};
        Drawable [] drwImg = {getResources().getDrawable(R.drawable.kelas1), getResources().getDrawable(R.drawable.kelas2),
                getResources().getDrawable(R.drawable.kelas3),getResources().getDrawable(R.drawable.kelas4),
                getResources().getDrawable(R.drawable.kelas5),getResources().getDrawable(R.drawable.kelas6)};

        listItem = new ArrayList<>();
        for (int i=0; i<6; i++) {
            listItem.add(new ItemObjectKelas(subjects[i], drwImg[i]));
        }

    }

    private void setAdapter () {

        context = getApplicationContext();
        recyclerViewAdapter = new AdapterRecyclerView(context, listItem);
        recylerViewLayoutManager = new LinearLayoutManager(context);

        recyclerView.setLayoutManager(recylerViewLayoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);
    }



    public void getTabs(){
        final ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                viewPagerAdapter.addFragment(EasyFragment.getInstance(),"Easy");
                viewPagerAdapter.addFragment(MediumFragment.getInstance(),"Medium");
                viewPagerAdapter.addFragment(HardFragment.getInstance(),"Hard");

                viewPager.setAdapter(viewPagerAdapter);
                tabLayout.setupWithViewPager(viewPager);

                tabLayout.getTabAt(0).setIcon(R.drawable.easy);
                tabLayout.getTabAt(1).setIcon(R.drawable.medium);
                tabLayout.getTabAt(2).setIcon(R.drawable.hard);


            }
        });
    }


}