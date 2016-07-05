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

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by rsanchezgu on 24/06/2016.
 */
public class ImageListDeserealizador implements JsonDeserializer<ImageListResponse> {
    @Override
    public ImageListResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        ImageListResponse imageListResponse = gson.fromJson(json, ImageListResponse.class);
        JsonArray jsonArray = json.getAsJsonObject().getAsJsonArray(JsonKeys.TIMELINE_ARRAY);
        imageListResponse.setMascotas(deserealizadorImages(jsonArray));
        return imageListResponse;
    }

    private ArrayList<Mascota> deserealizadorImages(JsonArray jsonArray) {
        ArrayList<Mascota> mascotas = new ArrayList<>();
        try
        {

            if(jsonArray.size() > 0){
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
            }
            return mascotas;
        }
        catch(Exception e){
            String cadena = e.toString();
            return mascotas;
        }
    }
}
