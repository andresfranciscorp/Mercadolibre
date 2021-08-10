
package com.franciscorp.meli.pruebameli.models.search;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Presentation implements Parcelable {

    @SerializedName("display_currency")
    @Expose
    private String displayCurrency;

    protected Presentation(Parcel in) {
        displayCurrency = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(displayCurrency);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Presentation> CREATOR = new Creator<Presentation>() {
        @Override
        public Presentation createFromParcel(Parcel in) {
            return new Presentation(in);
        }

        @Override
        public Presentation[] newArray(int size) {
            return new Presentation[size];
        }
    };

    public String getDisplayCurrency() {
        return displayCurrency;
    }

    public void setDisplayCurrency(String displayCurrency) {
        this.displayCurrency = displayCurrency;
    }

}
