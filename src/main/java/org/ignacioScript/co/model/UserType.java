package org.ignacioScript.co.model;

import org.ignacioScript.co.interfaces.DataTransferObject;

public class UserType implements DataTransferObject {

    private int userTypeId;
    private String userType;

    public UserType(int userTypeId, String userType) {
        this.userTypeId = userTypeId;
        this.userType = userType;
    }

    public UserType(String userType) {
        this.userType = userType;
    }

    public int getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
