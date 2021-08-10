
package com.franciscorp.meli.pruebameli.models.search;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cancellations implements Parcelable {

    @SerializedName("rate")
    @Expose
    private Double rate;
    @SerializedName("value")
    @Expose
    private Double value;
    @SerializedName("period")
    @Expose
    private String period;


    protected Cancellations(Parcel in) {
        if (in.readByte() == 0) {
            rate = null;
        } else {
            rate = in.readDouble();
        }
        if (in.readByte() == 0) {
            value = null;
        } else {
            value = in.readDouble();
        }
        period = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (rate == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(rate);
        }
        if (value == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(value);
        }
        dest.writeString(period);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Cancellations> CREATOR = new Creator<Cancellations>() {
        @Override
        public Cancellations createFromParcel(Parcel in) {
            return new Cancellations(in);
        }

        @Override
        public Cancellations[] newArray(int size) {
            return new Cancellations[size];
        }
    };

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

}
