package com.example.logitrackk.data.locall.Entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "produit")
public class ProduitEntity {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    private String nom;

    private double prix;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    @NonNull
    public String getNom() { return nom; }
    public void setNom(@NonNull String nom) { this.nom = nom; }

    public double getPrix() { return prix; }
    public void setPrix(double prix) { this.prix = prix; }
}
