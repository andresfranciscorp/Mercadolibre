
package com.franciscorp.meli.pruebameli.models.search;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Seller implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("permalink")
    @Expose
    private String permalink;
    @SerializedName("registration_date")
    @Expose
    private String registrationDate;
    @SerializedName("car_dealer")
    @Expose
    private Boolean carDealer;
    @SerializedName("real_estate_agency")
    @Expose
    private Boolean realEstateAgency;
    @SerializedName("tags")
    @Expose
    private List<String> tags = null;
    @SerializedName("seller_reputation")
    @Expose
    private SellerReputation sellerReputation;

    protected Seller(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        permalink = in.readString();
        registrationDate = in.readString();
        byte tmpCarDealer = in.readByte();
        carDealer = tmpCarDealer == 0 ? null : tmpCarDealer == 1;
        byte tmpRealEstateAgency = in.readByte();
        realEstateAgency = tmpRealEstateAgency == 0 ? null : tmpRealEstateAgency == 1;
        tags = in.createStringArrayList();
        sellerReputation = in.readParcelable(SellerReputation.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(permalink);
        dest.writeString(registrationDate);
        dest.writeByte((byte) (carDealer == null ? 0 : carDealer ? 1 : 2));
        dest.writeByte((byte) (realEstateAgency == null ? 0 : realEstateAgency ? 1 : 2));
        dest.writeStringList(tags);
        dest.writeParcelable(sellerReputation, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Seller> CREATOR = new Creator<Seller>() {
        @Override
        public Seller createFromParcel(Parcel in) {
            return new Seller(in);
        }

        @Override
        public Seller[] newArray(int size) {
            return new Seller[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Boolean getCarDealer() {
        return carDealer;
    }

    public void setCarDealer(Boolean carDealer) {
        this.carDealer = carDealer;
    }

    public Boolean getRealEstateAgency() {
        return realEstateAgency;
    }

    public void setRealEstateAgency(Boolean realEstateAgency) {
        this.realEstateAgency = realEstateAgency;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public SellerReputation getSellerReputation() {
        return sellerReputation;
    }

    public void setSellerReputation(SellerReputation sellerReputation) {
        this.sellerReputation = sellerReputation;
    }

}
