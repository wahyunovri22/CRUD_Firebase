package com.example.cia.esuratuser.helper;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.cia.esuratuser.LoginActivity;

/**
 * Created by root on 10/18/17.
 */

public final class Config {
    public static  String SHARED_PREF_NAME = "e-Surat";
    public static String LOGGEDIN_SHARED_PREF = "LogedIN";
    public static  String LOGIN_ID_SHARED_PREF = "ID";
    public static  String LOGIN_EMAIL_SHARED_PREF = "email";
    public static  String LOGIN_RULE_SHARED_PREF = "rule";

    public static void forceLogout(Context context) {
        //Getting out shared preferences
        SharedPreferences preferences = context.getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        //Getting editor
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(Config.LOGGEDIN_SHARED_PREF  , false);
        editor.putString(Config.LOGGEDIN_SHARED_PREF   , "");
        editor.putString(Config.LOGIN_ID_SHARED_PREF , "");
        editor.putString(Config.LOGIN_EMAIL_SHARED_PREF, "");
        editor.putString(Config.LOGIN_RULE_SHARED_PREF , "");
        //Saving the sharedpreferences
        editor.commit();

        //Starting login activity
        Intent intent = new Intent(context.getApplicationContext(), LoginActivity.class);
        context.startActivity(intent);

    }
}
