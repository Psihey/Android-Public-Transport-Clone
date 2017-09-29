package com.provectus.public_transport.model;

import com.google.gson.annotations.SerializedName;

public class VehiclesModel {

    @SerializedName("vehicleId")
    private long mVehicleId;

    @SerializedName("lat")
    private double mLatitude;

    @SerializedName("lng")
    private double mLongitude;

    @SerializedName("speed")
    private int mSpeed;

    @SerializedName("azimut")
    private int mAzimuth;

    @SerializedName("gsmpower")
    private String mGsmPower;

    @SerializedName("sats")
    private int mSatellite;

    @SerializedName("routeId")
    private long mRouteId;

    @SerializedName("type")
    private String mType;

    public long getRouteId() {
        return mRouteId;
    }

    public String getType() {
        return mType;
    }

    public long getVehicleId() {
        return mVehicleId;
    }

    public double getLatitude() {
        return mLatitude;
    }

    public double getLongitude() {
        return mLongitude;
    }

    public int getSpeed() {
        return mSpeed;
    }

    public int getAzimuth() {
        return mAzimuth;
    }

    public String getGsmPower() {
        return mGsmPower;
    }

    public int getSatellite() {
        return mSatellite;
    }

    @Override
    public String toString() {
        return "VehiclesModel{" +
                "mVehicleId=" + mVehicleId +
                ", mLatitude=" + mLatitude +
                ", mLongitude=" + mLongitude +
                ", mSpeed=" + mSpeed +
                ", mAzimuth=" + mAzimuth +
                ", mGsmPower='" + mGsmPower + '\'' +
                ", mSatellite=" + mSatellite +
                ", mRouteId=" + mRouteId +
                ", mType=" + mType +
                '}';
    }
}
