package com.example.logitrackk.network;



import com.example.logitrackk.model.LivraisonDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("livraisons")
    Call<List<LivraisonDTO>> getLivraisons();
}
