package org.ignacioScript.co.model;


public class Manager extends User{


    private Location location;

    public Manager(int id, String firstName, String lastName, String email, String phoneNumber, Location location) {

        super(id, firstName, lastName, email, phoneNumber);
        this.location = location;
    }

    public Manager(String firstName, String lastName, String email, String phoneNumber, Location location) {

        super(firstName, lastName, email, phoneNumber);
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;

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
