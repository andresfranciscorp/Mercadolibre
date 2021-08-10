
package com.franciscorp.meli.pruebameli.models.search;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ValueStruct implements Parcelable {

    @SerializedName("number")
    @Expose
    private Double number;
    @SerializedName("unit")
    @Expose
    private String unit;

    protected ValueStruct(Parcel in) {
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

    public static final Creator<ValueStruct> CREATOR = new Creator<ValueStruct>() {
        @Override
        public ValueStruct createFromParcel(Parcel in) {
            return new ValueStruct(in);
        }

        @Override
        public ValueStruct[] newArray(int size) {
            return new ValueStruct[size];
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
