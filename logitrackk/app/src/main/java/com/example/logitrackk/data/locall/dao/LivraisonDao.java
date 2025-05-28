package com.example.logitrackk.data.locall.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.logitrackk.data.locall.Entity.LivraisonEntity;

import java.util.Date;
import java.util.List;

@Dao
public interface LivraisonDao {
    @Insert
    void insert(LivraisonEntity l);

    @Query("DELETE FROM livraison WHERE id = :id")
    void deleteById(int id);

    @Query("UPDATE livraison SET statut = :s WHERE id = :id")
    void updateStatut(int id, String s);

    @Query("SELECT * FROM livraison ORDER BY dateLivraison DESC")
    LiveData<List<LivraisonEntity>> getAll();

    @Query("SELECT COUNT(*) FROM livraison WHERE dateLivraison = :d AND produitId = :p AND clientId = :c")
    int exists(Date d, int p, int c);
}
