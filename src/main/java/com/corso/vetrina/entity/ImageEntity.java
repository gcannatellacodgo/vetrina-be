package com.corso.vetrina.entity;

import jakarta.persistence.*;

@Entity
public class ImageEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    byte[] image;


    public ImageEntity(byte[] image) {
        this.image = image;
    }
    public ImageEntity(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
