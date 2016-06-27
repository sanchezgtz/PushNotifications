package com.sancheztech.mascota.pojo;

/**
 * Created by rsanchezgu on 10/05/2016.
 */
public class Mascota {

    public String idUser;
    public int likes;
    public String urlFoto;

    public Mascota() {
    }

    public Mascota(int likes, String urlFoto) {
        this.likes = likes;
        this.urlFoto = urlFoto;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }
}
