package com.example.cia.esuratuser.Data;

/**
 * Created by cia on 16/10/2017.
 */

public class AddKtp {
    String mNama,mTempatLahir,mTanggalLahir,mKelamin,mAlamat,mGoldarah,
            mAgama,mStatus,mPekerjaan,mKewarganegaraan,mEmail;

    public AddKtp(String mNama, String mTempatLahir, String mTanggalLahir, String mKelamin,
                  String mAlamat, String mGoldarah, String mAgama,
                  String mStatus, String mPekerjaan, String mKewarganegaraan, String mEmail) {
        this.mNama = mNama;
        this.mTempatLahir = mTempatLahir;
        this.mTanggalLahir = mTanggalLahir;
        this.mKelamin = mKelamin;
        this.mAlamat = mAlamat;
        this.mGoldarah = mGoldarah;
        this.mAgama = mAgama;
        this.mStatus = mStatus;
        this.mPekerjaan = mPekerjaan;
        this.mKewarganegaraan = mKewarganegaraan;
        this.mEmail = mEmail;
    }
    public AddKtp(){

    }

    public String getmNama() {
        return mNama;
    }

    public void setmNama(String mNama) {
        this.mNama = mNama;
    }

    public String getmTempatLahir() {
        return mTempatLahir;
    }

    public void setmTempatLahir(String mTempatLahir) {
        this.mTempatLahir = mTempatLahir;
    }

    public String getmTanggalLahir() {
        return mTanggalLahir;
    }

    public void setmTanggalLahir(String mTanggalLahir) {
        this.mTanggalLahir = mTanggalLahir;
    }

    public String getmKelamin() {
        return mKelamin;
    }

    public void setmKelamin(String mKelamin) {
        this.mKelamin = mKelamin;
    }

    public String getmAlamat() {
        return mAlamat;
    }

    public void setmAlamat(String mAlamat) {
        this.mAlamat = mAlamat;
    }

    public String getmGoldarah() {
        return mGoldarah;
    }

    public void setmGoldarah(String mGoldarah) {
        this.mGoldarah = mGoldarah;
    }

    public String getmAgama() {
        return mAgama;
    }

    public void setmAgama(String mAgama) {
        this.mAgama = mAgama;
    }

    public String getmStatus() {
        return mStatus;
    }

    public void setmStatus(String mStatus) {
        this.mStatus = mStatus;
    }

    public String getmPekerjaan() {
        return mPekerjaan;
    }

    public void setmPekerjaan(String mPekerjaan) {
        this.mPekerjaan = mPekerjaan;
    }

    public String getmKewarganegaraan() {
        return mKewarganegaraan;
    }

    public void setmKewarganegaraan(String mKewarganegaraan) {
        this.mKewarganegaraan = mKewarganegaraan;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }
}
