package com.example.kitumaini_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.kitumaini_app.fragments.FormFragment;
import com.example.kitumaini_app.fragments.HomeFragment;
import com.example.kitumaini_app.fragments.PictureFragment;
import com.example.kitumaini_app.fragments.PrintFragment;

public class EnrolementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enrolement);

        /*---default fragment---*/
        FragmentTransaction ft_dash = getSupportFragmentManager().beginTransaction();
        ft_dash.replace(R.id.fragment_enrolement, new FormFragment());
        ft_dash.commit();

        findViewById(R.id.card_form).setOnClickListener(v -> {
            FragmentTransaction ft_form = getSupportFragmentManager().beginTransaction();
            ft_form.replace(R.id.fragment_enrolement, new FormFragment());
            ft_form.commit();
        });
        findViewById(R.id.card_picture).setOnClickListener(v -> {
            FragmentTransaction ft_picture = getSupportFragmentManager().beginTransaction();
            ft_picture.replace(R.id.fragment_enrolement, new PictureFragment());
            ft_picture.commit();
        });
        findViewById(R.id.card_print).setOnClickListener(v -> {
            FragmentTransaction ft_print = getSupportFragmentManager().beginTransaction();
            ft_print.replace(R.id.fragment_enrolement, new PrintFragment());
            ft_print.commit();
        });
    }
}