package com.zhezhe.servicepractice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.zhezhe.servicepractice.services.MyService;

public class MainActivity extends AppCompatActivity {
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count % 2 == 0) {
                    startMyService(view);
                    bindMyService(view);
                } else {
                    unbindMyService(view);
                    stopMyService(view);
                }
                count++;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void startMyService(View v) {
        Intent intent = new Intent(MainActivity.this, MyService.class);
        this.startService(intent);
        Toast.makeText(this, "start service", Toast.LENGTH_SHORT).show();
    }

    public void stopMyService(View v) {
        Intent intent = new Intent(MainActivity.this, MyService.class);
        this.stopService(intent);
        Toast.makeText(this, "stop service", Toast.LENGTH_SHORT).show();
    }

    ServiceConnection sc;

    public void bindMyService(View v) {
        Intent intent = new Intent(this, MyService.class);
        if (sc == null) {
            sc = new ServiceConnection() {
                @Override
                public void onServiceConnected(ComponentName name, IBinder service) {
                    Log.e("TAG", "onServiceConnected");
                }

                @Override
                public void onServiceDisconnected(ComponentName name) {
                }
            };
        }
        bindService(intent, sc, BIND_AUTO_CREATE);
    }

    public void unbindMyService(View v) {
        if (sc == null) {
            unbindService(sc);
            sc = null;
            Toast.makeText(this, "unbind service", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "还么有bind serverice", Toast.LENGTH_SHORT).show();
        }
    }
}
