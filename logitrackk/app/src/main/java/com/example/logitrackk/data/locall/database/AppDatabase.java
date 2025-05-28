package com.example.logitrackk.data.locall.database;



import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.logitrackk.data.locall.converters.Converter;
import com.example.logitrackk.data.locall.dao.ProduitDao;
import com.example.logitrackk.data.locall.dao.LivraisonDao;
import com.example.logitrackk.data.locall.Entity.ClientEntity;
import com.example.logitrackk.data.locall.Entity.LivraisonEntity;
import com.example.logitrackk.data.locall.Entity.ProduitEntity;

@Database(
        entities = {ProduitEntity.class, ClientEntity.class, LivraisonEntity.class},
        version = 1
)
@TypeConverters({Converter.class})
public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase INSTANCE;

    public abstract ProduitDao produitDao();
    public abstract LivraisonDao livraisonDao();

    public static AppDatabase get(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class,
                            "logistique.db"
                    ).build();
                }
            }
        }
        return INSTANCE;
    }
}
