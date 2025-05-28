package com.example.logitrackk.data.locall.Entity;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "client")
public class ClientEntity {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    private String nom;

    private String adresse;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    @NonNull
    public String getNom() { return nom; }
    public void setNom(@NonNull String nom) { this.nom = nom; }

    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
}
