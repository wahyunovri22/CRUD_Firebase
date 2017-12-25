package com.example.cia.esuratuser.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.cia.esuratuser.Adapter.RecyclerViewKelurahan;
import com.example.cia.esuratuser.Adapter.RecyclerViewLihatKtp;
import com.example.cia.esuratuser.Data.AddKtp;
import com.example.cia.esuratuser.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class LihatSuratKelurahanActivity extends AppCompatActivity {

    List<AddKtp> addKtps;
    RecyclerView recyclerView;
    RecyclerViewKelurahan recyclerViewLihatKtp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_surat_kelurahan);

        recyclerView = (RecyclerView)findViewById(R.id.rv_lihat_surat_kelurahan);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        addKtps = new ArrayList<>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseRef = database.getReference("KTP KELURAHAN");

        recyclerViewLihatKtp = new RecyclerViewKelurahan(addKtps,this);
        recyclerView.setAdapter(recyclerViewLihatKtp);

        databaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                addKtps.removeAll(addKtps);
                for (DataSnapshot snapshot :
                        dataSnapshot.getChildren())
                {
                    AddKtp dataku = snapshot.getValue(AddKtp.class);
                    addKtps.add(dataku);
                }
                recyclerViewLihatKtp.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
