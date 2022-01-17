package com.example.kitumaini_app.fragments;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kitumaini_app.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class FormFragment extends Fragment {

    TextView txt_enrollment_birthdate;
    Spinner sp_enrollment_sex;
    List<String> listSex;
    String selected_sex;
    DatePickerDialog.OnDateSetListener onDateSetListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_form, container, false);

        sp_enrollment_sex = view.findViewById(R.id.sp_enrollment_sex);

        listSex = new ArrayList<>();
        listSex.add("Masculin");
        listSex.add("Feminin");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.support_simple_spinner_dropdown_item, listSex);
        sp_enrollment_sex.setAdapter(adapter);

        sp_enrollment_sex.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected_sex = listSex.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getContext(), "Result: "+parent, Toast.LENGTH_SHORT).show();
            }
        });

        txt_enrollment_birthdate = view.findViewById(R.id.txt_enrollment_birthdate);
        txt_enrollment_birthdate.setOnClickListener(v -> {

            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                    onDateSetListener, year, month, day);

            datePickerDialog.show();
        });
        onDateSetListener = (view1, year, month, dayOfMonth) -> {

            Calendar calendar1 = Calendar.getInstance();
            calendar1.set(Calendar.YEAR, year);
            calendar1.set(Calendar.MONTH, month);
            calendar1.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            month = month + 1;
            String date = dayOfMonth+"/"+month+"/"+year;
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEE "+date);
            txt_enrollment_birthdate.setText(dateFormat.format(calendar1.getTime()));
        };

        view.findViewById(R.id.btn_enrollment_save).setOnClickListener(v -> {
            Toast.makeText(getContext(), "Save!", Toast.LENGTH_SHORT).show();
        });

        return view;
    }
}