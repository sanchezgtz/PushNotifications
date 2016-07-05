package com.sancheztech.mascota.fragments;

import com.sancheztech.mascota.adaptadores.MascotaPerfilAdaptador;
import com.sancheztech.mascota.pojo.Followed;
import com.sancheztech.mascota.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by rsanchezgu on 23/06/2016.
 */
public interface IPerfilRecyclerView {
    public void generarGridLayout();
    public MascotaPerfilAdaptador crearAdaptadorPerfil(ArrayList<Mascota> mascotas);
    public void inicializaAdaptadorPerfil(MascotaPerfilAdaptador adapter);
    public void creaImagenPerfil(Followed perfilUsuario);
}
