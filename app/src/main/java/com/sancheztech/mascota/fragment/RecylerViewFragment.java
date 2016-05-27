package com.sancheztech.mascota.fragment;

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
import com.sancheztech.mascota.database.ConstructorContactos;
import com.sancheztech.mascota.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by rsanchezgu on 16/05/2016.
 */
public class RecylerViewFragment extends Fragment {


    private ArrayList<Mascota> mascotas;
    private RecyclerView reciclador;
    private RecyclerView.LayoutManager lManager;
    private RecyclerView.Adapter adaptador;

    private ConstructorContactos helper;
    public RecylerViewFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        //--
        helper = new ConstructorContactos(getActivity());
        mascotas = helper.obtenerMascotaAll();

        reciclador = (RecyclerView) v.findViewById(R.id.rvMascotas);
        lManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        reciclador.setLayoutManager(lManager);

        adaptador = new MascotaAdapter(mascotas, getActivity());
        reciclador.setAdapter(adaptador);
        return v;
    }
}
