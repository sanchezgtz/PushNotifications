package com.sancheztech.mascota;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.sancheztech.mascota.adaptadores.MascotaAdapter;
import com.sancheztech.mascota.pojo.ConstructorContactos;
import com.sancheztech.mascota.pojo.Mascota;
import com.sancheztech.mascota.presentador.IMascotaPresentador;
import com.sancheztech.mascota.presentador.MascotaPresentador;
import com.sancheztech.mascota.vista.fragment.IMascotaRecyclerView;

import java.util.ArrayList;

public class RankinActivity extends AppCompatActivity implements IMascotaRecyclerView {

    private ArrayList<Mascota> mascotas;
    private RecyclerView reciclador;
    private RecyclerView.LayoutManager lManager;
    private RecyclerView.Adapter adaptador;
    private IMascotaPresentador presentador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rankin);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        CreaLista();
    }
    private void CreaLista() {
        reciclador = (RecyclerView) findViewById(R.id.rvMascotasRankin);
        presentador = new MascotaPresentador(this, this.getBaseContext());
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

    @Override
    public void generarLinearLayout() {
        lManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        reciclador.setLayoutManager(lManager);
    }

    @Override
    public MascotaAdapter crearAdaptadorMascota(ArrayList<Mascota> mascotas) {
        MascotaAdapter adaptador = new MascotaAdapter(mascotas, this);
        return adaptador;
    }

    @Override
    public void inicializaAdaptadorMascota(MascotaAdapter adapter) {
        reciclador.setAdapter(adapter);
    }
}
