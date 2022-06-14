package com.gzeinnumer.b5d6;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    public static String PREF_NAME = "com.gzeinnumer.b5d6";
    public static String KEY_ID = "id";
    public static String KEY_NAME = "name";

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    public SessionManager(Context context) {
        mSharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public void setId(String id) {
        mEditor = mSharedPreferences.edit();
        mEditor.putString(KEY_ID, id).apply();
    }

    public String getId() {
        return mSharedPreferences.getString(KEY_ID, null);
    }

    public void setValue(String key, String data) {
        mEditor = mSharedPreferences.edit();
        mEditor.putString(key, data).apply();
    }

    public void deleteValue(String key) {
        mEditor = mSharedPreferences.edit();
        mEditor.putString(key, null).apply();
    }

    public String getValue(String key) {
        return mSharedPreferences.getString(key, null);
    }

    public void logout() {
        mEditor = mSharedPreferences.edit();
        mEditor.clear().commit();
    }
}
