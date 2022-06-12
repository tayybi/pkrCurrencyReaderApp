package com.google.android.gms.samples.vision.ocrreader;

import android.content.Context;
import android.content.SharedPreferences;

import java.sql.RowId;

public class SharedPrefManager {
    public static String SHARED_PREF_Check = "check";

    public static final String FLASH ="flash";
    public static final String FOCUS = "focus";
    public static final String REGIST = "register";

    public static SharedPrefManager mInstance;
    public static Context mCtx;
    public SharedPreferences sharedPrefs;
    public SharedPreferences.Editor editor;

    public SharedPrefManager(Context context) {
        mCtx = context;
    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }





    public boolean isflashedChecked() {
        sharedPrefs = mCtx.getSharedPreferences(SHARED_PREF_Check, Context.MODE_PRIVATE);
        return sharedPrefs.getBoolean(FLASH, false);
    }
    public boolean isfousehedChecked() {
        sharedPrefs = mCtx.getSharedPreferences(SHARED_PREF_Check, Context.MODE_PRIVATE);
        return sharedPrefs.getBoolean(FOCUS, false);
    }
    public boolean isreg() {
        sharedPrefs = mCtx.getSharedPreferences(SHARED_PREF_Check, Context.MODE_PRIVATE);
        return sharedPrefs.getString(REGIST, null) != null;
    }


    /////////////////////////////////////////////////

    public void setChecks(boolean flash, boolean focus,String reg) {
        sharedPrefs = mCtx.getSharedPreferences(SHARED_PREF_Check, Context.MODE_PRIVATE);
        editor = sharedPrefs.edit();
        editor.putBoolean(FOCUS, focus);
        editor.putBoolean(FLASH, flash);
        editor.putString(REGIST, reg);
        editor.apply();
    }
}
