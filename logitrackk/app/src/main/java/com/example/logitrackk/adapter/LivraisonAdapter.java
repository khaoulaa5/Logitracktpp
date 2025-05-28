package com.example.logitrackk.adapter;

import com.example.logitrackk.data.locall.Entity.LivraisonEntity;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.logitrackk.R;
import com.example.logitrackk.data.locall.Entity.LivraisonEntity;

public class LivraisonAdapter extends ListAdapter<LivraisonEntity, LivraisonAdapter.ViewHolder> {

    public interface OnItemClick {
        void onClick(LivraisonEntity entity);
    }

    private final OnItemClick listener;

    public LivraisonAdapter(OnItemClick listener) {
        super(DIFF_CALLBACK);
        this.listener = listener;
    }

    private static final DiffUtil.ItemCallback<LivraisonEntity> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<LivraisonEntity>() {
                @Override
                public boolean areItemsTheSame(@NonNull LivraisonEntity oldItem, @NonNull LivraisonEntity newItem) {
                    return oldItem.getId() == newItem.getId();
                }

                @Override
                public boolean areContentsTheSame(@NonNull LivraisonEntity oldItem, @NonNull LivraisonEntity newItem) {
                    return oldItem.getStatut().equals(newItem.getStatut()) &&
                            oldItem.getDateLivraison().equals(newItem.getDateLivraison());
                }
            };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_livraison, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LivraisonEntity livraison = getItem(position);
        holder.bind(livraison);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textDate, textStatut;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textDate = itemView.findViewById(R.id.textDate);
            textStatut = itemView.findViewById(R.id.textStatut);
        }

        public void bind(LivraisonEntity livraison) {
            textDate.setText(livraison.getDateLivraison().toString());
            textStatut.setText(livraison.getStatut());
            itemView.setOnClickListener(v -> listener.onClick(livraison));
        }
    }
}
