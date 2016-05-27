package com.sancheztech.mascota.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.sancheztech.mascota.pojo.Mascota;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by rsanchezgu on 26/05/2016.
 */
public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        Log.i("tabla mascota", ConstantesBaseDatos.DATABASE_NAME);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTA  + " ( " +
                ConstantesBaseDatos.TABLE_MASCOTA_ID       + " integer primary key autoincrement, " +
                ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE   + " text, " +
                ConstantesBaseDatos.TABLE_MASCOTA_FOTO     + " integer " +
                " ); ";

        String queryCrearTablaLikes = "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES + " ( " +
                ConstantesBaseDatos.TABLE_LIKES_ID              + " integer primary key autoincrement, " +
                ConstantesBaseDatos.TABLE_LIKES_ID_MASCOTA     + " integer, " +
                ConstantesBaseDatos.TABLE_LIKES_NUMERO_LIKES    + " integer, " +
                "FOREIGN KEY ( " +ConstantesBaseDatos.TABLE_LIKES_ID_MASCOTA + " ) "+
                "REFERENCES " + ConstantesBaseDatos.TABLE_MASCOTA + " ( "+ ConstantesBaseDatos.TABLE_MASCOTA_ID +" ) "+
                " );";

        db.execSQL(queryCrearTablaMascota);
        Log.i("tabla mascota", queryCrearTablaMascota);

        db.execSQL(queryCrearTablaLikes);
        Log.i("tabla mascota_likes", queryCrearTablaLikes);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ ConstantesBaseDatos.TABLE_MASCOTA );
        db.execSQL("DROP TABLE IF EXISTS "+ ConstantesBaseDatos.TABLE_LIKES);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerMascotasLista(){
        ArrayList<Mascota> listaMascota = new ArrayList<Mascota>();
        String query = "SELECT * FROM "+ ConstantesBaseDatos.TABLE_MASCOTA ;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        while(cursor.moveToNext()){
            Mascota item = new Mascota();
            item.setId(cursor.getInt(0));
            item.setNombre(cursor.getString(1));
            item.setFoto(cursor.getInt(2));

            String queryLike = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_NUMERO_LIKES+") AS LIKES" +
                    " FROM " + ConstantesBaseDatos.TABLE_LIKES +
                    " WHERE " + ConstantesBaseDatos.TABLE_LIKES_ID_MASCOTA + " = "+item.getId();

            Cursor cursorLike = db.rawQuery(queryLike, null);
            if(cursorLike.moveToNext()){
                item.setRaiting(cursorLike.getInt(0));
            }
            else{
                item.setRaiting(0);
            }

            listaMascota.add(item);
        }

        db.close();


        return listaMascota;
    }

    public ArrayList<Mascota> obtenerMascotaCinco(){
        ArrayList<Mascota> listaMascota = new ArrayList<Mascota>();
        String query = "SELECT * FROM "+ ConstantesBaseDatos.TABLE_MASCOTA;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        while(cursor.moveToNext()){
            Mascota item = new Mascota();
            item.setId(cursor.getInt(0));
            item.setNombre(cursor.getString(1));
            item.setFoto(cursor.getInt(2));

            String queryLike = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_NUMERO_LIKES+") AS LIKES" +
                    " FROM " + ConstantesBaseDatos.TABLE_LIKES +
                    " WHERE " + ConstantesBaseDatos.TABLE_LIKES_ID_MASCOTA + " = "+item.getId();

            Cursor cursorLike = db.rawQuery(queryLike, null);
            if(cursorLike.moveToNext()){
                item.setRaiting(cursorLike.getInt(0));
            }
            else{
                item.setRaiting(0);
            }

            listaMascota.add(item);
        }

        db.close();

        //-- ordenar
        Collections.sort(listaMascota, new Comparator<Mascota>(){

            @Override
            public int compare(Mascota lhs, Mascota rhs) {
                return lhs.getRaiting() - rhs.getRaiting();
            }
        });
        Collections.reverse(listaMascota);

        listaMascota= new ArrayList<>(listaMascota.subList(0,5));


        return listaMascota;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTA, null, contentValues);
        Log.i("insertar en ",ConstantesBaseDatos.TABLE_MASCOTA);
        db.close();
    }

    public void insertarLikeMascota (ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES, null, contentValues);
        db.close();
    }

    public int obtenerLikeMascota(Mascota mascota){
        int likes = 0;
        String query  = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_NUMERO_LIKES +")" +
                " FROM " + ConstantesBaseDatos.TABLE_LIKES +
                " WHERE " + ConstantesBaseDatos.TABLE_LIKES_ID_MASCOTA + " = " + mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToNext()){
            likes = cursor.getInt(0);
        }

        db.close();
        return  likes;
    }
}
