package com.franciscorp.meli.pruebameli.data.categories;


import com.franciscorp.meli.pruebameli.data.BaseResponseInterface;
import com.franciscorp.meli.pruebameli.models.Category;

import java.util.ArrayList;

public interface ResponseCategoryInterface extends BaseResponseInterface {

    /**
     * Notify when retrieve categories
     */
    void responseCategoriesInterface(ArrayList<Category> categories);

}