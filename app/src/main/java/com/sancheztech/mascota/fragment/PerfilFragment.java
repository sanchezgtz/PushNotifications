package com.sancheztech.mascota.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mikhaellopez.circularimageview.CircularImageView;
import com.sancheztech.mascota.R;
import com.sancheztech.mascota.adaptadores.MascotaAdapter;
import com.sancheztech.mascota.adaptadores.MascotaPerfilAdaptador;
import com.sancheztech.mascota.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by rsanchezgu on 16/05/2016.
 */
public class PerfilFragment extends Fragment {

    private ArrayList<Mascota> mascotas;
    private RecyclerView reciclador;
    private RecyclerView.LayoutManager lManager;
    private RecyclerView.Adapter adaptador;
    private GridLayoutManager lLayout;

    public PerfilFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        CircularImageView circularImageView = (CircularImageView)v.findViewById(R.id.civPerfil);
// Set Border
        circularImageView.setBorderColor(getResources().getColor(R.color.GrayLight));
        circularImageView.setBorderWidth(10);
// Add Shadow with default param
        circularImageView.addShadow();
// or with custom param
        circularImageView.setShadowRadius(15);
        circularImageView.setShadowColor(Color.RED);

        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(7, R.drawable.imgperro,"Fido" ));
        mascotas.add(new Mascota(9, R.drawable.imgperro,"Fido" ));
        mascotas.add(new Mascota(4, R.drawable.imgperro,"Fido" ));
        mascotas.add(new Mascota(1, R.drawable.imgperro,"Fido" ));
        mascotas.add(new Mascota(3, R.drawable.imgperro,"Fido" ));
        mascotas.add(new Mascota(6, R.drawable.imgperro,"Fido" ));
        mascotas.add(new Mascota(8, R.drawable.imgperro,"Fido" ));
        mascotas.add(new Mascota(10, R.drawable.imgperro,"Fido" ));
        mascotas.add(new Mascota(2, R.drawable.imgperro,"Fido" ));
        mascotas.add(new Mascota(5, R.drawable.imgperro,"Fido" ));
        mascotas.add(new Mascota(11, R.drawable.imgperro,"Fido" ));
        mascotas.add(new Mascota(12, R.drawable.imgperro,"Fido" ));

        reciclador = (RecyclerView) v.findViewById(R.id.rvGridPerfil);
        reciclador.setHasFixedSize(true);
        lLayout = new GridLayoutManager(getActivity(), 3);
        reciclador.setLayoutManager(lLayout);

        adaptador = new MascotaPerfilAdaptador(mascotas, getActivity());
        reciclador.setAdapter(adaptador);


        return v;
    }
}
