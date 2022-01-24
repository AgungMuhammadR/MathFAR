package com.example.quizzapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.auth.User;

public class ProfileClass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView nama = (TextView) findViewById(R.id.nama);
        EditText editNama = (EditText) findViewById(R.id.etUsername);
        EditText editEmail = (EditText) findViewById(R.id.etEmail);

        nama.setText(UserDataClass.username);
        editNama.setText(UserDataClass.username);
        editEmail.setText(UserDataClass.email);

        BottomNavigationView bottomNav = findViewById(R.id.bn_main);
        bottomNav.getMenu().getItem(3).setChecked(true);

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


}
