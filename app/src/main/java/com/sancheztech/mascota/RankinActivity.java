package com.sancheztech.mascota;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.sancheztech.mascota.adaptadores.MascotaAdapter;
import com.sancheztech.mascota.pojo.Mascota;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RankinActivity extends AppCompatActivity {

    private ArrayList<Mascota> mascotas;
    private RecyclerView reciclador;
    private RecyclerView.LayoutManager lManager;
    private RecyclerView.Adapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rankin);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        InicializaDatos();
        CreaLista();
    }

    private void InicializaDatos() {

        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(10, R.drawable.imgperro,"Fido" ));
        mascotas.add(new Mascota(3, R.drawable.imgardilla,"Manchas" ));
        mascotas.add(new Mascota(4, R.drawable.imgcaballo,"Filemon" ));
        mascotas.add(new Mascota(0, R.drawable.imgconejo,"Copo de nieve" ));
        mascotas.add(new Mascota(5, R.drawable.imgvenado,"Mido" ));
            mascotas.add(new Mascota(6, R.drawable.imggallina,"Pancha" ));

        Collections.sort(mascotas, new Comparator<Mascota>(){

            @Override
            public int compare(Mascota lhs, Mascota rhs) {
                return lhs.getRaiting() - rhs.getRaiting();
            }
        });

        mascotas.remove(0);
        Collections.reverse(mascotas);

    }
    private void CreaLista() {
        reciclador = (RecyclerView) findViewById(R.id.rvMascotasRankin);
        lManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        reciclador.setLayoutManager(lManager);

        adaptador = new MascotaAdapter(mascotas, this);
        reciclador.setAdapter(adaptador);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        return true;
    }
}
