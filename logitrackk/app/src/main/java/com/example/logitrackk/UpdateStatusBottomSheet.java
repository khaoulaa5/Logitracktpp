package com.example.logitrackk;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class UpdateStatusBottomSheet extends BottomSheetDialogFragment {

    private static final String ARG_ID = "livraison_id";
    private LivraisonViewModel viewModel;
    private int livraisonId;

    public static UpdateStatusBottomSheet newInstance(int id) {
        UpdateStatusBottomSheet sheet = new UpdateStatusBottomSheet();
        Bundle args = new Bundle();
        args.putInt(ARG_ID, id);
        sheet.setArguments(args);
        return sheet;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        livraisonId = getArguments().getInt(ARG_ID);
        viewModel = new ViewModelProvider(requireActivity()).get(LivraisonViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_update_status, container, false);
        view.findViewById(R.id.btnEnAttente).setOnClickListener(v -> update("En attente"));
        view.findViewById(R.id.btnLivre).setOnClickListener(v -> update("Livré"));
        return view;
    }

    private void update(String statut) {

        dismiss();
    }
}
