
package com.franciscorp.meli.pruebameli.models.search;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AvailableFilter implements Parcelable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("values")
    @Expose
    private List<ValueAvailableFilter> values = null;

    protected AvailableFilter(Parcel in) {
        id = in.readString();
        name = in.readString();
        type = in.readString();
        values = in.createTypedArrayList(ValueAvailableFilter.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(type);
        dest.writeTypedList(values);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AvailableFilter> CREATOR = new Creator<AvailableFilter>() {
        @Override
        public AvailableFilter createFromParcel(Parcel in) {
            return new AvailableFilter(in);
        }

        @Override
        public AvailableFilter[] newArray(int size) {
            return new AvailableFilter[size];
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ValueAvailableFilter> getValues() {
        return values;
    }

    public void setValues(List<ValueAvailableFilter> values) {
        this.values = values;
    }

}
