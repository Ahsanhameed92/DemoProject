package com.ahsan.demoapplication.data;

/**
 * Created by Vengile on 4/12/2016.
 */
public class DataObject {
    private String firstName;
    private String lastName;


    public DataObject(String fName, String lName){
        firstName = fName;
        lastName = lName;
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
}
