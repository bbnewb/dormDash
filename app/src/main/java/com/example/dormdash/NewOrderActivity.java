package com.example.dormdash;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
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

    ArrayList<DashItem> orderContents;

    CheckBox hamborger;
    CheckBox cheeseBorger;
    CheckBox bean;
    CheckBox doubleHamborger;

    Button finalizeOrder;

// and i oop
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
        double total = 0.00;
        orderContents = new ArrayList<>(0);
        if (hamborger.isChecked() || cheeseBorger.isChecked() || bean.isChecked() || doubleHamborger.isChecked()) {
            if (hamborger.isChecked()) {
                orderContents.add(new DashItem("Hamburger", 2.99));
            }
            if (cheeseBorger.isChecked()) {
                orderContents.add(new DashItem("cheese", 2.3));
            }
            if (bean.isChecked()) {
                orderContents.add(new DashItem("bean", 2.39));
            }
            if (doubleHamborger.isChecked()) {
                orderContents.add(new DashItem("2Hamburger", 7.99));
            }
            for (DashItem e : orderContents) {
                total += e.getPrice();
            }
            EditText e = findViewById(R.id.runningTotal);
            Double t = new Double(total);
            e.setText(t.toString());
            newOrder();
        }
        finalizeOrder = findViewById(R.id.finalizeOrder);
        finalizeOrder.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                Intent intent = new Intent(NewOrderActivity.this,  FinalizeOrderAndPay.class);
                intent.putExtra("orderList", orderContents);
                startActivity(intent);
            }
        });
    }
}
