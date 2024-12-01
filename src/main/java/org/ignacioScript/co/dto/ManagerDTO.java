package org.ignacioScript.co.dto;

public class ManagerDTO {

    private String location;

    public ManagerDTO(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Manager [location=").append(location).append("]");
        return sb.toString();
    }
}
