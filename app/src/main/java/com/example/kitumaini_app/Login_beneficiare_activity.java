package com.example.kitumaini_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Login_beneficiare_activity extends AppCompatActivity {

    TextView txt_benef_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_beneficiare_activity);

        txt_benef_date = findViewById(R.id.txt_benef_date);
        txt_benef_date.setOnClickListener(v -> {

            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    R.style.DialogTheme, (view, year1, month1, dayOfMonth) -> {

                Calendar calendar1 = Calendar.getInstance();
                calendar1.set(Calendar.YEAR, year1);
                calendar1.set(Calendar.MONTH, month1);
                calendar1.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                month1 = month1 +1;
                String date = +dayOfMonth+"/"+ month1 +"/"+ year1;
                SimpleDateFormat dateFormat = new SimpleDateFormat("EEE "+date);
                txt_benef_date.setText(dateFormat.format(calendar1.getTime()));

            },
                    year, month, day);

            datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));

            datePickerDialog.show();
        });

        findViewById(R.id.btn_benef_Login)
                .setOnClickListener(v -> {
            Intent i = new Intent(Login_beneficiare_activity.this, HomeActivity.class);
            startActivity(i);
        });
    }
}