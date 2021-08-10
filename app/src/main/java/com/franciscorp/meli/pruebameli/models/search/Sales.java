
package com.franciscorp.meli.pruebameli.models.search;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sales implements Parcelable {

    @SerializedName("period")
    @Expose
    private String period;
    @SerializedName("completed")
    @Expose
    private Integer completed;

    protected Sales(Parcel in) {
        period = in.readString();
        if (in.readByte() == 0) {
            completed = null;
        } else {
            completed = in.readInt();
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(period);
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

    public static final Creator<Sales> CREATOR = new Creator<Sales>() {
        @Override
        public Sales createFromParcel(Parcel in) {
            return new Sales(in);
        }

        @Override
        public Sales[] newArray(int size) {
            return new Sales[size];
        }
    };

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Integer getCompleted() {
        return completed;
    }

    public void setCompleted(Integer completed) {
        this.completed = completed;
    }

}
