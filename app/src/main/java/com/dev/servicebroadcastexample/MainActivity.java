package com.dev.servicebroadcastexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String MY_FILTER = "com.dev.myReceiver.32222";
    public static final String COUNT = "_count";
    private TextView countTx;
    private BroadcastReceiver myBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int counter = intent.getIntExtra(COUNT,0);
            countTx.setText(Integer.toString(counter));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countTx = (TextView)findViewById(R.id.countTx);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(MY_FILTER);
        registerReceiver(myBroadcastReceiver,intentFilter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myBroadcastReceiver);
    }

    public void startBtnPressed(View view){
        Intent intent = new Intent(this,MyService.class);
        startService(intent);
    }

    public void stopBtnPressed(View view){
        Intent intent = new Intent(this,MyService.class);
        stopService(intent);
    }
}
