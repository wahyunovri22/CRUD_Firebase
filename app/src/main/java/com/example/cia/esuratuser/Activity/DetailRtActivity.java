package com.example.cia.esuratuser.Activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cia.esuratuser.Data.AddKtp;
import com.example.cia.esuratuser.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DetailRtActivity extends AppCompatActivity {

    String mNama, mTempatLahir, mTanggalLahir, mKelamin, mAlamat, mGoldarah,
            mAgama, mStatus, mPekerjaan, mKewarganegaraan, mEmail;

    TextView Nama, TempatLahir, TanggalLahir, Kelamin, Alamat, Goldarah,
            Agama, Status, Pekerjaan, Kewarganegaraan, Email;

    Button btnOk, btnCancel;

    Spinner mSpinner;

    Boolean showButton = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_rt);

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

        Nama = (TextView) findViewById(R.id.txt_detail_nama_rt);
        TempatLahir = (TextView) findViewById(R.id.txt_detail_tempat_rt);
        TanggalLahir = (TextView) findViewById(R.id.txt_detail_tanggal_rt);
        Kelamin = (TextView) findViewById(R.id.txt_detail_jkelamin_rt);
        Alamat = (TextView) findViewById(R.id.txt_detail_alamat_rt);
        Goldarah = (TextView) findViewById(R.id.txt_detail_goldarah_rt);
        Agama = (TextView) findViewById(R.id.txt_detail_agama_rt);
        Status = (TextView) findViewById(R.id.txt_detail_status_rt);
        Pekerjaan = (TextView) findViewById(R.id.txt_detail_pekerjaan_rt);
        Kewarganegaraan = (TextView) findViewById(R.id.txt_detail_kewarganegaraan_rt);
        Email = (TextView) findViewById(R.id.txt_detail_email_rt);

        btnOk = (Button) findViewById(R.id.btn_detail_ok_rt);
        btnCancel = (Button) findViewById(R.id.btn_detail_cancel_rt);

        mSpinner = (Spinner) findViewById(R.id.spinner);

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

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SendData();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (showButton == true) {
                    btnOk.setEnabled(false);
                    mSpinner.setVisibility(View.VISIBLE);
                    showButton = false;
                } else {
                    btnOk.setEnabled(true);
                    mSpinner.setVisibility(View.GONE);
                    showButton = true;
                }

            }
        });

        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (mSpinner.getSelectedItemPosition() == 0) {

                } else {
                    Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                            "mailto", mEmail, null));
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Pembatalan EhSurat");
                    intent.putExtra(Intent.EXTRA_TEXT, mSpinner.getSelectedItem().toString());
                    startActivity(Intent.createChooser(intent, "Choose an Email client :"));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void SendData() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseRef = database.getReference("KTP KELURAHAN");
        //AmbilData();
        databaseRef.push();

        AddKtp addKtp = new AddKtp(mNama, mTempatLahir, mTanggalLahir, mKelamin, mAlamat, mGoldarah, mAgama, mStatus,
                mPekerjaan, mKewarganegaraan, mEmail);
        //databaseReference.child(id).setValue(addData);
        databaseRef.child(mNama).setValue(addKtp);
        Toast.makeText(this, "Data Terkirim", Toast.LENGTH_SHORT).show();
    }
}
