package com.example.kitumaini_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class HomeActivity extends AppCompatActivity {

    MeowBottomNavigation navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        navigation = findViewById(R.id.bottom_navigation);
        navigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_baseline_home));
        navigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_baseline_notifications));
        navigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_baseline_person));


    }
}