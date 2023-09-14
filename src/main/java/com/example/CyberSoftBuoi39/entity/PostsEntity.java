package com.example.CyberSoftBuoi39.entity;

import jakarta.persistence.*;

@Entity(name="Baiviet")
public class PostsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "tieude")
    private String tieude;

    @Column(name = "noidung")
    private String noidung;

    @Column(name = "id_Tacgia")
    private int idTacgia;

    @Column(name = "ngayviete")
    private String ngayviet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTieude() {
        return tieude;
    }

    public void setTieude(String tieude) {
        this.tieude = tieude;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public int getIdTacgia() {
        return idTacgia;
    }

    public void setIdTacgia(int idTacgia) {
        this.idTacgia = idTacgia;
    }

    public String getNgayviet() {
        return ngayviet;
    }

    public void setNgayviet(String ngayviet) {
        this.ngayviet = ngayviet;
    }
}
