package com.sancheztech.mascota;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.sancheztech.mascota.pojo.ConstructorContactos;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    private boolean status = false;
    private String perfilInstagram;
    private static final long SPLASH_SCREEN_DELAY = 1500;
    ConstructorContactos helpers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        ObtenerPerfilShared();
        if(perfilInstagram.equals("")){
            crearPerfilShared();
        }

        obtenerShared();

        if( !status ){
            helpers = new ConstructorContactos(SplashActivity.this);
            helpers.insertarMascotas();
            guardarShared(true);
        }


        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                // Start the next activity
                Intent mainIntent = new Intent().setClass(
                        SplashActivity.this, MainActivity.class);
                startActivity(mainIntent);

                // Close the activity so the user won't able to go back this
                // activity pressing Back button
                finish();
            }
        };

        // Simulate a long loading process on application startup.
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);


    }

    private void crearPerfilShared() {
        SharedPreferences perfilInstagram = getSharedPreferences("shared", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = perfilInstagram.edit();
        editor.putString("perfilInstagram", "pato_856");
        editor.commit();
    }

    private void ObtenerPerfilShared(){
        SharedPreferences misReferencias = getSharedPreferences("shared", Context.MODE_PRIVATE);
        perfilInstagram = misReferencias.getString("perfilInstagram", "");
    }

    private void obtenerShared() {
        SharedPreferences misReferencias = getSharedPreferences("shared", Context.MODE_PRIVATE);
        status = misReferencias.getBoolean("isLoad", false);
    }

    private void guardarShared(boolean _status){
        SharedPreferences misReferencias= getSharedPreferences("shared", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= misReferencias.edit();
        editor.putBoolean("isLoad", _status);
        editor.commit();
    }
}

