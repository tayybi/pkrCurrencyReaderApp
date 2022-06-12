package com.google.android.gms.samples.vision.ocrreader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class VloumChangeReciver extends BroadcastReceiver {

    int i=0;
    Thread thread;
    public static int count=0;

    @Override
    public void onReceive(Context context, Intent intent) {

        //if (intent.getAction().equals("android.media.VOLUME_CHANGED_ACTION"))
       // intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_VALUE",0);
//        count++;
//        Log.i("count",""+count);
//            if(count==3){
//                Intent i = new Intent();
//                i.setClass(context, SplashScreen.class);
//                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                context.startActivity(i);
//                count=0;
//            }
    }

}
