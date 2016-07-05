package com.sancheztech.mascota.pojo;

/**
 * Created by rsanchezgu on 23/06/2016.
 */
public class Followed {
    private String id;
    private String fullName;
    private String userName;
    private String profile_picture;

    public String getProfile_picture() {
        return profile_picture;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Followed(String fullName, String userName, String profile_picture) {
        this.fullName = fullName;
        this.userName = userName;
        this.profile_picture = profile_picture;
    }

    public Followed() {
    }
}
