package com.sancheztech.mascota.pojo;

import android.content.ContentValues;
import android.content.Context;

import com.sancheztech.mascota.R;
import com.sancheztech.mascota.database.BaseDatos;
import com.sancheztech.mascota.database.ConstantesBaseDatos;
import com.sancheztech.mascota.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by rsanchezgu on 26/05/2016.
 */
public class ConstructorContactos {
    private static final int LIKE = 1;
    private Context context;

    public ConstructorContactos(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerMascotaAll(){
        BaseDatos db = new BaseDatos(context);
        //insertarMascotas(db);
        return db.obtenerMascotasLista();
    }

    public void insertarMascotas() {
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Fido");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.imgperro);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Manchas");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.imgardilla);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Filemon");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.imgcaballo);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Copo de nieve");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.imgconejo);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Mido");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.imgvenado);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Pancha");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.imggallina);
        db.insertarMascota(contentValues);

    }

    public ArrayList<Mascota> obtenerMascotaCinco(){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerMascotaCinco();
    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_ID_MASCOTA, mascota.getIdUser());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_NUMERO_LIKES, LIKE);
        db.insertarLikeMascota(contentValues);
    }

    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikeMascota(mascota);
    }

    public ArrayList<Mascota> obtenerPerfil(){
        ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
        /*mascotas.add(new Mascota(7, R.drawable.imgperro,"Fido" ));
        mascotas.add(new Mascota(9, R.drawable.imgperro,"Fido" ));
        mascotas.add(new Mascota(4, R.drawable.imgperro,"Fido" ));
        mascotas.add(new Mascota(1, R.drawable.imgperro,"Fido" ));
        mascotas.add(new Mascota(3, R.drawable.imgperro,"Fido" ));
        mascotas.add(new Mascota(6, R.drawable.imgperro,"Fido" ));
        mascotas.add(new Mascota(8, R.drawable.imgperro,"Fido" ));
        mascotas.add(new Mascota(10, R.drawable.imgperro,"Fido" ));
        mascotas.add(new Mascota(2, R.drawable.imgperro,"Fido" ));
        mascotas.add(new Mascota(5, R.drawable.imgperro,"Fido" ));
        mascotas.add(new Mascota(11, R.drawable.imgperro,"Fido" ));
        mascotas.add(new Mascota(12, R.drawable.imgperro,"Fido" ));*/
        return mascotas;
    }
}
