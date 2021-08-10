package com.franciscorp.meli.pruebameli.ui.search.adapters;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.franciscorp.meli.pruebameli.R;
import com.franciscorp.meli.pruebameli.models.search.Result;
import com.squareup.picasso.Picasso;

public class SearchListAdapter extends ListAdapter<Result, SearchViewHolder> {

    private ResultSelectedInterface resultSelectedInterface;

    public SearchListAdapter(@NonNull DiffUtil.ItemCallback<Result> diffCallback, ResultSelectedInterface resultSelectedInterface) {
        super(diffCallback);
        this.resultSelectedInterface = resultSelectedInterface;
    }

    @Override
    public SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return SearchViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(SearchViewHolder holder, int position) {
        Result current = getItem(position);
        holder.bind(current.getTitle());
        Picasso.get().load(current.getThumbnail()).placeholder(R.drawable.placeholder).into(holder.imageItem);

        holder.view.setOnClickListener(view -> {
            resultSelectedInterface.selected(current);
        });
    }

    public static class CategoryDiff extends DiffUtil.ItemCallback<Result> {

        @Override
        public boolean areItemsTheSame(@NonNull Result oldItem, @NonNull Result newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Result oldItem, @NonNull Result newItem) {
            return oldItem.getTitle().equals(newItem.getTitle());
        }
    }
}