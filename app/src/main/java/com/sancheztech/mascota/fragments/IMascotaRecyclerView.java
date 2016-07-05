package com.sancheztech.mascota.fragments;

import com.sancheztech.mascota.adaptadores.MascotaAdapter;
import com.sancheztech.mascota.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by rsanchezgu on 23/06/2016.
 */
public interface IMascotaRecyclerView {

    public void generarLinearLayout();
    public MascotaAdapter crearAdaptadorMascota(ArrayList<Mascota> mascotas);
    public void inicializaAdaptadorMascota(MascotaAdapter adapter);

}
