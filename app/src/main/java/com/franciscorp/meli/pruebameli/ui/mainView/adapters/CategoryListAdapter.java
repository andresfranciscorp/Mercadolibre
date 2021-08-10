package com.franciscorp.meli.pruebameli.ui.mainView.adapters;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.franciscorp.meli.pruebameli.models.Category;

public class CategoryListAdapter  extends ListAdapter<Category, CategoryViewHolder> {

    public CategoryListAdapter(@NonNull DiffUtil.ItemCallback<Category> diffCallback) {
        super(diffCallback);
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return CategoryViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        Category current = getItem(position);
        holder.bind(current.getName());
    }

    public static class CategoryDiff extends DiffUtil.ItemCallback<Category> {

        @Override
        public boolean areItemsTheSame(@NonNull Category oldItem, @NonNull Category newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Category oldItem, @NonNull Category newItem) {
            return oldItem.getName().equals(newItem.getName());
        }
    }
}