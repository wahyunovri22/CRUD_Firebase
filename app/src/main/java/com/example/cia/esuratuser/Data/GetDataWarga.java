package com.example.cia.esuratuser.Data;

/**
 * Created by cia on 18/10/2017.
 */

public class GetDataWarga {
    String mNamaWarga,mRt,mRw;

    public GetDataWarga(String mNamaWarga, String mRt, String mRw) {
        this.mNamaWarga = mNamaWarga;
        this.mRt = mRt;
        this.mRw = mRw;
    }
public GetDataWarga(){

}
    public String getmNamaWarga() {
        return mNamaWarga;
    }

    public String getmRt() {
        return mRt;
    }

    public String getmRw() {
        return mRw;
    }
}
