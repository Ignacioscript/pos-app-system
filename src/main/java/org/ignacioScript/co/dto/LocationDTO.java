package org.ignacioScript.co.dto;

public class LocationDTO {

    private String province;
    private String city;
    private String street;


    public LocationDTO(String province, String city, String street) {
        this.province = province;
        this.city = city;
        this.street = street;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("province: ").append(province)
                .append(", city: ").append(city)
                .append(", street: ").append(street);
        return sb.toString();
    }
}
