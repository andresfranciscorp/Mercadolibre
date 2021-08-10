package com.franciscorp.meli.pruebameli.ui.search.fragments;

import static com.franciscorp.meli.pruebameli.ui.search.SearchActivity.QUERY_KEY;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.franciscorp.meli.pruebameli.R;
import com.franciscorp.meli.pruebameli.common.bases.BaseFragment;
import com.franciscorp.meli.pruebameli.models.search.Result;
import com.franciscorp.meli.pruebameli.viewModels.SearchViewModel;
import com.franciscorp.meli.pruebameli.ui.search.adapters.ResultSelectedInterface;
import com.franciscorp.meli.pruebameli.ui.search.adapters.SearchListAdapter;

import java.util.List;

public class ListFragment extends BaseFragment implements ResultSelectedInterface {

    private static ListFragment fragment;
    private SearchViewModel mViewModel;
    private SwipeRefreshLayout swipeRefresh;
    private RecyclerView recyclerView;
    private SearchListAdapter mAdapter;
    private String mQuery;
    private LinearLayout emptyList;

    public static ListFragment getInstance() {
        if (fragment == null) {
            fragment = new ListFragment();
        }
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Bundle bundle = getArguments();
            if (bundle.containsKey(QUERY_KEY)) {
                mQuery = bundle.getString(QUERY_KEY);
            }
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        swipeRefresh = view.findViewById(R.id.swipe_refresh);
        recyclerView = view.findViewById(R.id.recyclerview);
        emptyList = view.findViewById(R.id.empty_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(getActivity()).get(SearchViewModel.class);

        mAdapter = new SearchListAdapter(new SearchListAdapter.CategoryDiff(), this);
        recyclerView.setAdapter(mAdapter);
        attachObserver();
    }

    private void attachObserver() {
        mViewModel.searQueryMutableLiveData(mQuery).observe(getActivity(), responseSearchQuery -> {
            boolean isEmpty = true;
            // Update the result in the adapter.
            if (responseSearchQuery != null) {
                List<Result> results = responseSearchQuery.getResults();
                if (results != null && !results.isEmpty()) {
                    isEmpty = false;
                    mAdapter.submitList(results);
                }
            }
            if (isEmpty) {
                showEmptyList();
            }
        });
        mViewModel.getApiError().observe(getActivity(), message -> {
            showEmptyList();
        });
        mViewModel.getIsLoading().observe(getActivity(), isLoading -> {
            if (!isLoading) {
                if (swipeRefresh.isRefreshing()) {
                    swipeRefresh.setRefreshing(false);
                }
            }
        });
        swipeRefresh.setOnRefreshListener(
                () -> mViewModel.searQuery(mQuery)
        );
    }

    private void showEmptyList() {
        emptyList.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void selected(Result result) {
        mViewModel.select(result);
        navigateToFragment(DetailFragment.getInstance());
    }
}