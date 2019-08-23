package com.teknoglobal.kampus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mahasiswa")
public class Mahasiswa {
    private long id;
    private String nim;
    private String namaMahasiswa;
    private String jenisKelamin;
    private String alamat;

    public Mahasiswa(){

    }
    
    public Mahasiswa(String nim, String namaMahasiswa, String jenisKelamin, String alamat){
        this.nim = nim;
        this.namaMahasiswa = namaMahasiswa;
        this.jenisKelamin = jenisKelamin;
        this.alamat = alamat;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }

    @Column(name = "nim", nullable = false)
    public String getNim() {
        return nim;
    }
    public void setNim(String nim) {
        this.nim = nim;
    }

    @Column(name = "nama_mahasiswa", nullable = false)
    public String getNamaMahasiswa() {
        return namaMahasiswa;
    }
    public void setNamaMahasiswa(String namaMahasiswa) {
        this.namaMahasiswa = namaMahasiswa;
    }

    @Column(name = "jenis_kelamin", nullable = false)
    public String getJenisKelamin() {
        return jenisKelamin;
    }
    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    @Column(name = "alamat", nullable = false)
    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }


    @Override
    public String toString() {
        return "Mahasiswa [id=" + id +", nim=" + nim +", namaMahasiswa=" + namaMahasiswa +", jenisKelamin=" + jenisKelamin 
        +", alamat=" + alamat +"]";
    }
}