package com.upt.cti.bloodnetwork.serviceHandlers.dtos;

/**
 * Created by Patry Carla on 1/8/2017.
 */

public class LatLongDTO {
    private String latitude;
    private String longitude;

    public LatLongDTO() {}

    public LatLongDTO(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
