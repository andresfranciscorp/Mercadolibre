
package com.franciscorp.meli.pruebameli.models.search;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SellerReputation implements Parcelable {

    @SerializedName("transactions")
    @Expose
    private Transactions transactions;
    @SerializedName("power_seller_status")
    @Expose
    private String powerSellerStatus;
    @SerializedName("metrics")
    @Expose
    private Metrics metrics;
    @SerializedName("level_id")
    @Expose
    private String levelId;

    protected SellerReputation(Parcel in) {
        transactions = in.readParcelable(Transactions.class.getClassLoader());
        powerSellerStatus = in.readString();
        metrics = in.readParcelable(Metrics.class.getClassLoader());
        levelId = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(transactions, flags);
        dest.writeString(powerSellerStatus);
        dest.writeParcelable(metrics, flags);
        dest.writeString(levelId);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SellerReputation> CREATOR = new Creator<SellerReputation>() {
        @Override
        public SellerReputation createFromParcel(Parcel in) {
            return new SellerReputation(in);
        }

        @Override
        public SellerReputation[] newArray(int size) {
            return new SellerReputation[size];
        }
    };

    public Transactions getTransactions() {
        return transactions;
    }

    public void setTransactions(Transactions transactions) {
        this.transactions = transactions;
    }

    public String getPowerSellerStatus() {
        return powerSellerStatus;
    }

    public void setPowerSellerStatus(String powerSellerStatus) {
        this.powerSellerStatus = powerSellerStatus;
    }

    public Metrics getMetrics() {
        return metrics;
    }

    public void setMetrics(Metrics metrics) {
        this.metrics = metrics;
    }

    public String getLevelId() {
        return levelId;
    }

    public void setLevelId(String levelId) {
        this.levelId = levelId;
    }

}
