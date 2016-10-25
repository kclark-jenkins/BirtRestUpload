package org.krisbox.birt.examples.models;

/**
 * Created by kclark on 10/25/16.
 */
public class Authentication {
    private String authToken;
    private String adminRights;
    private User   user;

    public String getAuthToken(){return authToken;}
    public String getAdminRights(){return adminRights;}
    public User   getUser(){return user;}

    public void setAuthToken(String authToken){this.authToken = authToken;}
    public void setAdminRights(String adminRights){this.adminRights = adminRights;}
    public void setUser(User user){this.user = user;}
}
