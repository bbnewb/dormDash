package com.example.dormdash;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.*;
import java.util.ArrayList;

import static com.example.dormdash.Notifications.CHANNEL_FOODALERT;


public class DiningHallActivity extends AppCompatActivity {

    private ArrayList<String> foodListToNotify;
    CheckBox burger;
    CheckBox pizza;
    CheckBox stir;
    CheckBox chicken;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dining_hall);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        burger = findViewById(R.id.burgers);
        pizza = findViewById(R.id.pizza);
        stir = findViewById(R.id.stirFry);
        chicken = findViewById(R.id.chicken);
        Button button = findViewById(R.id.confirmList);
        button.setOnClickListener(u -> generateNotificationList());
    }
    private void generateNotificationList() {

        ArrayList<String> toBeList = new ArrayList<>(0);
       if (burger.isChecked()) {
           toBeList.add("burger");
       }
       if (pizza.isChecked()) {
           toBeList.add("pizza");
       }
       if (stir.isChecked()) {
           toBeList.add("stir");
       }
       if (chicken.isChecked()) {
           toBeList.add("chicken");
       }
    }

}
