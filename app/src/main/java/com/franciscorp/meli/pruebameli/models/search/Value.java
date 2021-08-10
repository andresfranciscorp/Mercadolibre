
package com.franciscorp.meli.pruebameli.models.search;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Value implements Parcelable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("struct")
    @Expose
    private Struct struct;
    @SerializedName("source")
    @Expose
    private Double source;


    protected Value(Parcel in) {
        id = in.readString();
        name = in.readString();
        struct = in.readParcelable(Struct.class.getClassLoader());
        if (in.readByte() == 0) {
            source = null;
        } else {
            source = in.readDouble();
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeParcelable(struct, flags);
        if (source == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(source);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Value> CREATOR = new Creator<Value>() {
        @Override
        public Value createFromParcel(Parcel in) {
            return new Value(in);
        }

        @Override
        public Value[] newArray(int size) {
            return new Value[size];
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

    public Struct getStruct() {
        return struct;
    }

    public void setStruct(Struct struct) {
        this.struct = struct;
    }

    public Double getSource() {
        return source;
    }

    public void setSource(Double source) {
        this.source = source;
    }

}
