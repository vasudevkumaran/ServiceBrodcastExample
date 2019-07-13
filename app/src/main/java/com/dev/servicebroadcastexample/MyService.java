package com.dev.servicebroadcastexample;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service implements Runnable{
    private Handler handler = new Handler();
    private int i = 0;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.w("MyService","Service created");
        handler.postDelayed(this,1000);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.w("MyService","Service destroyed");
        handler.removeCallbacks(this);
    }

    @Override
    public void run() {
        Log.w("MyService","Count: "+i);
        Intent intent = new Intent();
        intent.putExtra(MainActivity.COUNT,i);
        intent.setAction(MainActivity.MY_FILTER);
        sendBroadcast(intent);
        i = i+1;
        handler.postDelayed(this,1000);
    }
}
