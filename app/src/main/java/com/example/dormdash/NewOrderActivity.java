package com.example.dormdash;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class NewOrderActivity extends AppCompatActivity {

    private DashItem[] orderContents;

    CheckBox hamborger;
    CheckBox cheeseBorger;
    CheckBox bean;
    CheckBox doubleHamborger;
    Button finalizeOrder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_order);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        hamborger = findViewById(R.id.hamborger);
        cheeseBorger = findViewById(R.id.cheeseborger);
        bean = findViewById(R.id.beanBurger);
        doubleHamborger = findViewById(R.id.doubleBurger);
        newOrder();
    }

    public void newOrder() {
        finalizeOrder = findViewById(R.id.finalizeOrder);
        finalizeOrder.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                if (hamborger.isChecked()) {
                }
            }
        });
    }
}
