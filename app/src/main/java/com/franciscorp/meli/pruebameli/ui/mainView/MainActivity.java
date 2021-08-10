package com.franciscorp.meli.pruebameli.ui.mainView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.franciscorp.meli.pruebameli.R;
import com.franciscorp.meli.pruebameli.common.bases.BaseActivity;
import com.franciscorp.meli.pruebameli.ui.mainView.adapters.CategoryListAdapter;
import com.franciscorp.meli.pruebameli.ui.search.SearchActivity;
import com.franciscorp.meli.pruebameli.viewModels.CategoryViewModel;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends BaseActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private EditText search;
    private SwipeRefreshLayout swipeRefresh;
    private RecyclerView recyclerView;
    private ImageView icnSearch;

    private CategoryViewModel mCategoryViewModel;
    private CategoryListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search = findViewById(R.id.search);
        swipeRefresh = findViewById(R.id.swipe_refresh);
        recyclerView = findViewById(R.id.recyclerview);
        icnSearch = findViewById(R.id.icn_search);

        mCategoryViewModel = new ViewModelProvider(this).get(CategoryViewModel.class);

        mAdapter = new CategoryListAdapter(new CategoryListAdapter.CategoryDiff());
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        attachObservers();
    }

    @Override
    protected int getIdRootFragmentContainer() {
        return R.id.main_view;
    }

    private void attachObservers() {
        mCategoryViewModel.getAllCategories().observe(this, categories -> {
            // Update the categories in the adapter.
            mAdapter.submitList(categories);
        });

        mCategoryViewModel.getIsLoading().observe(this, isLoading -> {
            if (isLoading) {
                mManagerProgressDialog.showProgress();
            } else {
                mManagerProgressDialog.dismissProgress();
                if (swipeRefresh.isRefreshing()) {
                    swipeRefresh.setRefreshing(false);
                }
            }
        });

        mCategoryViewModel.getApiError().observe(this, message -> {
            Snackbar.make(recyclerView, message, Snackbar.LENGTH_SHORT).show();
        });

        TextView.OnEditorActionListener onEditorActionListener = (view, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                searchQuery(view.getText().toString());
                hideKeyboard();
                return true;
            }
            return false;
        };
        search.setOnEditorActionListener(onEditorActionListener);

        swipeRefresh.setOnRefreshListener(
                () -> mCategoryViewModel.refreshCategories()
        );
        icnSearch.setOnClickListener(view -> searchQuery(search.getText().toString()));
    }

    private void searchQuery(String query) {

        if (validateFields()){
            Intent intent = new Intent(this, SearchActivity.class);
            intent.putExtra(SearchActivity.QUERY_KEY, query);
            startActivity(intent);
        }
    }

    public boolean validateFields() {
        boolean cancel = false;
        View focusView = null;

        // Reset errors.
        search.setError(null);

        String searchString = search.getText().toString();

        if (TextUtils.isEmpty(searchString)) {
            search.setError(getString(R.string.error_field_required));
            focusView = search;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        }
        return !cancel;
    }
}