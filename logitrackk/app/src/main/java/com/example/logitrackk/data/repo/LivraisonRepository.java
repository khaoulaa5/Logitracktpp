package com.example.logitrackk.data.repo;



import androidx.lifecycle.LiveData;

import com.example.logitrackk.data.locall.dao.LivraisonDao;
import com.example.logitrackk.data.locall.Entity.LivraisonEntity;
import com.example.logitrackk.model.LivraisonDTO;
import com.example.logitrackk.network.ApiService;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LivraisonRepository {

    private final LivraisonDao dao;
    private final ApiService api;
    private final Executor io = Executors.newSingleThreadExecutor();

    public LivraisonRepository(LivraisonDao d, ApiService a) {
        dao = d;
        api = a;
    }

    public LiveData<List<LivraisonEntity>> getLocal() {
        return dao.getAll();
    }

    public void add(LivraisonEntity l) {
        io.execute(() -> {
            if (dao.exists(l.getDateLivraison(), l.getProduitId(), l.getClientId()) == 0) {
                dao.insert(l);
            }
        });
    }

    public void sync() {
        api.getLivraisons().enqueue(new Callback<List<LivraisonDTO>>() {
            @Override
            public void onResponse(Call<List<LivraisonDTO>> call, Response<List<LivraisonDTO>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    io.execute(() -> {
                        for (LivraisonDTO dto : response.body()) {
                            dao.insert(map(dto));
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<List<LivraisonDTO>> call, Throwable t) {
                // Log error or handle failure
            }
        });
    }

    private LivraisonEntity map(LivraisonDTO dto) {
        LivraisonEntity e = new LivraisonEntity();
        e.setId(dto.getId());
        e.setDateLivraison(dto.getDateLivraison());
        e.setStatut(dto.getStatut());
        e.setProduitId(dto.getProduitId());
        e.setClientId(dto.getClientId());
        return e;
    }
}
