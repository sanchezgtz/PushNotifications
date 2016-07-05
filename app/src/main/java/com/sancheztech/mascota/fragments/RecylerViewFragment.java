package com.sancheztech.mascota.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sancheztech.mascota.R;
import com.sancheztech.mascota.adaptadores.MascotaAdapter;
import com.sancheztech.mascota.pojo.Mascota;
import com.sancheztech.mascota.presentador.IMascotaPresentador;
import com.sancheztech.mascota.presentador.MascotaPresentador;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecylerViewFragment extends Fragment implements IMascotaRecyclerView {

    private ArrayList<Mascota> mascotas;
    private RecyclerView reciclador;
    private RecyclerView.LayoutManager lManager;
    private IMascotaPresentador presentador;

    public RecylerViewFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);
        reciclador = (RecyclerView) v.findViewById(R.id.rvMascotas);
        presentador = new MascotaPresentador(this, getContext());
        return v;
    }

    @Override
    public void generarLinearLayout() {
        lManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        reciclador.setLayoutManager(lManager);
    }

    @Override
    public MascotaAdapter crearAdaptadorMascota(ArrayList<Mascota> mascotas) {
        MascotaAdapter adaptador = new MascotaAdapter(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializaAdaptadorMascota(MascotaAdapter adapter) {
        reciclador.setAdapter(adapter);
    }
}
