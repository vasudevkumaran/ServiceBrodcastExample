package com.dev.servicebroadcastexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        String action = intent.getAction();

        if (action.equals("android.provider.Telephony.SMS_RECEIVED")){

        }else{
            //boot completed
        }
    }
}
