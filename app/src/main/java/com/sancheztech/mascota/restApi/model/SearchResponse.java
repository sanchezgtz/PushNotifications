package com.sancheztech.mascota.restApi.model;

import com.sancheztech.mascota.pojo.Followed;

/**
 * Created by rsanchezgu on 23/06/2016.
 */
public class SearchResponse {
    Followed cuenta;

    public Followed getCuenta() {
        return cuenta;
    }

    public void setCuenta(Followed cuenta) {
        this.cuenta = cuenta;
    }
}
