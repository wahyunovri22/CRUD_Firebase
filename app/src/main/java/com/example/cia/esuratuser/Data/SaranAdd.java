package com.example.cia.esuratuser.Data;

/**
 * Created by root on 10/18/17.
 */

public class SaranAdd {
    String nama, saran;

    public SaranAdd(String nama, String saran) {
        this.nama = nama;
        this.saran = saran;
    }
    public SaranAdd(){

    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getSaran() {
        return saran;
    }

    public void setSaran(String saran) {
        this.saran = saran;
    }
}
