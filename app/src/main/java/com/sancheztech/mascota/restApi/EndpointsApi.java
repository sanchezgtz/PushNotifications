package com.sancheztech.mascota.restApi;

import com.sancheztech.mascota.restApi.model.FollowedResponse;
import com.sancheztech.mascota.restApi.model.ImageListResponse;
import com.sancheztech.mascota.restApi.model.PerfilUserResponse;
import com.sancheztech.mascota.restApi.model.SearchResponse;
import com.sancheztech.mascota.restApi.model.UsuarioResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by rsanchezgu on 23/06/2016.
 */
public interface EndpointsApi {

    @GET(ConstantesRestApi.URL_GET_FOLLOWEDBY)
    Call<FollowedResponse> getFollowedBy();

    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER)
    Call<PerfilUserResponse> getRecentMediaUser();

    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_OTHER)
    Call<ImageListResponse> getRecentMediaOther(@Path("id") String id);

    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_OTHER)
    Call<PerfilUserResponse> getRecentMediaOtherPerfil(@Path("id") String id);

    @GET(ConstantesRestApi.URL_SEARCH_USER)
    Call<SearchResponse> getUsuarioByBusqueda(@Query("q") String jack, @Query("access_token") String access_token);

    @FormUrlEncoded
    @POST(ConstantesRestApi.KEY_POST_ID_TOKEN)
    Call<UsuarioResponse> registrarTokenID(@Field("token") String token, @Field("instagram") String instagram);

}
