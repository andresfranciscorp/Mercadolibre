
package com.franciscorp.meli.pruebameli.models.search;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result implements Parcelable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("site_id")
    @Expose
    private String siteId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("seller")
    @Expose
    private Seller seller;
    @SerializedName("price")
    @Expose
    private Double price;
    @SerializedName("prices")
    @Expose
    private Prices prices;
    @SerializedName("currency_id")
    @Expose
    private String currencyId;
    @SerializedName("available_quantity")
    @Expose
    private Integer availableQuantity;
    @SerializedName("sold_quantity")
    @Expose
    private Integer soldQuantity;
    @SerializedName("buying_mode")
    @Expose
    private String buyingMode;
    @SerializedName("listing_type_id")
    @Expose
    private String listingTypeId;
    @SerializedName("stop_time")
    @Expose
    private String stopTime;
    @SerializedName("condition")
    @Expose
    private String condition;
    @SerializedName("permalink")
    @Expose
    private String permalink;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("thumbnail_id")
    @Expose
    private String thumbnailId;
    @SerializedName("accepts_mercadopago")
    @Expose
    private Boolean acceptsMercadopago;
    @SerializedName("installments")
    @Expose
    private Installments installments;
    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("shipping")
    @Expose
    private Shipping shipping;
    @SerializedName("seller_address")
    @Expose
    private SellerAddress sellerAddress;
    @SerializedName("attributes")
    @Expose
    private List<Attribute> attributes = null;
    @SerializedName("original_price")
    @Expose
    private Double originalPrice;
    @SerializedName("category_id")
    @Expose
    private String categoryId;
    @SerializedName("official_store_id")
    @Expose
    private Integer officialStoreId;
    @SerializedName("domain_id")
    @Expose
    private String domainId;
    @SerializedName("catalog_product_id")
    @Expose
    private String catalogProductId;
    @SerializedName("tags")
    @Expose
    private List<String> tags = null;
    @SerializedName("order_backend")
    @Expose
    private Double orderBackend;
    @SerializedName("use_thumbnail_id")
    @Expose
    private Boolean useThumbnailId;


    protected Result(Parcel in) {
        id = in.readString();
        siteId = in.readString();
        title = in.readString();
        seller = in.readParcelable(Seller.class.getClassLoader());
        if (in.readByte() == 0) {
            price = null;
        } else {
            price = in.readDouble();
        }
        prices = in.readParcelable(Prices.class.getClassLoader());
        currencyId = in.readString();
        if (in.readByte() == 0) {
            availableQuantity = null;
        } else {
            availableQuantity = in.readInt();
        }
        if (in.readByte() == 0) {
            soldQuantity = null;
        } else {
            soldQuantity = in.readInt();
        }
        buyingMode = in.readString();
        listingTypeId = in.readString();
        stopTime = in.readString();
        condition = in.readString();
        permalink = in.readString();
        thumbnail = in.readString();
        thumbnailId = in.readString();
        byte tmpAcceptsMercadopago = in.readByte();
        acceptsMercadopago = tmpAcceptsMercadopago == 0 ? null : tmpAcceptsMercadopago == 1;
        installments = in.readParcelable(Installments.class.getClassLoader());
        address = in.readParcelable(Address.class.getClassLoader());
        shipping = in.readParcelable(Shipping.class.getClassLoader());
        sellerAddress = in.readParcelable(SellerAddress.class.getClassLoader());
        attributes = in.createTypedArrayList(Attribute.CREATOR);
        if (in.readByte() == 0) {
            originalPrice = null;
        } else {
            originalPrice = in.readDouble();
        }
        categoryId = in.readString();
        if (in.readByte() == 0) {
            officialStoreId = null;
        } else {
            officialStoreId = in.readInt();
        }
        domainId = in.readString();
        catalogProductId = in.readString();
        tags = in.createStringArrayList();
        if (in.readByte() == 0) {
            orderBackend = null;
        } else {
            orderBackend = in.readDouble();
        }
        byte tmpUseThumbnailId = in.readByte();
        useThumbnailId = tmpUseThumbnailId == 0 ? null : tmpUseThumbnailId == 1;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(siteId);
        dest.writeString(title);
        dest.writeParcelable(seller, flags);
        if (price == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(price);
        }
        dest.writeParcelable(prices, flags);
        dest.writeString(currencyId);
        if (availableQuantity == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(availableQuantity);
        }
        if (soldQuantity == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(soldQuantity);
        }
        dest.writeString(buyingMode);
        dest.writeString(listingTypeId);
        dest.writeString(stopTime);
        dest.writeString(condition);
        dest.writeString(permalink);
        dest.writeString(thumbnail);
        dest.writeString(thumbnailId);
        dest.writeByte((byte) (acceptsMercadopago == null ? 0 : acceptsMercadopago ? 1 : 2));
        dest.writeParcelable(installments, flags);
        dest.writeParcelable(address, flags);
        dest.writeParcelable(shipping, flags);
        dest.writeParcelable(sellerAddress, flags);
        dest.writeTypedList(attributes);
        if (originalPrice == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(originalPrice);
        }
        dest.writeString(categoryId);
        if (officialStoreId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(officialStoreId);
        }
        dest.writeString(domainId);
        dest.writeString(catalogProductId);
        dest.writeStringList(tags);
        if (orderBackend == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(orderBackend);
        }
        dest.writeByte((byte) (useThumbnailId == null ? 0 : useThumbnailId ? 1 : 2));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Result> CREATOR = new Creator<Result>() {
        @Override
        public Result createFromParcel(Parcel in) {
            return new Result(in);
        }

        @Override
        public Result[] newArray(int size) {
            return new Result[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Prices getPrices() {
        return prices;
    }

    public void setPrices(Prices prices) {
        this.prices = prices;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public Integer getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public Integer getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(Integer soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    public String getBuyingMode() {
        return buyingMode;
    }

    public void setBuyingMode(String buyingMode) {
        this.buyingMode = buyingMode;
    }

    public String getListingTypeId() {
        return listingTypeId;
    }

    public void setListingTypeId(String listingTypeId) {
        this.listingTypeId = listingTypeId;
    }

    public String getStopTime() {
        return stopTime;
    }

    public void setStopTime(String stopTime) {
        this.stopTime = stopTime;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getThumbnail() {
        if (thumbnail != null) {
            thumbnail = thumbnail.replace("http://", "https://");
        }
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getThumbnailId() {
        return thumbnailId;
    }

    public void setThumbnailId(String thumbnailId) {
        this.thumbnailId = thumbnailId;
    }

    public Boolean getAcceptsMercadopago() {
        return acceptsMercadopago;
    }

    public void setAcceptsMercadopago(Boolean acceptsMercadopago) {
        this.acceptsMercadopago = acceptsMercadopago;
    }

    public Installments getInstallments() {
        return installments;
    }

    public void setInstallments(Installments installments) {
        this.installments = installments;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    public SellerAddress getSellerAddress() {
        return sellerAddress;
    }

    public void setSellerAddress(SellerAddress sellerAddress) {
        this.sellerAddress = sellerAddress;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getOfficialStoreId() {
        return officialStoreId;
    }

    public void setOfficialStoreId(Integer officialStoreId) {
        this.officialStoreId = officialStoreId;
    }

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    public String getCatalogProductId() {
        return catalogProductId;
    }

    public void setCatalogProductId(String catalogProductId) {
        this.catalogProductId = catalogProductId;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Double getOrderBackend() {
        return orderBackend;
    }

    public void setOrderBackend(Double orderBackend) {
        this.orderBackend = orderBackend;
    }

    public Boolean getUseThumbnailId() {
        return useThumbnailId;
    }

    public void setUseThumbnailId(Boolean useThumbnailId) {
        this.useThumbnailId = useThumbnailId;
    }

}
