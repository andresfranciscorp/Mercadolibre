
package com.franciscorp.meli.pruebameli.models.search;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Metrics implements Parcelable {

    @SerializedName("claims")
    @Expose
    private Claims claims;
    @SerializedName("delayed_handling_time")
    @Expose
    private DelayedHandlingTime delayedHandlingTime;
    @SerializedName("sales")
    @Expose
    private Sales sales;
    @SerializedName("cancellations")
    @Expose
    private Cancellations cancellations;

    protected Metrics(Parcel in) {
        claims = in.readParcelable(Claims.class.getClassLoader());
        delayedHandlingTime = in.readParcelable(DelayedHandlingTime.class.getClassLoader());
        sales = in.readParcelable(Sales.class.getClassLoader());
        cancellations = in.readParcelable(Cancellations.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(claims, flags);
        dest.writeParcelable(delayedHandlingTime, flags);
        dest.writeParcelable(sales, flags);
        dest.writeParcelable(cancellations, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Metrics> CREATOR = new Creator<Metrics>() {
        @Override
        public Metrics createFromParcel(Parcel in) {
            return new Metrics(in);
        }

        @Override
        public Metrics[] newArray(int size) {
            return new Metrics[size];
        }
    };

    public Claims getClaims() {
        return claims;
    }

    public void setClaims(Claims claims) {
        this.claims = claims;
    }

    public DelayedHandlingTime getDelayedHandlingTime() {
        return delayedHandlingTime;
    }

    public void setDelayedHandlingTime(DelayedHandlingTime delayedHandlingTime) {
        this.delayedHandlingTime = delayedHandlingTime;
    }

    public Sales getSales() {
        return sales;
    }

    public void setSales(Sales sales) {
        this.sales = sales;
    }

    public Cancellations getCancellations() {
        return cancellations;
    }

    public void setCancellations(Cancellations cancellations) {
        this.cancellations = cancellations;
    }
}
