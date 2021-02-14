package com.zhezhe.servicepractice.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
        Log.e("TAG", "MyService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("TAG", "MyService onCreate()");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("TAG", "MyService onDestroy()");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.e("TAG", "MyService onBind");
        return new Binder();
    }
}
