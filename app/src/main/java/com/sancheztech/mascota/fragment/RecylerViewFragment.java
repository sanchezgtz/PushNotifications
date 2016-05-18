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
    public RecylerViewFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(10, R.drawable.imgperro,"Fido" ));
        mascotas.add(new Mascota(3, R.drawable.imgardilla,"Manchas" ));
        mascotas.add(new Mascota(4, R.drawable.imgcaballo,"Filemon" ));
        mascotas.add(new Mascota(0, R.drawable.imgconejo,"Copo de nieve" ));
        mascotas.add(new Mascota(5, R.drawable.imgvenado,"Mido" ));
        mascotas.add(new Mascota(6, R.drawable.imggallina,"Pancha" ));
        reciclador = (RecyclerView) v.findViewById(R.id.rvMascotas);
        lManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        reciclador.setLayoutManager(lManager);

        adaptador = new MascotaAdapter(mascotas, getActivity());
        reciclador.setAdapter(adaptador);
        return v;
    }
}
