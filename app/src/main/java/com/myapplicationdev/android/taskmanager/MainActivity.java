package com.myapplicationdev.android.taskmanager;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnAdd;
    ListView lv;
    int reqCode = 12345;
    ArrayAdapter aa;
    ArrayList<Task> task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        lv = (ListView) this.findViewById(R.id.lv);

        // objects can be retrieved from database
        ArrayList<Task> objects = task;
        // Create the ArrayAdapter object.
        Adapter adapter = new Adapter(this, R.layout.row, objects);
        ListView lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(aa);



        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(this,addActivity.class);
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.SECOND,5);

                Intent intent = new Intent(MainActivity.this,ScheduledNotificationReceiver.class);

                PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this,reqCode,intent,PendingIntent.FLAG_CANCEL_CURRENT);

                AlarmManager am = (AlarmManager)getSystemService(Activity.ALARM_SERVICE);
                am.set(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pendingIntent);
            }
        });
    }
}
