package com.example.dormdash;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;


public class DiningHallActivity extends AppCompatActivity {

    //private ArrayList<String> foodListToNotify;
    CheckBox burger;
    CheckBox pizza;
    CheckBox stir;
    CheckBox chicken;
    EditText input;
    TextView prompt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dining_hall);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        prompt = findViewById(R.id.promptText);
        input = findViewById(R.id.itemInput);

        burger = findViewById(R.id.burgers);
        pizza = findViewById(R.id.pizza);
        stir = findViewById(R.id.stirFry);
        chicken = findViewById(R.id.chicken);

        Button button = findViewById(R.id.confirmList);

        burger.setVisibility(View.INVISIBLE);
        pizza.setVisibility(View.INVISIBLE);
        stir.setVisibility(View.INVISIBLE);
        chicken.setVisibility(View.INVISIBLE);

        final MediaPlayer confirmed = MediaPlayer.create(this, R.raw.order_confirmed);


//        Context c = getApplicationContext();
//        MainActivity b = new MainActivity(this);

        button.setOnClickListener((u) -> {
            confirmed.start();
            generateNotificationList();


            //b.sendOnFoodChannel(View view);


            //MainActivity.sendOnFoodChannel(u);
        });


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
