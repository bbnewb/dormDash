package com.example.dormdash;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

public class DashingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashing);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.positive_menu_click);

        Button orderButton = findViewById(R.id.createNewOrder);
        orderButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                mp.start();
                startActivity(new Intent(DashingActivity.this, NewOrderActivity.class));
            }
        });
    }

}
