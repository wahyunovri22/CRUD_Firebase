package com.example.cia.esuratuser.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cia.esuratuser.Data.SaranAdd;
import com.example.cia.esuratuser.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SaranActivity extends AppCompatActivity {

    private TextView tvNamaSaran;
    private EditText edtmasukanSaran;
    private Button btnSimpan;
    private String nama, saran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saran);
        initView();

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SendData();
            }
        });
    }

    private void initView() {
        tvNamaSaran = (TextView) findViewById(R.id.tvNamaSaran);
        edtmasukanSaran = (EditText) findViewById(R.id.edtmasukanSaran);
        btnSimpan = (Button) findViewById(R.id.btnSimpan);
    }
    public void SendData (){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseRef = database.getReference("Saran");
        AmbilData();
        databaseRef.push();

        SaranAdd saranAdd = new SaranAdd(nama,saran);
        //databaseReference.child(id).setValue(addData);
        if (databaseRef.child(nama).setValue(saranAdd) == null){
            Toast.makeText(this, "Gagal Mengirim", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Data Terkirim " + saranAdd, Toast.LENGTH_SHORT).show();
        }
//        databaseRef.child(nama).setValue(saranAdd);
    }

    private void AmbilData() {
        nama = tvNamaSaran.getText().toString().trim();
        saran = edtmasukanSaran.getText().toString().trim();
    }
}
