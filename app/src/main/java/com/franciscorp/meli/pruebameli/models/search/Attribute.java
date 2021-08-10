
package com.franciscorp.meli.pruebameli.models.search;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Attribute implements Parcelable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("value_id")
    @Expose
    private String valueId;
    @SerializedName("value_name")
    @Expose
    private String valueName;
    @SerializedName("value_struct")
    @Expose
    private ValueStruct valueStruct;
    @SerializedName("source")
    @Expose
    private Double source;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("values")
    @Expose
    private List<Value> values = null;
    @SerializedName("attribute_group_id")
    @Expose
    private String attributeGroupId;
    @SerializedName("attribute_group_name")
    @Expose
    private String attributeGroupName;


    protected Attribute(Parcel in) {
        name = in.readString();
        valueId = in.readString();
        valueName = in.readString();
        valueStruct = in.readParcelable(ValueStruct.class.getClassLoader());
        if (in.readByte() == 0) {
            source = null;
        } else {
            source = in.readDouble();
        }
        id = in.readString();
        values = in.createTypedArrayList(Value.CREATOR);
        attributeGroupId = in.readString();
        attributeGroupName = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(valueId);
        dest.writeString(valueName);
        dest.writeParcelable(valueStruct, flags);
        if (source == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(source);
        }
        dest.writeString(id);
        dest.writeTypedList(values);
        dest.writeString(attributeGroupId);
        dest.writeString(attributeGroupName);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Attribute> CREATOR = new Creator<Attribute>() {
        @Override
        public Attribute createFromParcel(Parcel in) {
            return new Attribute(in);
        }

        @Override
        public Attribute[] newArray(int size) {
            return new Attribute[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValueId() {
        return valueId;
    }

    public void setValueId(String valueId) {
        this.valueId = valueId;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    public ValueStruct getValueStruct() {
        return valueStruct;
    }

    public void setValueStruct(ValueStruct valueStruct) {
        this.valueStruct = valueStruct;
    }

    public Double getSource() {
        return source;
    }

    public void setSource(Double source) {
        this.source = source;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Value> getValues() {
        return values;
    }

    public void setValues(List<Value> values) {
        this.values = values;
    }

    public String getAttributeGroupId() {
        return attributeGroupId;
    }

    public void setAttributeGroupId(String attributeGroupId) {
        this.attributeGroupId = attributeGroupId;
    }

    public String getAttributeGroupName() {
        return attributeGroupName;
    }

    public void setAttributeGroupName(String attributeGroupName) {
        this.attributeGroupName = attributeGroupName;
    }

}
