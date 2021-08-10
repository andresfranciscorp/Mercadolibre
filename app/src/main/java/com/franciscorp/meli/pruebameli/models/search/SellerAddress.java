
package com.franciscorp.meli.pruebameli.models.search;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class SellerAddress implements Parcelable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("comment")
    @Expose
    private String comment;
    @SerializedName("address_line")
    @Expose
    private String addressLine;
    @SerializedName("zip_code")
    @Expose
    private String zipCode;
    @SerializedName("country")
    @Expose
    private Country country;
    @SerializedName("state")
    @Expose
    private State state;
    @SerializedName("city")
    @Expose
    private City city;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;

    protected SellerAddress(Parcel in) {
        id = in.readString();
        comment = in.readString();
        addressLine = in.readString();
        zipCode = in.readString();
        country = in.readParcelable(Country.class.getClassLoader());
        state = in.readParcelable(State.class.getClassLoader());
        city = in.readParcelable(City.class.getClassLoader());
        latitude = in.readString();
        longitude = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(comment);
        dest.writeString(addressLine);
        dest.writeString(zipCode);
        dest.writeParcelable(country, flags);
        dest.writeParcelable(state, flags);
        dest.writeParcelable(city, flags);
        dest.writeString(latitude);
        dest.writeString(longitude);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SellerAddress> CREATOR = new Creator<SellerAddress>() {
        @Override
        public SellerAddress createFromParcel(Parcel in) {
            return new SellerAddress(in);
        }

        @Override
        public SellerAddress[] newArray(int size) {
            return new SellerAddress[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

}
