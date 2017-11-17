package id.futnet.praktikumprogmob.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Wahyu Permadi on 11/7/2017.
 */

public class MemberResult {
    private int id;
    private String Nama;
    private String Email;
    private String Tinggi;
    private String Kelamin;
    private String Hobi;
    private String Picture;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTinggi() {
        return Tinggi;
    }

    public void setTinggi(String tinggi) {
        Tinggi = tinggi;
    }

    public String getKelamin() {
        return Kelamin;
    }

    public void setKelamin(String kelamin) {
        Kelamin = kelamin;
    }

    public String getHobi() {
        return Hobi;
    }

    public void setHobi(String hobi) {
        Hobi = hobi;
    }

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String picture) {
        Picture = picture;
    }
    }
