package com.example.logitrackk;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.logitrackk.LivraisonViewModel;
import com.example.logitrackk.adapter.LivraisonAdapter;
import com.example.logitrackk.data.locall.Entity.LivraisonEntity;
import com.example.logitrackk.AddDeliveryActivity;
import com.example.logitrackk.UpdateStatusBottomSheet;


public class MainActivity extends AppCompatActivity {



        private LivraisonViewModel viewModel;
        private LivraisonAdapter adapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            viewModel = new ViewModelProvider(this).get(LivraisonViewModel.class);

            SwipeRefreshLayout swipe = findViewById(R.id.swipeRefresh);
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            FloatingActionButton fab = findViewById(R.id.fabAdd);

            adapter = new LivraisonAdapter(this::showBottomSheet);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            swipe.setOnRefreshListener(() -> {
                viewModel.refresh();
                swipe.setRefreshing(false);
            });

            viewModel.livraisons.observe(this, adapter::submitList);

            fab.setOnClickListener(v -> {
                startActivity(new Intent(this, AddDeliveryActivity.class));
            });
        }

        private void showBottomSheet(LivraisonEntity livraison) {
            UpdateStatusBottomSheet sheet = UpdateStatusBottomSheet.newInstance(livraison.getId());
            sheet.show(getSupportFragmentManager(), "updateSheet");
        }
    }
