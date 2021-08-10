
package com.franciscorp.meli.pruebameli.models.search;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Shipping implements Parcelable {

    @SerializedName("free_shipping")
    @Expose
    private Boolean freeShipping;
    @SerializedName("mode")
    @Expose
    private String mode;
    @SerializedName("tags")
    @Expose
    private List<String> tags = null;
    @SerializedName("logistic_type")
    @Expose
    private String logisticType;
    @SerializedName("store_pick_up")
    @Expose
    private Boolean storePickUp;

    protected Shipping(Parcel in) {
        byte tmpFreeShipping = in.readByte();
        freeShipping = tmpFreeShipping == 0 ? null : tmpFreeShipping == 1;
        mode = in.readString();
        tags = in.createStringArrayList();
        logisticType = in.readString();
        byte tmpStorePickUp = in.readByte();
        storePickUp = tmpStorePickUp == 0 ? null : tmpStorePickUp == 1;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (freeShipping == null ? 0 : freeShipping ? 1 : 2));
        dest.writeString(mode);
        dest.writeStringList(tags);
        dest.writeString(logisticType);
        dest.writeByte((byte) (storePickUp == null ? 0 : storePickUp ? 1 : 2));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Shipping> CREATOR = new Creator<Shipping>() {
        @Override
        public Shipping createFromParcel(Parcel in) {
            return new Shipping(in);
        }

        @Override
        public Shipping[] newArray(int size) {
            return new Shipping[size];
        }
    };

    public Boolean getFreeShipping() {
        return freeShipping;
    }

    public void setFreeShipping(Boolean freeShipping) {
        this.freeShipping = freeShipping;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getLogisticType() {
        return logisticType;
    }

    public void setLogisticType(String logisticType) {
        this.logisticType = logisticType;
    }

    public Boolean getStorePickUp() {
        return storePickUp;
    }

    public void setStorePickUp(Boolean storePickUp) {
        this.storePickUp = storePickUp;
    }

}
