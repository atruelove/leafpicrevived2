package com.alienpants.leafpicrevived2;

import android.content.Context;

import androidx.multidex.MultiDexApplication;

import com.google.android.play.core.splitcompat.SplitCompat;
import com.orhanobut.hawk.Hawk;

import com.alienpants.leafpicrevived2.util.ApplicationUtils;
import com.alienpants.leafpicrevived2.util.preferences.Prefs;

/**
 * Created by dnld on 28/04/16.
 */
public class App extends MultiDexApplication {

    private static App mInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        ApplicationUtils.init(this);

        initialiseStorage();
    }

    public static App getInstance() {
        return mInstance;
    }

    private void initialiseStorage() {
        Prefs.init(this);
        Hawk.init(this).build();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        SplitCompat.install(this);
    }
}
