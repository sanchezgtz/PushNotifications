package com.sancheztech.mascota.adaptadores;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sancheztech.mascota.R;
import com.sancheztech.mascota.database.ConstructorContactos;
import com.sancheztech.mascota.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by rsanchezgu on 18/05/2016.
 */
public class MascotaPerfilAdaptador  extends RecyclerView.Adapter<MascotaPerfilAdaptador.MsscotaPerfilViewHolder>{

    private ArrayList<Mascota> mascotaLista;
    Activity activity;


    public MascotaPerfilAdaptador(ArrayList<Mascota> mascotaLista, Activity activity) {
        this.mascotaLista = mascotaLista;
        this.activity = activity;
    }

    @Override
    public MsscotaPerfilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.mascotaperfil, parent, false);
        MsscotaPerfilViewHolder mascota = new MsscotaPerfilViewHolder(v);
        return mascota;
    }

    @Override
    public void onBindViewHolder(MsscotaPerfilViewHolder holder, int position) {
        final Mascota mascota = mascotaLista.get(position);
        holder.tvRankingPerfil.setText(String.valueOf( mascota.getRaiting()));
        holder.imgFoto.setImageResource(mascota.getFoto());
    }

    @Override
    public int getItemCount() {
        return mascotaLista.size();
    }

    public class MsscotaPerfilViewHolder extends RecyclerView.ViewHolder{

        ImageView imgFoto;
        TextView tvRankingPerfil;

        public MsscotaPerfilViewHolder(View itemView) {
            super(itemView);

            tvRankingPerfil = (TextView) itemView.findViewById(R.id.tvRankingPerfil);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFotoPerfil);
        }
    }
}
