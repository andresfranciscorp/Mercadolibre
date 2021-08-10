package com.franciscorp.meli.pruebameli.viewModels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.franciscorp.meli.pruebameli.data.search.SearchRepository;
import com.franciscorp.meli.pruebameli.models.search.ResponseSearchQuery;
import com.franciscorp.meli.pruebameli.models.search.Result;

public class SearchViewModel extends AndroidViewModel {

    private String mQuery;

    private SearchRepository mRepository;

    private MutableLiveData<ResponseSearchQuery> responseMutableLiveData = new MutableLiveData<>();

    private final MutableLiveData<Result> selected = new MutableLiveData<Result>();

    private MutableLiveData<Boolean> isLoading = new MutableLiveData<>();

    private MutableLiveData<String> apiError = new MutableLiveData<>();

    public SearchViewModel(Application application) {
        super(application);
        mRepository = new SearchRepository(responseMutableLiveData, apiError, isLoading);
    }

    public MutableLiveData<ResponseSearchQuery> searQueryMutableLiveData(String query) {
        if (mQuery == null ||( mQuery != null && !mQuery.equals(query))){
            mQuery = query;
            searQuery(query);
        }
        return responseMutableLiveData;
    }
    public void searQuery(String query) {
            mRepository.getSearchQuery(query);
    }

    public MutableLiveData<Boolean> getIsLoading() {
        return isLoading;
    }

    public MutableLiveData<String> getApiError() {
        return apiError;
    }

    public void select(Result item) {
        selected.setValue(item);
    }

    public LiveData<Result> getSelected() {
        return selected;
    }
}
