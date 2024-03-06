package com.corso.vetrina.dto;

import com.corso.vetrina.entity.ImageEntity;

import java.util.List;

public class ProdottoDto {


    private List<ImageEntity> blobImg;
    private String modello;
    private String descrizione;
    private double prezzo;

    public ProdottoDto(){

    }

    public List<ImageEntity> getBlobImg() {
        return blobImg;
    }

    public void setBlobImg(List<ImageEntity> blobImg) {
        this.blobImg = blobImg;
    }
    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
}
