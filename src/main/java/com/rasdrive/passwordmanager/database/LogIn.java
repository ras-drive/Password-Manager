package com.rasdrive.passwordmanager.database;

public record LogIn(String website, String userName, String password) {

    public String getWebsite() {
        return website;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

}
