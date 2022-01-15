package com.example.kitumaini_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.kitumaini_app.fragments.HomeFragment;
import com.example.kitumaini_app.fragments.NotificationFragment;
import com.example.kitumaini_app.fragments.ProfileFragment;
import com.example.kitumaini_app.fragments.SettingsFragment;

import java.util.function.Function;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

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
        navigation.add(new MeowBottomNavigation.Model(4, R.drawable.ic_baseline_settings));

        /*---default fragment---*/
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new HomeFragment());
        fragmentTransaction.commit();

        navigation.setOnClickMenuListener(model -> {

            if (model.getId() == 1){
                FragmentTransaction ft_dash = getSupportFragmentManager().beginTransaction();
                ft_dash.replace(R.id.fragment_container, new HomeFragment());
                ft_dash.commit();
            }if (model.getId() == 2){
                FragmentTransaction ft_dash = getSupportFragmentManager().beginTransaction();
                ft_dash.replace(R.id.fragment_container, new NotificationFragment());
                ft_dash.commit();
            }if (model.getId() == 3){
                FragmentTransaction ft_dash = getSupportFragmentManager().beginTransaction();
                ft_dash.replace(R.id.fragment_container, new ProfileFragment());
                ft_dash.commit();
            }if (model.getId() == 4){
                FragmentTransaction ft_dash = getSupportFragmentManager().beginTransaction();
                ft_dash.replace(R.id.fragment_container, new SettingsFragment());
                ft_dash.commit();
            }
            return null;
        });
    }
}