package com.my.market.notifcationdemoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button simple = findViewById(R.id.simple);



//            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
//                NotificationChannel ch = new NotificationChannel("This is my Noti","My",NotificationManager.IMPORTANCE_DEFAULT);
//                NotificationManager nm = getSystemService(NotificationManager.class);
//                nm.createNotificationChannel(ch);
//            }


        simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSimple();

            }
        });
    }

    private void addSimple() {
        EditText title = findViewById(R.id.title);
        EditText msg = findViewById(R.id.msg);
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(MainActivity.this, "This is my Noti");
        builder.setSmallIcon(R.drawable.baseline_circle_notifications_24);
        builder.setContentTitle(title.getText());
        builder.setContentText(msg.getText());
        builder.setAutoCancel(true);
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat nm = NotificationManagerCompat.from(MainActivity.this);
        if (ActivityCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
//                    return;
        }
        nm.notify(0, builder.build());
    }
}