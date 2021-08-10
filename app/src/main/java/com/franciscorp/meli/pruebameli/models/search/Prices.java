
package com.franciscorp.meli.pruebameli.models.search;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Prices implements Parcelable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("prices")
    @Expose
    private List<Price> prices = null;
    @SerializedName("presentation")
    @Expose
    private Presentation presentation;

    protected Prices(Parcel in) {
        id = in.readString();
        prices = in.createTypedArrayList(Price.CREATOR);
        presentation = in.readParcelable(Presentation.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeTypedList(prices);
        dest.writeParcelable(presentation, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Prices> CREATOR = new Creator<Prices>() {
        @Override
        public Prices createFromParcel(Parcel in) {
            return new Prices(in);
        }

        @Override
        public Prices[] newArray(int size) {
            return new Prices[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

    public Presentation getPresentation() {
        return presentation;
    }

    public void setPresentation(Presentation presentation) {
        this.presentation = presentation;
    }
}
