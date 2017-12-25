package com.example.cia.esuratuser.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.cia.esuratuser.Adapter.RecyclerViewKtp;
import com.example.cia.esuratuser.Data.AddData;
import com.example.cia.esuratuser.Data.GetDataWarga;
import com.example.cia.esuratuser.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class LihatWargaActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<AddData>getDataWargas;
    RecyclerViewKtp recyclerViewKtp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_warga);

        recyclerView = (RecyclerView)findViewById(R.id.rv_lihat_warga);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getDataWargas = new ArrayList<>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseRef = database.getReference("DaftarWarga");

        recyclerViewKtp = new RecyclerViewKtp(getDataWargas);
        recyclerView.setAdapter(recyclerViewKtp);

        databaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                getDataWargas.removeAll(getDataWargas);
                for (DataSnapshot snapshot :
                        dataSnapshot.getChildren())
                {
                    AddData dataku = snapshot.getValue(AddData.class);
                    getDataWargas.add(dataku);
                }
                recyclerViewKtp.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
