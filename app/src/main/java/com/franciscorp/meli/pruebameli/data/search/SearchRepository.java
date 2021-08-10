package com.franciscorp.meli.pruebameli.data.search;

import androidx.lifecycle.MutableLiveData;

import com.franciscorp.meli.pruebameli.data.MeliServices;
import com.franciscorp.meli.pruebameli.models.search.ResponseSearchQuery;

public class SearchRepository {

    private MutableLiveData<ResponseSearchQuery> responseMutableLiveData;
    private MutableLiveData<String> apiError;
    private MutableLiveData<Boolean> isLoading;

    public SearchRepository(MutableLiveData<ResponseSearchQuery> responseMutableLiveData, MutableLiveData<String> apiError, MutableLiveData<Boolean> isLoading) {
        this.responseMutableLiveData = responseMutableLiveData;
        this.apiError = apiError;
        this.isLoading = isLoading;
    }

    // call get search query service
    // Observed LiveData will notify the observer when the data has changed.
    public void getSearchQuery(String query) {
        isLoading.postValue(true);
        MeliServices meliServices = new MeliServices();
        meliServices.getSearchQuery(new ResponseSearchInterface() {
            @Override
            public void responseSearchInterface(ResponseSearchQuery responseSearchQuery) {
                responseMutableLiveData.setValue(responseSearchQuery);
                isLoading.postValue(false);
            }

            @Override
            public void errorService(String message) {
                // Check for errors here.
                apiError.postValue(message);
                isLoading.postValue(false);
            }
        }, query);
    }
}
