package com.franciscorp.meli.pruebameli.viewModels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.franciscorp.meli.pruebameli.models.Category;
import com.franciscorp.meli.pruebameli.data.categories.CategoryRepository;

import java.util.List;

public class CategoryViewModel extends AndroidViewModel {

    private CategoryRepository mRepository;

    private LiveData<List<Category>> mAllCategories;

    private MutableLiveData<Boolean> isLoading = new MutableLiveData<>();

    private MutableLiveData<String> apiError = new MutableLiveData<>();

    public CategoryViewModel(Application application) {
        super(application);
        mRepository = new CategoryRepository(application);
    }

    public LiveData<List<Category>> getAllCategories() {
        if (mAllCategories == null) {
            mAllCategories = mRepository.getAllCategories(apiError, isLoading);
        }
        return mAllCategories;
    }

    public void refreshCategories() {
        mRepository.refreshCategories(apiError, isLoading);
    }

    public void insert(Category category) { mRepository.insert(category); }

    public MutableLiveData<Boolean> getIsLoading() {
        return isLoading;
    }

    public MutableLiveData<String> getApiError() {
        return apiError;
    }
}
