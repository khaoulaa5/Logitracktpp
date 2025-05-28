package com.example.logitrackk.data.locall.dao;



import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.logitrackk.data.locall.Entity.ProduitEntity;

import java.util.List;

@Dao
public interface ProduitDao {
    @Insert
    void insert(ProduitEntity p);

    @Update
    void update(ProduitEntity p);

    @Delete
    void delete(ProduitEntity p);

    @Query("SELECT * FROM produit ORDER BY nom")
    LiveData<List<ProduitEntity>> getAll();
}
