
package com.franciscorp.meli.pruebameli.models.search;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Installments implements Parcelable {

    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    @SerializedName("amount")
    @Expose
    private Double amount;
    @SerializedName("rate")
    @Expose
    private Double rate;
    @SerializedName("currency_id")
    @Expose
    private String currencyId;

    protected Installments(Parcel in) {
        if (in.readByte() == 0) {
            quantity = null;
        } else {
            quantity = in.readInt();
        }
        if (in.readByte() == 0) {
            amount = null;
        } else {
            amount = in.readDouble();
        }
        if (in.readByte() == 0) {
            rate = null;
        } else {
            rate = in.readDouble();
        }
        currencyId = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (quantity == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(quantity);
        }
        if (amount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(amount);
        }
        if (rate == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(rate);
        }
        dest.writeString(currencyId);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Installments> CREATOR = new Creator<Installments>() {
        @Override
        public Installments createFromParcel(Parcel in) {
            return new Installments(in);
        }

        @Override
        public Installments[] newArray(int size) {
            return new Installments[size];
        }
    };

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

}
