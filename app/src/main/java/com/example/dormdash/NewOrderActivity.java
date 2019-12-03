package com.example.dormdash;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
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

    private ArrayList<DashItem> orderContents;

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

        Button subtotal = findViewById(R.id.subtotal);
        subtotal.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                double priceTotal = 0.00;
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
                    } else {
                        orderContents.add(new DashItem("null", 0.00));
                    }
                    for (DashItem e : orderContents) {
                        priceTotal += e.getPrice();
                    }
                    EditText e = findViewById(R.id.runningTotal);
                    Double t = new Double(priceTotal);
                    e.setText(t.toString());
                } else {
                    orderContents.add(new DashItem("null", 0.00));
                    for (DashItem e : orderContents) {
                        priceTotal += e.getPrice();
                    }
                    EditText e = findViewById(R.id.runningTotal);
                    Double t = new Double(priceTotal);
                    e.setText(t.toString());
                }
            }
        });

        finalizeOrder = findViewById(R.id.finalizeOrder);
        finalizeOrder.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                DashItem first = orderContents.get(0);
                String firstItem = first.getName();
                if (firstItem.equals("null")) {
                    LayoutInflater inflater = (LayoutInflater)
                            getSystemService(LAYOUT_INFLATER_SERVICE);
                    View popupView = inflater.inflate(R.layout.popup, null);

                    // create the popup window
                    int width = LinearLayout.LayoutParams.WRAP_CONTENT;
                    int height = LinearLayout.LayoutParams.WRAP_CONTENT;
                    boolean focusable = true; // lets taps outside the popup also dismiss it
                    final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

                    // adds a shadow
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        popupWindow.setElevation(20);
                    }

                    // show the popup window
                    // which view you pass in doesn't matter, it is only used for the window token
                    popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);

                    // dismiss the popup window when touched
                    popupView.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            popupWindow.dismiss();
                            return true;
                        }
                    });
                } else {
                    finalizeOrder = findViewById(R.id.finalizeOrder);
                    finalizeOrder.setOnClickListener(new View.OnClickListener() {
                        public void onClick(final View v) {
                            Intent intent = new Intent(NewOrderActivity.this, FinalizeOrderAndPay.class);
                            intent.putExtra("orderList", orderContents);
                            startActivity(intent);
                        }
                    });
                }
            }
        });
    }
}
