package com.example.quizzapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class RankClass extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);

        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);
        toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        getTabs();

        BottomNavigationView bottomNav = findViewById(R.id.bn_main);
        bottomNav.getMenu().getItem(2).setChecked(true);
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
