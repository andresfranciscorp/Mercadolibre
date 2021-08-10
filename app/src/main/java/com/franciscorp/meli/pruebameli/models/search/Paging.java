
package com.franciscorp.meli.pruebameli.models.search;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Paging implements Parcelable {

    @SerializedName("total")
    @Expose
    private Double total;
    @SerializedName("primary_results")
    @Expose
    private Double primaryResults;
    @SerializedName("offset")
    @Expose
    private Double offset;
    @SerializedName("limit")
    @Expose
    private Double limit;


    protected Paging(Parcel in) {
        if (in.readByte() == 0) {
            total = null;
        } else {
            total = in.readDouble();
        }
        if (in.readByte() == 0) {
            primaryResults = null;
        } else {
            primaryResults = in.readDouble();
        }
        if (in.readByte() == 0) {
            offset = null;
        } else {
            offset = in.readDouble();
        }
        if (in.readByte() == 0) {
            limit = null;
        } else {
            limit = in.readDouble();
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
        if (primaryResults == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(primaryResults);
        }
        if (offset == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(offset);
        }
        if (limit == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(limit);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Paging> CREATOR = new Creator<Paging>() {
        @Override
        public Paging createFromParcel(Parcel in) {
            return new Paging(in);
        }

        @Override
        public Paging[] newArray(int size) {
            return new Paging[size];
        }
    };

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getPrimaryResults() {
        return primaryResults;
    }

    public void setPrimaryResults(Double primaryResults) {
        this.primaryResults = primaryResults;
    }

    public Double getOffset() {
        return offset;
    }

    public void setOffset(Double offset) {
        this.offset = offset;
    }

    public Double getLimit() {
        return limit;
    }

    public void setLimit(Double limit) {
        this.limit = limit;
    }

}
