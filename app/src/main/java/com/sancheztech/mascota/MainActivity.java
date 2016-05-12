package com.sancheztech.mascota;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Mascota> mascotas;
    private RecyclerView reciclador;
    private RecyclerView.LayoutManager lManager;
    private RecyclerView.Adapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        InicializaDatos();
        CrearLista();
    }

    private void CrearLista() {
        reciclador = (RecyclerView) findViewById(R.id.rvMascotas);
        lManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        reciclador.setLayoutManager(lManager);

        adaptador = new MascotaAdapter(mascotas, this);
        reciclador.setAdapter(adaptador);
    }

    private void InicializaDatos() {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(10, R.drawable.imgperro,"Fido" ));
        mascotas.add(new Mascota(3, R.drawable.imgardilla,"Manchas" ));
        mascotas.add(new Mascota(4, R.drawable.imgcaballo,"Filemon" ));
        mascotas.add(new Mascota(0, R.drawable.imgconejo,"Copo de nieve" ));
        mascotas.add(new Mascota(5, R.drawable.imgvenado,"Mido" ));
        mascotas.add(new Mascota(6, R.drawable.imggallina,"Pancha" ));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_mascota, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.action_salir:
                finish();
                return  true;
            case R.id.action_ranking:
            case R.id.menu_rankin:
                Intent intent = new Intent(this, RankinActivity.class);
                startActivityForResult(intent, 0);
                return true;
            default:
                return  false;
        }
    }
}
