package com.franciscorp.meli.pruebameli.ui.search.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.franciscorp.meli.pruebameli.R;

public class SearchViewHolder extends RecyclerView.ViewHolder {
    private final TextView categoryItemView;
    public final ImageView imageItem;
    public View view;

    private SearchViewHolder(View itemView) {
        super(itemView);
        this.view = itemView;
        categoryItemView = itemView.findViewById(R.id.textView);
        imageItem = itemView.findViewById(R.id.image_view);
    }

    public void bind(String text) {
        categoryItemView.setText(text);
    }

    static SearchViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_search, parent, false);
        return new SearchViewHolder(view);
    }
}