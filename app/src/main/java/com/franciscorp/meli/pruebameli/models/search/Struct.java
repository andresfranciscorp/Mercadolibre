
package com.franciscorp.meli.pruebameli.models.search;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Struct implements Parcelable {

    @SerializedName("number")
    @Expose
    private Double number;
    @SerializedName("unit")
    @Expose
    private String unit;

    protected Struct(Parcel in) {
        if (in.readByte() == 0) {
            number = null;
        } else {
            number = in.readDouble();
        }
        unit = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (number == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(number);
        }
        dest.writeString(unit);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Struct> CREATOR = new Creator<Struct>() {
        @Override
        public Struct createFromParcel(Parcel in) {
            return new Struct(in);
        }

        @Override
        public Struct[] newArray(int size) {
            return new Struct[size];
        }
    };

    public Double getNumber() {
        return number;
    }

    public void setNumber(Double number) {
        this.number = number;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}
