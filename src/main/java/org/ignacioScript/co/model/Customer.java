package org.ignacioScript.co.model;

public class Customer extends User {




    public Customer(int id, String firstName, String lastName, String email, String phoneNumber){
        super(id, firstName, lastName, email, phoneNumber);

    }

    public Customer(String firstName, String lastName, String email, String phoneNumber){
        super(firstName, lastName, email, phoneNumber);

    }

    public String getPhoneNumber() {
        return super.phoneNumber;
    }


    public int getId() {
        return super.id;
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


}