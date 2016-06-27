package com.sancheztech.mascota.restApi.deserealizador;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.sancheztech.mascota.pojo.Mascota;
import com.sancheztech.mascota.restApi.JsonKeys;
import com.sancheztech.mascota.restApi.model.ImageListResponse;
import com.sancheztech.mascota.restApi.model.PerfilUserResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by rsanchezgu on 27/06/2016.
 */
public class PerfilDeserealizador implements JsonDeserializer<PerfilUserResponse> {
    @Override
    public PerfilUserResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        PerfilUserResponse perfilUserResponse = gson.fromJson(json, PerfilUserResponse.class);
        JsonArray jsonArray = json.getAsJsonObject().getAsJsonArray(JsonKeys.TIMELINE_ARRAY);
        perfilUserResponse.setMascotas(deserealizadorPerfil(jsonArray));
        return perfilUserResponse;
    }

    private ArrayList<Mascota> deserealizadorPerfil(JsonArray jsonArray) {
        ArrayList<Mascota> mascotas = new ArrayList<>();
        for(int i = 0; i < jsonArray.size(); i++ ){
            JsonObject mascotasDataObject = jsonArray.get(i).getAsJsonObject();
            Mascota item = new Mascota();
            JsonObject imageJson = mascotasDataObject.getAsJsonObject(JsonKeys.TIMELINE_IMAGES);
            JsonObject stdUrlJson = imageJson.getAsJsonObject(JsonKeys.TIMELINE_STANDAR);
            item.setUrlFoto(stdUrlJson.get(JsonKeys.TIMELINE_URLFOTO).getAsString());

            JsonObject likesJson = mascotasDataObject.getAsJsonObject(JsonKeys.TIMELINE_LIKES);
            item.setLikes(likesJson.get(JsonKeys.TIMELINE_LIKES_COUNT).getAsInt());
            mascotas.add(item);
        }

        return mascotas;
    }
}
