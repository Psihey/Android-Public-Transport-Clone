package com.provectus.public_transport.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.google.gson.annotations.SerializedName;
import com.provectus.public_transport.model.converter.AvailableBooleanConverters;
import com.provectus.public_transport.model.converter.TransportType;

import java.util.List;

@Entity(tableName = "transports", indices = {@Index(value = {"transport_id"})})
public class TransportEntity {

    @SerializedName("id")
    @ColumnInfo(name = "transport_id")
    @PrimaryKey()
    private long mServerId;

    @SerializedName("number")
    @ColumnInfo(name = "transport_number")
    private int mNumber;

    @SerializedName("type")
    @ColumnInfo(name = "transport_type")
    @TypeConverters({TransportType.class})
    private TransportType mType;

    @SerializedName("distance")
    @ColumnInfo(name = "transport_distance")
    private double mDistance;

    @ColumnInfo(name = "available")
    @TypeConverters({AvailableBooleanConverters.class})
    private boolean mIsAvailable;

    @SerializedName("segments")
    @Ignore
    private List<SegmentEntity> mSegments;

    @Ignore
    private boolean mIsSelected;

    public TransportEntity() {
    }

    public TransportEntity(long serverId, int number, TransportType type, double distance, boolean available) {
        this.mServerId = serverId;
        this.mNumber = number;
        this.mType = type;
        this.mDistance = distance;
        this.mIsAvailable = available;
    }

    public boolean isAvailable() {
        return mIsAvailable;
    }

    public void setIsAvailable(boolean mIsAvailable) {
        this.mIsAvailable = mIsAvailable;
    }

    public long getServerId() {
        return mServerId;
    }

    public boolean isSelected() {
        return mIsSelected;
    }

    public int getNumber() {
        return mNumber;
    }

    public TransportType getType() {
        return mType;
    }

    public double getDistance() {
        return mDistance;
    }

    public List<SegmentEntity> getSegments() {
        return mSegments;
    }

    public void setServerId(long mServerId) {
        this.mServerId = mServerId;
    }

    public void setNumber(int mNumber) {
        this.mNumber = mNumber;
    }

    public void setType(TransportType mType) {
        this.mType = mType;
    }

    public void setDistance(double mDistance) {
        this.mDistance = mDistance;
    }

    public void setIsSelected(boolean mIsSelected) {
        this.mIsSelected = mIsSelected;
    }

    @Override
    public String toString() {
        return "TransportEntity{" +
                "ServerId=" + mServerId +
                ", Number=" + mNumber +
                ", Type=" + mType +
                ", Distance=" + mDistance +
                ", segments=" + mSegments +
                '}';
    }
}
