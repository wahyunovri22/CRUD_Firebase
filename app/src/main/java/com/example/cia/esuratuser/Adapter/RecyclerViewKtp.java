package com.example.cia.esuratuser.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cia.esuratuser.Data.AddData;
import com.example.cia.esuratuser.Data.AddKtp;
import com.example.cia.esuratuser.Data.GetDataWarga;
import com.example.cia.esuratuser.R;

import java.util.List;

/**
 * Created by cia on 18/10/2017.
 */

public class RecyclerViewKtp extends RecyclerView.Adapter<RecyclerViewKtp.dataViewHolder> {

    List<AddData> getDataWargas;

    public RecyclerViewKtp(List<AddData> getDataWargas) {
        this.getDataWargas = getDataWargas;
    }

    @Override
    public dataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_warga,parent, false);
        dataViewHolder holder = new dataViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(dataViewHolder holder, int position) {
        AddData getDataWarga = getDataWargas.get(position);
        holder.namaWarga.setText(getDataWarga.getmNamaWarga());
        holder.namaRw.setText(getDataWarga.getmRw());
        holder.namaRt.setText(getDataWarga.getmRt());
    }

    @Override
    public int getItemCount() {
        return getDataWargas.size();
    }

    public class dataViewHolder extends RecyclerView.ViewHolder{

        TextView namaWarga,namaRt,namaRw;

        public dataViewHolder(View itemView) {
            super(itemView);

            namaWarga = (TextView)itemView.findViewById(R.id.txt_nama_warga);
            namaRt = (TextView)itemView.findViewById(R.id.txt_rt);
            namaRw = (TextView)itemView.findViewById(R.id.txt_rw);
        }
    }
}
