package com.example.cia.esuratuser.Data;

/**
 * Created by cia on 16/10/2017.
 */

public class AddData {
    String mNamaWarga,mRt,mRw;

    public AddData(String mNamaWarga, String mRt, String mRw) {
        this.mNamaWarga = mNamaWarga;
        this.mRt = mRt;
        this.mRw = mRw;
    }

public AddData(){

}
    public String getmNamaWarga() {
        return mNamaWarga;
    }

    public void setmNamaWarga(String mNamaWarga) {
        this.mNamaWarga = mNamaWarga;
    }

    public String getmRt() {
        return mRt;
    }

    public void setmRt(String mRt) {
        this.mRt = mRt;
    }

    public String getmRw() {
        return mRw;
    }

    public void setmRw(String mRw) {
        this.mRw = mRw;
    }
}
