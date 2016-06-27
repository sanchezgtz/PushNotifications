package com.sancheztech.mascota.adaptadores;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sancheztech.mascota.R;
import com.sancheztech.mascota.pojo.ConstructorContactos;
import com.sancheztech.mascota.pojo.Mascota;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by rsanchezgu on 11/05/2016.
 */
public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.mascotaViewHolder> {

    private ArrayList<Mascota> mascotaLista;
    Activity activity;
    private ConstructorContactos helper;

    public MascotaAdapter(ArrayList<Mascota> mascotaLista, Activity activity) {
        this.mascotaLista = mascotaLista;
        this.activity = activity;
    }

    @Override
    public mascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.mascota, parent, false);

        mascotaViewHolder mascota = new mascotaViewHolder(v);
        return mascota;
    }

    @Override
    public void onBindViewHolder(final mascotaViewHolder holder, int position) {
        final Mascota mascota =  mascotaLista.get(position);
        holder.tvRanking.setText(String.valueOf( mascota.getLikes()));

        Picasso.with(activity)
                .load(mascota.getUrlFoto())
                .placeholder(R.drawable.imgperro)
                .into(holder.imgFoto);


        holder.btnRanquear.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "diste like (demo)",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotaLista.size();
    }

    public class mascotaViewHolder extends RecyclerView.ViewHolder {

        TextView tvRanking;
        ImageView imgFoto;
        ImageButton btnRanquear;


        public mascotaViewHolder(View itemView) {
            super(itemView);

            tvRanking = (TextView) itemView.findViewById(R.id.tvRanking);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            btnRanquear = (ImageButton) itemView.findViewById(R.id.btnReiting);

        }
    }
}
