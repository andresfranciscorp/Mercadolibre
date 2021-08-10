package com.franciscorp.meli.pruebameli.ui.search;

import android.os.Bundle;
import android.view.ViewGroup;

import androidx.lifecycle.ViewModelProvider;

import com.franciscorp.meli.pruebameli.R;
import com.franciscorp.meli.pruebameli.common.bases.BaseActivity;
import com.franciscorp.meli.pruebameli.common.bases.BaseFragment;
import com.franciscorp.meli.pruebameli.ui.search.fragments.ListFragment;
import com.franciscorp.meli.pruebameli.viewModels.SearchViewModel;
import com.google.android.material.snackbar.Snackbar;

public class SearchActivity extends BaseActivity {

    public static String QUERY_KEY = "query";

    private SearchViewModel mSearchViewModel;
    private ViewGroup mainView;
    private String mQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        activityHasContent = false;
        mainView = findViewById(R.id.main_view);
        mSearchViewModel = new ViewModelProvider(this).get(SearchViewModel.class);

        BaseFragment fragment = ListFragment.getInstance();

        Bundle bundle = getIntent().getExtras();
        if (bundle.containsKey(QUERY_KEY)) {
            mQuery = bundle.getString(QUERY_KEY);
            Bundle bundleFragment = fragment.getArguments();
            bundleFragment.putString(QUERY_KEY, mQuery);
        }
        if (getTopFragment() == null) {
            navigateToFragment(fragment);
        }
        attachObserver();
    }

    private void attachObserver() {
        mSearchViewModel.searQueryMutableLiveData(mQuery);

        mSearchViewModel.getIsLoading().observe(this, isLoading -> {
            if (isLoading) {
                mManagerProgressDialog.showProgress();
            } else {
                mManagerProgressDialog.dismissProgress();
            }
        });

        mSearchViewModel.getApiError().observe(this, message -> {
            Snackbar.make(mainView, message, Snackbar.LENGTH_SHORT).show();
        });
    }

    @Override
    protected int getIdRootFragmentContainer() {
        return R.id.main_view;
    }
}