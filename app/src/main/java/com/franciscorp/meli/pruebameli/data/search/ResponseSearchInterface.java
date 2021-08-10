package com.franciscorp.meli.pruebameli.data.search;

import com.franciscorp.meli.pruebameli.data.BaseResponseInterface;
import com.franciscorp.meli.pruebameli.models.search.ResponseSearchQuery;

public interface ResponseSearchInterface extends BaseResponseInterface {
    /**
     * Notify when retrieve mainView
     */
    void responseSearchInterface(ResponseSearchQuery responseSearchQuery);

}