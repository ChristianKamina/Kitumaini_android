package com.example.kitumaini_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.time.Instant;

public class Next_Activty extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next__activty);

        Button button = findViewById(R.id.btn_beneficiary);

        button.setOnClickListener(v -> {
          Intent intent = new Intent(Next_Activty.this, Login_beneficiare_activity.class);
          startActivity(intent);
        });

        Button b = findViewById(R.id.btn_service_provider);

        b.setOnClickListener(v -> {
            Intent i = new Intent(Next_Activty.this, Login_prestataire_Activity.class);
            startActivity(i);
        });
    }
}