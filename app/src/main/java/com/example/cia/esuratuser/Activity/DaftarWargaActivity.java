package com.example.cia.esuratuser.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.cia.esuratuser.Data.AddData;
import com.example.cia.esuratuser.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rengwuxian.materialedittext.MaterialEditText;

public class DaftarWargaActivity extends AppCompatActivity {

    MaterialEditText edtNama,edtRt,edtRw;
    String nama,rt,rw;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_warga);

        edtNama = (MaterialEditText)findViewById(R.id.edt_nama_warga);
        edtRt = (MaterialEditText)findViewById(R.id.edt_rt_warga);
        edtRw = (MaterialEditText)findViewById(R.id.edt_rw_warga);
        submit = (Button)findViewById(R.id.btn_daftar_warga);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SendData();
            }
        });
    }

    public void AmbilData(){
        nama = edtNama.getText().toString();
        rt = edtRt.getText().toString();
        rw = edtRw.getText().toString();
    }

    public void SendData(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseRef = database.getReference("DaftarWarga");
        AmbilData();
        databaseRef.push();

        AddData addData = new AddData(nama, rt, rw);
        databaseRef.child(nama).setValue(addData);
        Toast.makeText(this, "data terkirim", Toast.LENGTH_SHORT).show();
    }
}
