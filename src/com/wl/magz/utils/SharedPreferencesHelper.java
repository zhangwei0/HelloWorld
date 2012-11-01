package com.wl.magz.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesHelper {
    private static final String NAME = "preferences";
    private static final String KEY_FIRST_LAUNCH = "first_launch";
    private static SharedPreferences mSp;

    public SharedPreferencesHelper(Context context) {
        if (mSp != null) return;
        mSp = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
    }

    public boolean getFirstLunch() {
        return mSp.getBoolean(KEY_FIRST_LAUNCH, true);
    }
    
    public void setFirstLaunch(boolean first) {
        mSp.edit().putBoolean(KEY_FIRST_LAUNCH, first).commit();
    }
}
