package com.franciscorp.meli.pruebameli.data;

import com.franciscorp.meli.pruebameli.models.Category;
import com.franciscorp.meli.pruebameli.models.search.ResponseSearchQuery;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WebServiceInterface {

    @GET("search")
    Call<ResponseSearchQuery> getSearchQuery(
            @Query("q") String text);

    @GET("categories")
    Call<ArrayList<Category>> getCategories();

}