package com.franciscorp.meli.pruebameli.ui.search.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.franciscorp.meli.pruebameli.R;
import com.franciscorp.meli.pruebameli.common.bases.BaseFragment;
import com.franciscorp.meli.pruebameli.viewModels.SearchViewModel;
import com.squareup.picasso.Picasso;

public class DetailFragment extends BaseFragment {

    private static final String TAG = DetailFragment.class.getSimpleName();
    private static DetailFragment fragment;
    private SearchViewModel mViewModel;
    private TextView title;
    private TextView price;
    private ImageView imageView;

    public static DetailFragment getInstance() {
        if (fragment == null){
            fragment = new DetailFragment();
        }
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.detail_fragment, container, false);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(getActivity()).get(SearchViewModel.class);
        title = view.findViewById(R.id.title);
        imageView = view.findViewById(R.id.image_view);
        price = view.findViewById(R.id.price);

        mViewModel.getSelected().observe(getViewLifecycleOwner(), item -> {
            title.setText(item.getTitle());
            Picasso.get().load(item.getThumbnail()).placeholder(R.drawable.placeholder).into(imageView);
            price.setText("$" + item.getPrice() +" " + item.getCurrencyId());
        });
    }
}