package com.sancheztech.mascota.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.sancheztech.mascota.pojo.ConstructorContactos;
import com.sancheztech.mascota.pojo.Followed;
import com.sancheztech.mascota.pojo.Mascota;
import com.sancheztech.mascota.restApi.EndpointsApi;
import com.sancheztech.mascota.restApi.adapter.RestApiAdapter;
import com.sancheztech.mascota.restApi.model.FollowedResponse;
import com.sancheztech.mascota.restApi.model.ImageListResponse;
import com.sancheztech.mascota.fragments.IMascotaRecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by rsanchezgu on 23/06/2016.
 */
public class MascotaPresentador  implements IMascotaPresentador{

    IMascotaRecyclerView iMascotaRecyclerView;
    private Context context;
    private ArrayList<Mascota> mascotas;
    private ArrayList<Followed> followeds;
    private ArrayList<Mascota> mascotasTemp;

    public MascotaPresentador(IMascotaRecyclerView iMascotaRecyclerView, Context context) {
        this.iMascotaRecyclerView = iMascotaRecyclerView;
        this.context = context;
        //obtenerMascotas();
        obtenerFollowed();

    }



    @Override
    public void obtenerMascotas() {
        ConstructorContactos constructorContactos = new ConstructorContactos(context);
        mascotas = constructorContactos.obtenerMascotaAll();
        mostrarMascotasRV();
    }

    @Override
    public void obtenerCincoMascotas() {
        ConstructorContactos constructorContactos = new ConstructorContactos(context);
        mascotas = constructorContactos.obtenerMascotaCinco();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iMascotaRecyclerView.inicializaAdaptadorMascota(iMascotaRecyclerView.crearAdaptadorMascota(mascotas));
        iMascotaRecyclerView.generarLinearLayout();
    }

    @Override
    public void obtenerMascotasInstagram() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gson = restApiAdapter.construyendoDeserealizadorMascotas();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gson);

        mascotas = new ArrayList<>();

        for(int i = 0; i < followeds.size(); i++){

                String id = followeds.get(i).getId();
                Call<ImageListResponse> imageListResponseCall = endpointsApi.getRecentMediaOther(id);
                imageListResponseCall.enqueue(new Callback<ImageListResponse>() {
                    @Override
                    public void onResponse(Call<ImageListResponse> call, Response<ImageListResponse> response) {
                        ImageListResponse imageListResponse = response.body();
                        if(imageListResponse != null){
                            mascotasTemp = imageListResponse.getMascotas();
                            if(mascotasTemp.size() > 0)
                                mascotas.addAll(mascotasTemp);
                            mostrarMascotasRV();
                        }
                    }

                    @Override
                    public void onFailure(Call<ImageListResponse> call, Throwable t) {
                        Toast.makeText(context,"Mascotas: "+ t.toString(), Toast.LENGTH_LONG).show();
                        Log.e("FALLO LA CONEXION",t.toString());
                    }
                });
        }

    }

    @Override
    public void obtenerFollowed() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gson = restApiAdapter.construyeDeserealizadorFollowedBy();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gson);
        Call<FollowedResponse> followedResponseCall = endpointsApi.getFollowedBy();
        followedResponseCall.enqueue(new Callback<FollowedResponse>(){
            @Override
            public void onResponse(Call<FollowedResponse> call, Response<FollowedResponse> response) {
                FollowedResponse followedResponse = response.body();
                followeds = followedResponse.getFolloweds();
                /*followeds = new ArrayList<Followed>();*/
                Followed yo = new Followed();
                yo.setId("3436368772");
                yo.setUserName("pato_856");
                followeds.add(yo);
                obtenerMascotasInstagram();
            }

            @Override
            public void onFailure(Call<FollowedResponse> call, Throwable t) {
                Toast.makeText(context,"Followed "+ t.toString(), Toast.LENGTH_LONG).show();
                Log.e("FALLO LA CONEXION",t.toString());
            }
        });
    }



}
