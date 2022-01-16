package com.example.kitumaini_app.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kitumaini_app.MapsActivity;
import com.example.kitumaini_app.R;


public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        view.findViewById(R.id.card_maps).setOnClickListener(v -> startActivity(new Intent(getContext(), MapsActivity.class)));

        return view;
    }
}