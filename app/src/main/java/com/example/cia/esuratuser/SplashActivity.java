package com.example.cia.esuratuser;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

import com.example.cia.esuratuser.helper.Config;
import com.example.cia.esuratuser.rule.HomeKelurahanActivity;
import com.example.cia.esuratuser.rule.HomeRTActivity;
import com.example.cia.esuratuser.rule.HomeUserActivity;

public class SplashActivity extends AppCompatActivity {
    private static int splash = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
//                Intent i = new Intent(SplashActivity.this, HomeActivity.class);
//                startActivity(i); // menghubungkan activity splashscren ke main activity dengan intent

                SharedPreferences sp = getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
                String email = sp.getString(Config.LOGIN_EMAIL_SHARED_PREF,"");
                String rulename = sp.getString(Config.LOGIN_RULE_SHARED_PREF,"");
                if(email.equalsIgnoreCase("") || TextUtils.isEmpty(email)) {
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
                else if (rulename.equalsIgnoreCase("user")){
                    Intent intent = new Intent(SplashActivity.this, HomeUserActivity.class);
                    startActivity(intent);
                }
                else if (rulename.equalsIgnoreCase("rt")){
                    Intent intent = new Intent(SplashActivity.this, HomeRTActivity.class);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(SplashActivity.this, HomeKelurahanActivity.class);
                    startActivity(intent);
                }
                //jeda selesai Splashscreen
                finish();
            }

        }, splash);

    }
}
