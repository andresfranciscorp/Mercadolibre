
package com.franciscorp.meli.pruebameli.models.search;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ValueAvailableFilter implements Parcelable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("results")
    @Expose
    private Integer results;

    protected ValueAvailableFilter(Parcel in) {
        id = in.readString();
        name = in.readString();
        if (in.readByte() == 0) {
            results = null;
        } else {
            results = in.readInt();
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        if (results == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(results);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ValueAvailableFilter> CREATOR = new Creator<ValueAvailableFilter>() {
        @Override
        public ValueAvailableFilter createFromParcel(Parcel in) {
            return new ValueAvailableFilter(in);
        }

        @Override
        public ValueAvailableFilter[] newArray(int size) {
            return new ValueAvailableFilter[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getResults() {
        return results;
    }

    public void setResults(Integer results) {
        this.results = results;
    }

}
