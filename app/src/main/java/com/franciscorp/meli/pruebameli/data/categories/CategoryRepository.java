package com.franciscorp.meli.pruebameli.data.categories;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.franciscorp.meli.pruebameli.data.MeliRoomDatabase;
import com.franciscorp.meli.pruebameli.data.MeliServices;
import com.franciscorp.meli.pruebameli.models.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryRepository implements ResponseCategoryInterface {

    private CategoryDao mCategoryDao;
    private LiveData<List<Category>> mAllCategories;

    public CategoryRepository(Application application) {
        MeliRoomDatabase db = MeliRoomDatabase.getDatabase(application);
        mCategoryDao = db.categoryDao();
        mAllCategories = mCategoryDao.getAlphabetizedCategories();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    public LiveData<List<Category>> getAllCategories(MutableLiveData<String> apiError, MutableLiveData<Boolean> isLoading) {

        getCategories(apiError, isLoading);
        // Returns a Flow object directly from the database.
        return mCategoryDao.getAlphabetizedCategories();
    }

    private void getCategories(MutableLiveData<String> apiError, MutableLiveData<Boolean> isLoading) {
        // Check if categories data was fetched recently.

        MeliRoomDatabase.databaseWriteExecutor.execute(() -> {
            boolean categoriesExists = mCategoryDao.getCategories() != null && !mCategoryDao.getCategories().isEmpty();
            if (!categoriesExists) {
                // Refreshes the data.
                refreshCategories(apiError, isLoading);
            }
        });

    }

    // call get categories services
    public void refreshCategories(MutableLiveData<String> apiError, MutableLiveData<Boolean> isLoading) {
        isLoading.postValue(true);
        MeliServices meliServices = new MeliServices();
        meliServices.getCategories(new ResponseCategoryInterface() {
            @Override
            public void responseCategoriesInterface(ArrayList<Category> categories) {
                // Updates the database. Since `categoryDao.load()` returns an object of
                // `Flow<Category>`, a new `category` object is emitted every time there's a
                // change in the `category`  table.

                for (Category category: categories) {
                    insert(category);
                }
                isLoading.postValue(false);
            }

            @Override
            public void errorService(String message) {
                // Check for errors here.
                apiError.postValue(message);
                isLoading.postValue(false);
            }
        });
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    public void insert(Category category) {
        MeliRoomDatabase.databaseWriteExecutor.execute(() -> {
            mCategoryDao.insert(category);
        });
    }

    @Override
    public void responseCategoriesInterface(ArrayList<Category> categories) {

    }

    @Override
    public void errorService(String message) {


    }
}
