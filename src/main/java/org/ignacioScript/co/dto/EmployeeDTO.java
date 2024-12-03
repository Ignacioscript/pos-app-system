package org.ignacioScript.co.dto;

import org.ignacioScript.co.interfaces.DataTransferObject;

public class EmployeeDTO implements DataTransferObject {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private JobDTO jobTitle;
    private LocationDTO location;
    private String hireDate;


    public EmployeeDTO(String firstName, String lastName, String email, String phoneNumber, JobDTO jobTitle, LocationDTO location, String hireDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.jobTitle = jobTitle;
        this.location = location;
        this.hireDate = hireDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public JobDTO getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobDTO jobTitle) {
        this.jobTitle = jobTitle;
    }

    public LocationDTO getLocation() {
        return location;
    }

    public void setLocation(LocationDTO location) {
        this.location = location;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }
}
