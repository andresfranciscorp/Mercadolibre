
package com.franciscorp.meli.pruebameli.models.search;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ValueFilter implements Parcelable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("path_from_root")
    @Expose
    private List<PathFromRoot> pathFromRoot = null;

    protected ValueFilter(Parcel in) {
        id = in.readString();
        name = in.readString();
        pathFromRoot = in.createTypedArrayList(PathFromRoot.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeTypedList(pathFromRoot);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ValueFilter> CREATOR = new Creator<ValueFilter>() {
        @Override
        public ValueFilter createFromParcel(Parcel in) {
            return new ValueFilter(in);
        }

        @Override
        public ValueFilter[] newArray(int size) {
            return new ValueFilter[size];
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

    public List<PathFromRoot> getPathFromRoot() {
        return pathFromRoot;
    }

    public void setPathFromRoot(List<PathFromRoot> pathFromRoot) {
        this.pathFromRoot = pathFromRoot;
    }

}
