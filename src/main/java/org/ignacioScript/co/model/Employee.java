package org.ignacioScript.co.model;


import java.time.LocalDate;

public class Employee extends User {



    private String jobTitle;
    private String location;
    private LocalDate hireDate;



    public Employee(int id, String firstName, String lastName, String email, String phoneNumber, String jobTitle, String location, LocalDate hireDate) {
        super(id, firstName, lastName, email, phoneNumber);
        this.jobTitle = jobTitle;
        this.location = location;
        this.hireDate = hireDate;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public String getFirstName() {
        return super.firstName;
    }

    @Override
    public String getLastName() {
        return super.lastName;
    }

    @Override
    public String getEmail() {
        return super.email;
    }

    @Override
    public String getPhoneNumber() {
        return super.phoneNumber;
    }

    @Override
    public int getId() {
        return super.id;
    }
}
