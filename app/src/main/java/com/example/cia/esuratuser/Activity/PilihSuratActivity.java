package com.example.cia.esuratuser.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.cia.esuratuser.R;

public class PilihSuratActivity extends AppCompatActivity {

    ImageView imgPilihKtp,imgPilihKk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_surat);

        imgPilihKtp = (ImageView)findViewById(R.id.img_pilih_ktp);
        imgPilihKk = (ImageView)findViewById(R.id.img_pilih_kk);

        imgPilihKtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PilihSuratActivity.this, PilihKtpActivity.class);
                startActivity(intent);
            }
        });
    }
}
