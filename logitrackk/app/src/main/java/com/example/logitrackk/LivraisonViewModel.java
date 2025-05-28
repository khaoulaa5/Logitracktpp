package com.example.logitrackk;



import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.logitrackk.data.locall.database.AppDatabase;
import com.example.logitrackk.data.locall.Entity.LivraisonEntity;
import com.example.logitrackk.data.repo.LivraisonRepository;
import com.example.logitrackk.network.NetworkModule;

import java.util.List;

public class LivraisonViewModel extends AndroidViewModel {

    private final LivraisonRepository repo;
    public final LiveData<List<LivraisonEntity>> livraisons;

    public LivraisonViewModel(@NonNull Application app) {
        super(app);
        AppDatabase db = AppDatabase.get(app);
        repo = new LivraisonRepository(db.livraisonDao(), NetworkModule.api());
        livraisons = repo.getLocal();
    }

    public void refresh() {
        repo.sync();
    }

    public void add(LivraisonEntity l) {
        repo.add(l);
    }
}
