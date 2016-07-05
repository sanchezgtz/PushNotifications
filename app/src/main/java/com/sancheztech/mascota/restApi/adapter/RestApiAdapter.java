package com.sancheztech.mascota.restApi.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sancheztech.mascota.restApi.ConstantesRestApi;
import com.sancheztech.mascota.restApi.EndpointsApi;
import com.sancheztech.mascota.restApi.deserealizador.FollowebByDeserealizador;
import com.sancheztech.mascota.restApi.deserealizador.ImageListDeserealizador;
import com.sancheztech.mascota.restApi.deserealizador.PerfilDeserealizador;
import com.sancheztech.mascota.restApi.deserealizador.SearchDeserealizador;
import com.sancheztech.mascota.restApi.model.FollowedResponse;
import com.sancheztech.mascota.restApi.model.ImageListResponse;
import com.sancheztech.mascota.restApi.model.PerfilUserResponse;
import com.sancheztech.mascota.restApi.model.SearchResponse;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rsanchezgu on 23/06/2016.
 */
public class RestApiAdapter {
    public EndpointsApi establecerConexionRestApiInstagram(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(EndpointsApi.class);
    }

    public Gson construyeDeserealizadorFollowedBy(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(FollowedResponse.class, new FollowebByDeserealizador());
        return gsonBuilder.create();
    }

    public Gson construyendoDeserealizadorMascotas(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ImageListResponse.class, new ImageListDeserealizador());
        return gsonBuilder.create();
    }

    public Gson construyendoDeserealizadorSearch() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(SearchResponse.class, new SearchDeserealizador());
        return gsonBuilder.create();
    }

    public Gson construyendoDeserealizadorMascotaPerfil(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(PerfilUserResponse.class, new PerfilDeserealizador());
        return gsonBuilder.create();
    }

    public EndpointsApi establecerConexionRestAPI(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL_FIREBASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(EndpointsApi.class);
    }
}
