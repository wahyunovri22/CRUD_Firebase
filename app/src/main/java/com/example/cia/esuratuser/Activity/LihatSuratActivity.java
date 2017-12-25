package com.example.cia.esuratuser.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.cia.esuratuser.Adapter.RecyclerViewKtp;
import com.example.cia.esuratuser.Adapter.RecyclerViewLihatKtp;
import com.example.cia.esuratuser.Data.AddData;
import com.example.cia.esuratuser.Data.AddKtp;
import com.example.cia.esuratuser.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class LihatSuratActivity extends AppCompatActivity {

    List<AddKtp>addKtps;
    RecyclerView recyclerView;
    RecyclerViewLihatKtp recyclerViewLihatKtp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_surat);

        recyclerView = (RecyclerView)findViewById(R.id.rv_lihat_surat);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        addKtps = new ArrayList<>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseRef = database.getReference("KTP");

        recyclerViewLihatKtp = new RecyclerViewLihatKtp(addKtps,this);
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
