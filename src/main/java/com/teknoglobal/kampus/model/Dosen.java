package com.teknoglobal.kampus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dosen")
public class Dosen {
    private long id;
    private String nid;
    private String namaDosen;
    private String jenisKelamin;
    private String mataKuliah;

    public Dosen (){

    }

    public Dosen(String nid, String namaDosen, String jenisKelamin, String mataKuliah){
        this.nid = nid;
        this.namaDosen = namaDosen;
        this.jenisKelamin = jenisKelamin;
        this.mataKuliah = mataKuliah;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }

    @Column(name = "nid", nullable = false)
    public String getNid(){
        return nid;
    }
    public void setNid(String nid){
        this.nid = nid;
    }

    @Column(name = "nama_dosen", nullable = false)
    public String getNamaDosen(){
        return namaDosen;
    }
    public void setNamaDosen(String namaDosen){
        this.namaDosen = namaDosen;
    }

    @Column(name = "jenis_kelamin", nullable = false)
    public String getJenisKelamin(){
        return jenisKelamin;
    }
    public void setJenisKelamin(String jenisKelamin){
        this.jenisKelamin = jenisKelamin;
    }

    @Column(name = "mata_kuliah", nullable = false)
    public String getMataKuliah(){
        return mataKuliah;
    }
    public void setMataKuliah(String mataKuliah){
        this.mataKuliah = mataKuliah;
    }


    @Override
    public String toString(){
        return "Dosen [id=" + id + ", nid=" + nid + ", namaDosen=" + namaDosen + ", jenisKelamin=" 
        + jenisKelamin + ", mataKuliah=" + mataKuliah + "]";
    }
}
