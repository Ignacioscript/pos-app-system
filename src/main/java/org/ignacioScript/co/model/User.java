package org.ignacioScript.co.model;

import org.ignacioScript.co.interfaces.DataTransferObject;

public abstract class User implements DataTransferObject {


    protected int id;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String username;
    protected String password;
    protected String phoneNumber;
  //  protected UserType userType;

    protected User(int id, String firstName, String lastName, String email, String username, String password, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
      //  this.userType = userType;
    }

    protected User(String firstName, String lastName, String email, String username, String password, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
     //   this.userType = userType;
    }

    public User() {
    }

    public User(int id, String firstName, String lastName, String email, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;

    }

    public User(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    protected String getFirstName() {
        return firstName;
    }

    protected void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    protected String getLastName() {
        return lastName;
    }

    protected void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    protected String getUsername() {
        return username;
    }

    protected void setUsername(String username) {
        this.username = username;
    }

    protected String getPassword() {
        return password;
    }

    protected void setPassword(String password) {
        this.password = password;
    }

    protected String getPhoneNumber() {
        return phoneNumber;
    }

    protected void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



//    protected UserType getUserType() {
//        return userType;
//    }

//    protected void setUserType(UserType userType) {
//        this.userType = userType;
//    }


    public int getId() {
        return this.id;
    }
}