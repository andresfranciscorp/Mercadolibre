
package com.franciscorp.meli.pruebameli.models.search;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseSearchQuery implements Parcelable {

    @SerializedName("site_id")
    @Expose
    private String siteId;
    @SerializedName("country_default_time_zone")
    @Expose
    private String countryDefaultTimeZone;
    @SerializedName("query")
    @Expose
    private String query;
    @SerializedName("paging")
    @Expose
    private Paging paging;
    @SerializedName("results")
    @Expose
    private List<Result> results = null;
    @SerializedName("sort")
    @Expose
    private Sort sort;
    @SerializedName("available_sorts")
    @Expose
    private List<AvailableSort> availableSorts = null;
    @SerializedName("filters")
    @Expose
    private List<Filter> filters = null;
    @SerializedName("available_filters")
    @Expose
    private List<AvailableFilter> availableFilters = null;

    protected ResponseSearchQuery(Parcel in) {
        siteId = in.readString();
        countryDefaultTimeZone = in.readString();
        query = in.readString();
        paging = in.readParcelable(Paging.class.getClassLoader());
        results = in.createTypedArrayList(Result.CREATOR);
        sort = in.readParcelable(Sort.class.getClassLoader());
        availableSorts = in.createTypedArrayList(AvailableSort.CREATOR);
        filters = in.createTypedArrayList(Filter.CREATOR);
        availableFilters = in.createTypedArrayList(AvailableFilter.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(siteId);
        dest.writeString(countryDefaultTimeZone);
        dest.writeString(query);
        dest.writeParcelable(paging, flags);
        dest.writeTypedList(results);
        dest.writeParcelable(sort, flags);
        dest.writeTypedList(availableSorts);
        dest.writeTypedList(filters);
        dest.writeTypedList(availableFilters);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ResponseSearchQuery> CREATOR = new Creator<ResponseSearchQuery>() {
        @Override
        public ResponseSearchQuery createFromParcel(Parcel in) {
            return new ResponseSearchQuery(in);
        }

        @Override
        public ResponseSearchQuery[] newArray(int size) {
            return new ResponseSearchQuery[size];
        }
    };

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getCountryDefaultTimeZone() {
        return countryDefaultTimeZone;
    }

    public void setCountryDefaultTimeZone(String countryDefaultTimeZone) {
        this.countryDefaultTimeZone = countryDefaultTimeZone;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public List<AvailableSort> getAvailableSorts() {
        return availableSorts;
    }

    public void setAvailableSorts(List<AvailableSort> availableSorts) {
        this.availableSorts = availableSorts;
    }

    public List<Filter> getFilters() {
        return filters;
    }

    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }

    public List<AvailableFilter> getAvailableFilters() {
        return availableFilters;
    }

    public void setAvailableFilters(List<AvailableFilter> availableFilters) {
        this.availableFilters = availableFilters;
    }

}
