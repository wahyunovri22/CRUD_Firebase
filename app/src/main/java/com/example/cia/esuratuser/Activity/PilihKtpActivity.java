package com.example.cia.esuratuser.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.cia.esuratuser.Data.AddKtp;
import com.example.cia.esuratuser.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rengwuxian.materialedittext.MaterialEditText;

public class PilihKtpActivity extends AppCompatActivity {

    MaterialEditText edtNama,edtTempat,edtTgl,edtkelamin,edtAlamat,edtDarah,
                        edtAgama,edtStatus,edtPekejaan, edtKewarganegaraan,edtEmail;
    Button btnDaftar;

    String nama,tempat,tgl,kelamin,alamat,darah,agama,status,pekerjaan,kewarganegaraan,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_ktp);

        edtNama = (MaterialEditText)findViewById(R.id.edt_nama_ktp);
        edtTempat = (MaterialEditText)findViewById(R.id.edt_tempat_lahir_ktp);
        edtTgl = (MaterialEditText)findViewById(R.id.edt_ttl_ktp);
        edtkelamin = (MaterialEditText)findViewById(R.id.edt_jkelamin_ktp);
        edtAlamat = (MaterialEditText)findViewById(R.id.edt_alamat_ktp);
        edtDarah = (MaterialEditText)findViewById(R.id.edt_goldarah_ktp);
        edtAgama = (MaterialEditText)findViewById(R.id.edt_agama_ktp);
        edtStatus = (MaterialEditText)findViewById(R.id.edt_status_ktp);
        edtPekejaan = (MaterialEditText)findViewById(R.id.edt_pekerjaan_ktp);
        edtKewarganegaraan = (MaterialEditText)findViewById(R.id.edt_kewarganegaraan_ktp);
        edtEmail = (MaterialEditText)findViewById(R.id.edt_email_ktp);
        btnDaftar = (Button)findViewById(R.id.btn_daftar_ktp);

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SendData();
            }
        });
    }

    public void AmbilData(){
        nama = edtNama.getText().toString();
        tempat = edtTempat.getText().toString();
        tgl = edtTgl.getText().toString();
        kelamin = edtkelamin.getText().toString();
        alamat = edtAlamat.getText().toString();
        darah = edtDarah.getText().toString();
        agama = edtAgama.getText().toString();
        status = edtStatus.getText().toString();
        pekerjaan = edtPekejaan.getText().toString();
        kewarganegaraan = edtKewarganegaraan.getText().toString();
        email = edtEmail.getText().toString();
    }
    public void SendData (){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseRef = database.getReference("KTP");
        AmbilData();
        databaseRef.push();

        AddKtp addKtp = new AddKtp(nama,tempat,tgl,kelamin,alamat,darah,agama,status,
                pekerjaan,kewarganegaraan,email);
        //databaseReference.child(id).setValue(addData);
        databaseRef.child(nama).setValue(addKtp);
        Toast.makeText(this, "Data Terkirim", Toast.LENGTH_SHORT).show();
    }
}
