package com.sancheztech.mascota.restApi.model;

import com.sancheztech.mascota.pojo.Followed;

import java.util.ArrayList;

/**
 * Created by rsanchezgu on 23/06/2016.
 */
public class FollowedResponse {

    ArrayList<Followed> followeds;

    public ArrayList<Followed> getFolloweds() {
        return followeds;
    }

    public void setFolloweds(ArrayList<Followed> followeds) {
        this.followeds = followeds;
    }
}
