package com.alienpants.leafpicrevived2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;

import com.alienpants.leafpicrevived2.activities.MainActivity;

public class MyActivityManager {

    private static boolean lowPower;
    private static boolean lpmEnabled;

    public MyActivityManager() {

    }


    public void setBatteryStatus(Intent batteryStatus) {

    }


    public void checkBatteryStatus(Context context) {
        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = context.registerReceiver(null, ifilter);
        int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

        float batteryPct = level * 100 / (float)scale;
        if (batteryPct <= 20) {
            lowPower = true;
        }
        else {
            lowPower = false;
        }
    }

    public void lowPowerBlock(Context context) {
        new AlertDialog.Builder(context)
                .setTitle("Notification")
                .setMessage("Feature Disabled While Battery is Low")
                .setPositiveButton("Close", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                //do nothing
            }
        }).show();
    }

    public boolean getLowPower() {
        return lowPower;
    }


}
