package com.corso.vetrina.entity;

import jakarta.persistence.*;
import org.hibernate.metamodel.mapping.internal.ImmutableAttributeMappingList;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

@Entity
@Table(name="prodotto")
public class Prodotto {


    @OneToMany(cascade = CascadeType.ALL)
    private List<ImageEntity> blobImg;
    private String titolo;
    @Id
    private String modello;
    private String codice;
    private String descrizione;
    private double prezzo;



    public Prodotto() {

    }


    public List<ImageEntity> getBlobImg() {
        return blobImg;
    }

    public void setBlobImg(List<ImageEntity> blobImg) {
        this.blobImg = blobImg;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
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
