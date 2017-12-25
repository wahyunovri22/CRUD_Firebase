package com.example.cia.esuratuser.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cia.esuratuser.Data.AddKtp;
import com.example.cia.esuratuser.Activity.DetailKelurahanActivity;
import com.example.cia.esuratuser.R;

import java.util.List;

/**
 * Created by cia on 18/10/2017.
 */

public class RecyclerViewKelurahan extends RecyclerView.Adapter<RecyclerViewKelurahan.dataViewHolder> {

    List<AddKtp> addKtps;
    private Context context;

    public RecyclerViewKelurahan(List<AddKtp> addKtps, Context context) {
        this.addKtps = addKtps;
        this.context = context;
    }

    @Override
    public dataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_ktp_kk,parent, false);
        RecyclerViewKelurahan.dataViewHolder holder = new RecyclerViewKelurahan.dataViewHolder(view);
        view.setOnClickListener(clickListener);
        view.setTag(holder);
        return holder;
    }

    @Override
    public void onBindViewHolder(dataViewHolder holder, int position) {
        AddKtp addKtp = addKtps.get(position);
        holder.nama.setText(addKtp.getmNama());
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            dataViewHolder vholder = (dataViewHolder) view.getTag();
            int position = vholder.getPosition();
            Intent intent = new Intent(context, DetailKelurahanActivity.class);
            intent.putExtra("nama", addKtps.get(position).getmNama());
            // Pass all data gambar
            intent.putExtra("tempat", addKtps.get(position).getmTempatLahir());
            // Pass all data nama
            intent.putExtra("tanggal", addKtps.get(position).getmTanggalLahir());
            // Pass all data alamat
            intent.putExtra("kelamin",addKtps.get(position).getmKelamin());
            // Pass all data deskripsi
            intent.putExtra("alamat",addKtps.get(position).getmAlamat());
            intent.putExtra("darah",addKtps.get(position).getmGoldarah());
            intent.putExtra("agama",addKtps.get(position).getmAgama());
            intent.putExtra("status",addKtps.get(position).getmStatus());
            intent.putExtra("pekerjaan",addKtps.get(position).getmPekerjaan());
            intent.putExtra("kewarganegaraan",addKtps.get(position).getmKewarganegaraan());
            intent.putExtra("email",addKtps.get(position).getmEmail());

            // Start SingleItemView Class
            context.startActivity(intent);
        }
    };

    @Override
    public int getItemCount() {
        return addKtps.size();
    }

    public class dataViewHolder extends RecyclerView.ViewHolder {
        TextView nama;
        public dataViewHolder(View itemView) {
            super(itemView);
            nama = (TextView)itemView.findViewById(R.id.txt_nama_ktp_kk);
        }
    }
}
