package com.example.quizzapp;

import android.os.Bundle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.lang.reflect.Type;
import java.util.List;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.graphics.drawable.Drawable;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
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
        setData();
        setAdapter();

        BottomNavigationView bottomNav = findViewById(R.id.bn_main);
        bottomNav.getMenu().getItem(0).setChecked(true);

        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home_menu:
                        Intent hm = new Intent(getApplicationContext(), HomeClass.class);
                        startActivity(hm);
                        break;

                    case R.id.kelas_menu:
                        Intent pk = new Intent(getApplicationContext(), PilihKelas.class);
                        startActivity(pk);
                        break;

                    case R.id.rank_menu:
                        Intent rk = new Intent(getApplicationContext(), RankClass.class);
                        startActivity(rk);
                        break;

                    case R.id.profile_menu:
                        Intent pf = new Intent(getApplicationContext(), ProfileClass.class);
                        startActivity(pf);
                        break;
                }

                return true;
            }
        });

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




}