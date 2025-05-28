package com.example.logitrackk.data.locall.Entity;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Date;

import static androidx.room.ForeignKey.CASCADE;

@Entity(
        tableName = "livraison",
        foreignKeys = {
                @ForeignKey(entity = ProduitEntity.class, parentColumns = "id", childColumns = "produitId", onDelete = CASCADE),
                @ForeignKey(entity = ClientEntity.class, parentColumns = "id", childColumns = "clientId", onDelete = CASCADE)
        },
        indices = {@Index("produitId"), @Index("clientId")}
)
public class LivraisonEntity {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    private Date dateLivraison;

    @NonNull
    private String statut;

    private int produitId;
    private int clientId;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    @NonNull
    public Date getDateLivraison() { return dateLivraison; }
    public void setDateLivraison(@NonNull Date dateLivraison) { this.dateLivraison = dateLivraison; }

    @NonNull
    public String getStatut() { return statut; }
    public void setStatut(@NonNull String statut) { this.statut = statut; }

    public int getProduitId() { return produitId; }
    public void setProduitId(int produitId) { this.produitId = produitId; }

    public int getClientId() { return clientId; }
    public void setClientId(int clientId) { this.clientId = clientId; }
}
