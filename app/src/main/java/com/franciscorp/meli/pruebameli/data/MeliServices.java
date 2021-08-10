package com.franciscorp.meli.pruebameli.data;

import android.util.Log;

import androidx.annotation.NonNull;

import com.franciscorp.meli.pruebameli.models.Category;
import com.franciscorp.meli.pruebameli.data.categories.ResponseCategoryInterface;
import com.franciscorp.meli.pruebameli.data.search.ResponseSearchInterface;
import com.franciscorp.meli.pruebameli.models.search.ResponseSearchQuery;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MeliServices {

    private String TAG = MeliServices.class.getCanonicalName();


    public void getSearchQuery(final ResponseSearchInterface responseSearchInterface, @NonNull String text) {

        Retrofit retrofit = ManagerRetrofit.getRetrofit();

        WebServiceInterface webServiceInterface = retrofit.create(WebServiceInterface.class);

        Call<ResponseSearchQuery> searchQueryCall = webServiceInterface.getSearchQuery(text);
        searchQueryCall.enqueue(new Callback<ResponseSearchQuery>() {
            @Override
            public void onResponse(Call<ResponseSearchQuery> call, Response<ResponseSearchQuery> response) {
                int code = response.code();
                if (code == 200) {
                    try {
                        ResponseSearchQuery body = response.body();
                        responseSearchInterface.responseSearchInterface(body);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else {
                    try {
                        responseSearchInterface.errorService(String.valueOf(code));
                        Log.e(TAG, String.valueOf(code));
                    } catch (Exception e) {
                        if (e != null) {
                            Log.e(TAG, e.getLocalizedMessage());
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseSearchQuery> call, Throwable t) {
                if (t != null && t.getLocalizedMessage() != null) {
                    responseSearchInterface.errorService(t.getLocalizedMessage());
                    Log.e(TAG, t.getLocalizedMessage());
                }
            }
        });
    }

    public void getCategories(final ResponseCategoryInterface responseCategoryInterface) {

        Retrofit retrofit = ManagerRetrofit.getRetrofit();

        WebServiceInterface webServiceInterface = retrofit.create(WebServiceInterface.class);

        Call<ArrayList<Category>> categoriesCall = webServiceInterface.getCategories();
        categoriesCall.enqueue(new Callback<ArrayList<Category>>() {
            @Override
            public void onResponse(Call<ArrayList<Category>> call, Response<ArrayList<Category>> response) {
                int code = response.code();
                Log.i(TAG, call.request().url().toString() + " " + code);
                if (code == 200) {
                    ArrayList<Category> body = response.body();
                    responseCategoryInterface.responseCategoriesInterface(body);
                } else {
                    try {
                        responseCategoryInterface.errorService(String.valueOf(code));
                        Log.e(TAG, String.valueOf(code));
                    } catch (Exception e) {
                        if (e != null) {
                            Log.e(TAG, e.getLocalizedMessage());
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Category>> call, Throwable t) {
                if (t != null) {
                    responseCategoryInterface.errorService(t.getMessage());
                    Log.i(TAG, call.request().url().toString());
                    t.printStackTrace();
                }
            }
        });
    }
}
