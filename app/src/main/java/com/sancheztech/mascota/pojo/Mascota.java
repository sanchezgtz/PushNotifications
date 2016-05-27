package com.sancheztech.mascota.pojo;

/**
 * Created by rsanchezgu on 10/05/2016.
 */
public class Mascota {

    private int id;
    private int raiting;
    private int foto;
    private String nombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRaiting() {
        return raiting;
    }

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Mascota(int raiting, int foto, String nombre) {
        this.raiting = raiting;
        this.foto = foto;
        this.nombre = nombre;
    }

    public Mascota(){

    }
}
