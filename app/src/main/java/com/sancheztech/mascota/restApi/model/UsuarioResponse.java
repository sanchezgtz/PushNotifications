package com.sancheztech.mascota.restApi.model;

/**
 * Created by rsanchezgu on 04/07/2016.
 */
public class UsuarioResponse {

    private String id;
    private String toke;
    private String instagram;

    public UsuarioResponse(String id, String toke, String instagram) {
        this.id = id;
        this.toke = toke;
        this.instagram = instagram;
    }

    public UsuarioResponse() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToke() {
        return toke;
    }

    public void setToke(String toke) {
        this.toke = toke;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }
}
