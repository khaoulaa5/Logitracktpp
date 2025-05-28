package com.example.logitrackk.model;



import java.util.Date;

public class LivraisonDTO {
    private int id;
    private Date dateLivraison;
    private String statut;
    private int produitId;
    private int clientId;

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Date getDateLivraison() { return dateLivraison; }
    public void setDateLivraison(Date dateLivraison) { this.dateLivraison = dateLivraison; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }

    public int getProduitId() { return produitId; }
    public void setProduitId(int produitId) { this.produitId = produitId; }

    public int getClientId() { return clientId; }
    public void setClientId(int clientId) { this.clientId = clientId; }
}
