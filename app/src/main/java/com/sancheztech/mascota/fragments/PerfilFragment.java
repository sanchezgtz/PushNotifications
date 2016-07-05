package com.sancheztech.mascota.fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;
import com.sancheztech.mascota.R;
import com.sancheztech.mascota.adaptadores.MascotaPerfilAdaptador;
import com.sancheztech.mascota.pojo.Followed;
import com.sancheztech.mascota.pojo.Mascota;
import com.sancheztech.mascota.presentador.IPerfilPresentador;
import com.sancheztech.mascota.presentador.PerfilPresentador;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */


/**
 * Created by rsanchezgu on 16/05/2016.
 */
public class PerfilFragment extends Fragment implements IPerfilRecyclerView {

    private ArrayList<Mascota> mascotas;
    private RecyclerView reciclador;
    private RecyclerView.LayoutManager lManager;
    private RecyclerView.Adapter adaptador;
    private GridLayoutManager lLayout;
    private IPerfilPresentador presentador;
    private CircularImageView circularImageView;
    private TextView tvNombrePerfil;

    public PerfilFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        circularImageView = (CircularImageView)v.findViewById(R.id.civPerfil);
        tvNombrePerfil = (TextView)v.findViewById(R.id.tvNombrePerfil);
        configImagenCircular();
        reciclador = (RecyclerView) v.findViewById(R.id.rvGridPerfil);
        presentador = new PerfilPresentador(this, getContext(), obtieneCuentaInstagram());
        return v;
    }

    private String obtieneCuentaInstagram() {
        SharedPreferences misReferencias =  this.getActivity().getSharedPreferences("shared", Context.MODE_PRIVATE);
        return misReferencias.getString("perfilInstagram", "");
    }

    private void configImagenCircular() {
        circularImageView.setBorderColor(getResources().getColor(R.color.GrayLight));
        circularImageView.setBorderWidth(10);
        circularImageView.addShadow();
        circularImageView.setShadowRadius(15);
        circularImageView.setShadowColor(Color.RED);
    }

    @Override
    public void generarGridLayout() {

        lLayout = new GridLayoutManager(getActivity(), 3);
        reciclador.setLayoutManager(lLayout);
    }

    @Override
    public MascotaPerfilAdaptador crearAdaptadorPerfil(ArrayList<Mascota> mascotas) {
        MascotaPerfilAdaptador adaptador = new MascotaPerfilAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializaAdaptadorPerfil(MascotaPerfilAdaptador adapter) {
        reciclador.setHasFixedSize(true);
        reciclador.setAdapter(adapter);
    }

    @Override
    public void creaImagenPerfil(Followed perfilUsaurio) {
        Picasso.with(getActivity())
                .load(perfilUsaurio.getProfile_picture())
                .placeholder(R.drawable.imgperro)
                .into(circularImageView);

        tvNombrePerfil.setText(perfilUsaurio.getUserName());

    }
}