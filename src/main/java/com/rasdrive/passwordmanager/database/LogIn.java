package com.rasdrive.passwordmanager.database;

public record LogIn(String website, String username, String password) {

    public String getWebsite() {
        return website;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

}
