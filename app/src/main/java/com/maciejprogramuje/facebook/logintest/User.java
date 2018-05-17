package com.maciejprogramuje.facebook.logintest;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("LoginName")
    private String userName;

    @SerializedName("Password")
    private String password;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
