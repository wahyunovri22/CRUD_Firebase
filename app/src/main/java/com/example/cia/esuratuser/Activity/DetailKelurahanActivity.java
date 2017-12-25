package com.example.cia.esuratuser.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.cia.esuratuser.R;

public class DetailKelurahanActivity extends AppCompatActivity {

    String mNama,mTempatLahir,mTanggalLahir,mKelamin,mAlamat,mGoldarah,
            mAgama,mStatus,mPekerjaan,mKewarganegaraan,mEmail;

    TextView Nama,TempatLahir,TanggalLahir,Kelamin,Alamat,Goldarah,
            Agama,Status,Pekerjaan,Kewarganegaraan,Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kelurahan);

        Intent i = getIntent();
        mNama = i.getStringExtra("nama");
        //get data gambar
        mTempatLahir = i.getStringExtra("tempat");
        // get data nama
        mTanggalLahir = i.getStringExtra("tanggal");
        // get data alamat
        mKelamin = i.getStringExtra("kelamin");
        // get data deskripsi
        mAlamat = i.getStringExtra("alamat");
        mGoldarah = i.getStringExtra("darah");
        mAgama = i.getStringExtra("agama");
        mStatus = i.getStringExtra("status");
        mPekerjaan = i.getStringExtra("pekerjaan");
        mKewarganegaraan = i.getStringExtra("kewarganegaraan");
        mEmail = i.getStringExtra("email");

        Nama = (TextView)findViewById(R.id.txt_detail_nama_kelurahan);
        TempatLahir = (TextView)findViewById(R.id.txt_detail_tempat_kelurahan);
        TanggalLahir = (TextView)findViewById(R.id.txt_detail_tanggal_kelurahan);
        Kelamin = (TextView)findViewById(R.id.txt_detail_jkelamin_kelurahan);
        Alamat = (TextView)findViewById(R.id.txt_detail_alamat_kelurahan);
        Goldarah = (TextView)findViewById(R.id.txt_detail_darah_kelurahan);
        Agama = (TextView)findViewById(R.id.txt_detail_agama_kelurahan);
        Status = (TextView)findViewById(R.id.txt_detail_status_kelurahan);
        Pekerjaan = (TextView)findViewById(R.id.txt_detail_pekerjaan_kelurahan);
        Kewarganegaraan = (TextView)findViewById(R.id.txt_detail_kewarganegaraan_kelurahan);
        Email = (TextView)findViewById(R.id.txt_detail_email_kelurahan);


        Nama.setText(mNama);
        TempatLahir.setText(mTempatLahir);
        TanggalLahir.setText(mTanggalLahir);
        Kelamin.setText(mKelamin);
        Alamat.setText(mAlamat);
        Goldarah.setText(mGoldarah);
        Agama.setText(mAgama);
        Status.setText(mStatus);
        Pekerjaan.setText(mPekerjaan);
        Kewarganegaraan.setText(mKewarganegaraan);
        Email.setText(mEmail);
    }
}
