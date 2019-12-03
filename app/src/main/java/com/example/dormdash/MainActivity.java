package com.example.dormdash;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        // This "super" call is required for all activities
        super.onCreate(savedInstanceState);
        // Create the UI from a layout resource
        setContentView(R.layout.activity_main);
        // This activity doesn't do anything yet - it immediately launches the game activity
        // Work on it will start in Checkpoint 1
        Button goodbye = findViewById(R.id.dormDash);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.sample);

        goodbye.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                //mp.start();
                startActivity(new Intent(MainActivity.this, DashingActivity.class));
            }
        });
        Button hi = findViewById(R.id.diningHall);
        hi.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                startActivity(new Intent(MainActivity.this, DiningHallActivity.class));
            }
        });
        // Intents are Android's way of specifying what to do/launch
        // Here we create an Intent for launching GameActivity and act on it with startActivity

        // End this activity so that it's removed from the history
        // Otherwise pressing the back button in the game would come back to a blank screen here
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
