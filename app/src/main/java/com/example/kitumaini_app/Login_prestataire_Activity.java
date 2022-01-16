package com.example.kitumaini_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login_prestataire_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_prestataire_);

        Button b = findViewById(R.id.btn_prest_login);
        b.setOnClickListener(v -> {
            Intent i = new Intent(Login_prestataire_Activity.this, HomeActivity.class);
            startActivity(i);
        });
    }
}