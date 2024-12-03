package org.ignacioScript.co.model;

import org.ignacioScript.co.interfaces.DataTransferObject;

public class Location implements DataTransferObject {

    private int locationId;
    private String province;
    private String city;
    private String street;

    public Location(int locationId, String province, String city, String street) {
        this.locationId = locationId;
        this.province = province;
        this.city = city;
        this.street = street;
    }

    public Location(String province, String city, String street) {
        this.province = province;
        this.city = city;
        this.street = street;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
