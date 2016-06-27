package com.sancheztech.mascota.presentador;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.google.gson.Gson;
import com.sancheztech.mascota.pojo.ConstructorContactos;
import com.sancheztech.mascota.pojo.Followed;
import com.sancheztech.mascota.pojo.Mascota;
import com.sancheztech.mascota.restApi.ConstantesRestApi;
import com.sancheztech.mascota.restApi.EndpointsApi;
import com.sancheztech.mascota.restApi.adapter.RestApiAdapter;
import com.sancheztech.mascota.restApi.model.ImageListResponse;
import com.sancheztech.mascota.restApi.model.PerfilUserResponse;
import com.sancheztech.mascota.restApi.model.SearchResponse;
import com.sancheztech.mascota.vista.fragment.IPerfilRecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by rsanchezgu on 23/06/2016.
 */
public class PerfilPresentador implements IPerfilPresentador{

    IPerfilRecyclerView iPerfilRecyclerView;
    private Context context;
    private ArrayList<Mascota> mascotas;
    private Followed usuario;
    private String cuentaInstagram;


    public PerfilPresentador(IPerfilRecyclerView iPerfilRecyclerView, Context context, String cuentaUser) {
        this.iPerfilRecyclerView = iPerfilRecyclerView;
        this.context = context;
        this.cuentaInstagram = cuentaUser;
        obtenerFotoPerfilInstagram();
    }

    @Override
    public void obtenerPerfil() {
        ConstructorContactos constructorContactos = new ConstructorContactos(context);
        mascotas = constructorContactos.obtenerPerfil();
        mostrarPerfilRV();
    }

    @Override
    public void mostrarPerfilRV() {
        iPerfilRecyclerView.creaImagenPerfil(usuario);
        iPerfilRecyclerView.inicializaAdaptadorPerfil(iPerfilRecyclerView.crearAdaptadorPerfil(mascotas));
        iPerfilRecyclerView.generarGridLayout();
    }

    @Override
    public void obtenerPerfilInsagram() {
        if(!usuario.getUserName().equals("No encontrado")){
            RestApiAdapter  restApiAdapter = new RestApiAdapter();
            Gson gson = restApiAdapter.construyendoDeserealizadorMascotaPerfil();
            EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gson);
            mascotas = new ArrayList<>();
            Call<PerfilUserResponse> perfilUserResponseCall = endpointsApi.getRecentMediaOtherPerfil(usuario.getId());
            perfilUserResponseCall.enqueue(new Callback<PerfilUserResponse>() {
                @Override
                public void onResponse(Call<PerfilUserResponse> call, Response<PerfilUserResponse> response) {
                    PerfilUserResponse perfilUserResponse = response.body();
                    mascotas = perfilUserResponse.getMascotas();
                    mostrarPerfilRV();
                }

                @Override
                public void onFailure(Call<PerfilUserResponse> call, Throwable t) {
                    Toast.makeText(context, "Perfil:" + t.toString() , Toast.LENGTH_SHORT).show();
                }
            });
        }
        else{
            mascotas =  new ArrayList<>();
            mostrarPerfilRV();
        }
    }

    @Override
    public void obtenerFotoPerfilInstagram() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gson = restApiAdapter.construyendoDeserealizadorSearch();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gson);

        Call<SearchResponse> searchResponseCall = endpointsApi.getUsuarioByBusqueda(cuentaInstagram, ConstantesRestApi.ACCES_TOKEN);
        searchResponseCall.enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                SearchResponse searchResponse =  response.body();
                usuario = searchResponse.getCuenta();
                if(!usuario.getUserName().equals("NoEncontrado"))
                    obtenerPerfilInsagram();
                else{
                    usuario.setUserName("No encontrado");
                    obtenerPerfilInsagram();
                }
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                Toast.makeText(context, "Perfil: "+ t.toString(), Toast.LENGTH_LONG).show();
            }
        });
        //cuenta
    }


}
