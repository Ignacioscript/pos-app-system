package org.ignacioScript.co.dto;

public class ManagerDTO {

    private String managerName;
    private String managerLastName;
    private String managerEmail;
    private String managerPhone;
    private LocationDTO location;

    public ManagerDTO(String managerName, String managerLastName, String managerEmail, String managerPhone, LocationDTO location) {
        this.managerName = managerName;
        this.managerEmail = managerEmail;
        this.managerPhone = managerPhone;
        this.location = location;
    }


    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerLastName() {
        return managerName;
    }

    public void setManagerLastName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerEmail() {
        return managerEmail;
    }

    public void setManagerEmail(String managerEmail) {
        this.managerEmail = managerEmail;
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone;
    }

    public LocationDTO getLocation() {
        return location;
    }

    public void setLocation(LocationDTO location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "ManagerDTO{" +
                "managerName='" + managerName + '\'' +
                ", managerEmail='" + managerEmail + '\'' +
                ", managerPhone='" + managerPhone + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
