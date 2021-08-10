package com.franciscorp.meli.pruebameli.ui.mainView.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.franciscorp.meli.pruebameli.R;

public class CategoryViewHolder extends RecyclerView.ViewHolder {
    private final TextView categoryItemView;

    private CategoryViewHolder(View itemView) {
        super(itemView);
        categoryItemView = itemView.findViewById(R.id.textView);
    }

    public void bind(String text) {
        categoryItemView.setText(text);
    }

    static CategoryViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_category, parent, false);
        return new CategoryViewHolder(view);
    }
}