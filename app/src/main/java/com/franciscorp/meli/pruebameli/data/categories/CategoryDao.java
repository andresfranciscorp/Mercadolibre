package com.franciscorp.meli.pruebameli.data.categories;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.franciscorp.meli.pruebameli.models.Category;

import java.util.List;
@Dao
public interface CategoryDao {
    // allowing the insert of the same category multiple times by passing a
    // conflict resolution strategy
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Category category);

    @Query("DELETE FROM categories")
    void deleteAll();

    @Query("SELECT * FROM categories ORDER BY name ASC")
    LiveData<List<Category>> getAlphabetizedCategories();

    @Query("SELECT * FROM categories")
    List<Category> getCategories();

//    @Query("SELECT * FROM categories WHERE lastRefresh > :lastRefreshMax LIMIT 1")
//    Category hasCategory(Date lastRefreshMax);
}
