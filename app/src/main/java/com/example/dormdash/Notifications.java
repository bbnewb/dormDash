package com.example.dormdash;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class Notifications extends Application {
    public static final String CHANNEL_FOODALERT = "food1";
    public void onCreate() {
        super.onCreate();
        CreateNotificationChannels();

    }
    private void CreateNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channelFoodAlert = new NotificationChannel(CHANNEL_FOODALERT,
                    "FoodAlertChannel", NotificationManager.IMPORTANCE_HIGH);
            channelFoodAlert.setDescription("Notification");
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channelFoodAlert);
        }

    }
}
