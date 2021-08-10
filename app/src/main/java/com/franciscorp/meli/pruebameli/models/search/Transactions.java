
package com.franciscorp.meli.pruebameli.models.search;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Transactions implements Parcelable {

    @SerializedName("total")
    @Expose
    private Double total;
    @SerializedName("canceled")
    @Expose
    private Double canceled;
    @SerializedName("period")
    @Expose
    private String period;
    @SerializedName("ratings")
    @Expose
    private Ratings ratings;
    @SerializedName("completed")
    @Expose
    private Integer completed;

    protected Transactions(Parcel in) {
        if (in.readByte() == 0) {
            total = null;
        } else {
            total = in.readDouble();
        }
        if (in.readByte() == 0) {
            canceled = null;
        } else {
            canceled = in.readDouble();
        }
        period = in.readString();
        ratings = in.readParcelable(Ratings.class.getClassLoader());
        if (in.readByte() == 0) {
            completed = null;
        } else {
            completed = in.readInt();
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (total == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(total);
        }
        if (canceled == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(canceled);
        }
        dest.writeString(period);
        dest.writeParcelable(ratings, flags);
        if (completed == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(completed);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Transactions> CREATOR = new Creator<Transactions>() {
        @Override
        public Transactions createFromParcel(Parcel in) {
            return new Transactions(in);
        }

        @Override
        public Transactions[] newArray(int size) {
            return new Transactions[size];
        }
    };

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getCanceled() {
        return canceled;
    }

    public void setCanceled(Double canceled) {
        this.canceled = canceled;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Ratings getRatings() {
        return ratings;
    }

    public void setRatings(Ratings ratings) {
        this.ratings = ratings;
    }

    public Integer getCompleted() {
        return completed;
    }

    public void setCompleted(Integer completed) {
        this.completed = completed;
    }

}
