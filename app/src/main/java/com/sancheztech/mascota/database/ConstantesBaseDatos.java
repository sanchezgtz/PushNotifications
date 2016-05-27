package com.sancheztech.mascota.database;

/**
 * Created by rsanchezgu on 26/05/2016.
 */
public final class ConstantesBaseDatos {

    public static final String DATABASE_NAME = "mascotas.db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_MASCOTA           = "mascotaTabla";
    public static final String TABLE_MASCOTA_ID        = "id_mascota";
    public static final String TABLE_MASCOTA_NOMBRE    = "nombre";
    public static final String TABLE_MASCOTA_FOTO       = "foto";

    public static final String TABLE_LIKES              = "mascota_likesTabla";
    public static final String TABLE_LIKES_ID           = "id_like";
    public static final String TABLE_LIKES_ID_MASCOTA   = "id_mascota";
    public static final String TABLE_LIKES_NUMERO_LIKES = "numero_likes";
}
