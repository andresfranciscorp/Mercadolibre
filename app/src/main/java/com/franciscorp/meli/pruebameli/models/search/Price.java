
package com.franciscorp.meli.pruebameli.models.search;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Price implements Parcelable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("amount")
    @Expose
    private Double amount;
    @SerializedName("regular_amount")
    @Expose
    private Double regularAmount;
    @SerializedName("currency_id")
    @Expose
    private String currencyId;
    @SerializedName("exchange_rate_context")
    @Expose
    private String exchangeRateContext;
    @SerializedName("last_updated")
    @Expose
    private String lastUpdated;


    protected Price(Parcel in) {
        id = in.readString();
        type = in.readString();
        if (in.readByte() == 0) {
            amount = null;
        } else {
            amount = in.readDouble();
        }
        if (in.readByte() == 0) {
            regularAmount = null;
        } else {
            regularAmount = in.readDouble();
        }
        currencyId = in.readString();
        exchangeRateContext = in.readString();
        lastUpdated = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(type);
        if (amount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(amount);
        }
        if (regularAmount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(regularAmount);
        }
        dest.writeString(currencyId);
        dest.writeString(exchangeRateContext);
        dest.writeString(lastUpdated);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Price> CREATOR = new Creator<Price>() {
        @Override
        public Price createFromParcel(Parcel in) {
            return new Price(in);
        }

        @Override
        public Price[] newArray(int size) {
            return new Price[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getRegularAmount() {
        return regularAmount;
    }

    public void setRegularAmount(Double regularAmount) {
        this.regularAmount = regularAmount;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public String getExchangeRateContext() {
        return exchangeRateContext;
    }

    public void setExchangeRateContext(String exchangeRateContext) {
        this.exchangeRateContext = exchangeRateContext;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

}
