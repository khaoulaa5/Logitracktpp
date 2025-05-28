package com.example.logitrackk;

import android.os.Bundle;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.logitrackk.data.locall.Entity.LivraisonEntity;
import com.google.android.material.datepicker.MaterialDatePicker;

import java.util.Date;

public class   AddDeliveryActivity extends AppCompatActivity {

    private LivraisonViewModel viewModel;
    private Date selectedDate;
    private int selectedProduitId, selectedClientId;
    private String selectedStatut = "En attente";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_delivery);

        viewModel = new ViewModelProvider(this).get(LivraisonViewModel.class);

        // TODO: Setup AutoCompleteTextViews from local DB

        MaterialDatePicker<Long> datePicker = MaterialDatePicker.Builder.datePicker().build();
        findViewById(R.id.selectDate).setOnClickListener(v -> datePicker.show(getSupportFragmentManager(), "datePicker"));
        datePicker.addOnPositiveButtonClickListener(selection -> {
            selectedDate = new Date(selection);
            // display selected date
        });

        RadioGroup statusGroup = findViewById(R.id.statusGroup);
        statusGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.radioEnAttente) selectedStatut = "En attente";
            else if (checkedId == R.id.radioLivre) selectedStatut = "Livré";
        });

        findViewById(R.id.btnAdd).setOnClickListener(v -> {
            LivraisonEntity l = new LivraisonEntity();
            l.setClientId(selectedClientId);
            l.setProduitId(selectedProduitId);
            l.setDateLivraison(selectedDate);
            l.setStatut(selectedStatut);
            viewModel.add(l);
            finish();
        });
    }
}
