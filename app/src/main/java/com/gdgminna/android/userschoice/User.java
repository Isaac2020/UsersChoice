package com.gdgminna.android.userschoice;

/**
 * Created by MAGANI on 16/04/2018.
 */

public class User {

    private int id;
    private String name;
    private String email;
    private String password;
    private String phonenumber;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber(){return phonenumber;}

    public void setPhoneNumber(String phonenumber){this.phonenumber = phonenumber;}

    public String getAddress(){return address;}

    public void setAddress(String address){this.address = address;}

}
