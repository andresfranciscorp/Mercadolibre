
package com.franciscorp.meli.pruebameli.models.search;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ratings implements Parcelable {

    @SerializedName("negative")
    @Expose
    private Double negative;
    @SerializedName("positive")
    @Expose
    private Double positive;
    @SerializedName("neutral")
    @Expose
    private Double neutral;


    protected Ratings(Parcel in) {
        if (in.readByte() == 0) {
            negative = null;
        } else {
            negative = in.readDouble();
        }
        if (in.readByte() == 0) {
            positive = null;
        } else {
            positive = in.readDouble();
        }
        if (in.readByte() == 0) {
            neutral = null;
        } else {
            neutral = in.readDouble();
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (negative == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(negative);
        }
        if (positive == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(positive);
        }
        if (neutral == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(neutral);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Ratings> CREATOR = new Creator<Ratings>() {
        @Override
        public Ratings createFromParcel(Parcel in) {
            return new Ratings(in);
        }

        @Override
        public Ratings[] newArray(int size) {
            return new Ratings[size];
        }
    };

    public Double getNegative() {
        return negative;
    }

    public void setNegative(Double negative) {
        this.negative = negative;
    }

    public Double getPositive() {
        return positive;
    }

    public void setPositive(Double positive) {
        this.positive = positive;
    }

    public Double getNeutral() {
        return neutral;
    }

    public void setNeutral(Double neutral) {
        this.neutral = neutral;
    }

}
