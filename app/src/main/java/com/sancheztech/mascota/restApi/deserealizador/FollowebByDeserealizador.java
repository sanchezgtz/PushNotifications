package com.sancheztech.mascota.restApi.deserealizador;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.sancheztech.mascota.pojo.Followed;
import com.sancheztech.mascota.restApi.JsonKeys;
import com.sancheztech.mascota.restApi.model.FollowedResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by rsanchezgu on 23/06/2016.
 */
public class FollowebByDeserealizador implements JsonDeserializer<FollowedResponse> {

    @Override
    public FollowedResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        FollowedResponse followedResponse = gson.fromJson(json, FollowedResponse.class);
        JsonArray jsonArray = json.getAsJsonObject().getAsJsonArray(JsonKeys.FOLLOWED_ARRAY);
        followedResponse.setFolloweds(deserealizadorFollowBy(jsonArray));
        return followedResponse;
    }

    private ArrayList<Followed> deserealizadorFollowBy(JsonArray jsonArray) {
        ArrayList<Followed> followeds = new ArrayList<>();
        for(int i = 0; i < jsonArray.size(); i++){
            JsonObject followedDataObject = jsonArray.get(i).getAsJsonObject();
            Followed followed = new Followed();
            followed.setId(followedDataObject.get(JsonKeys.FOLLOWED_ID).getAsString());
            followed.setFullName(followedDataObject.get(JsonKeys.FOLLOWED_FULLNAME).getAsString());
            followed.setUserName(followedDataObject.get(JsonKeys.FOLLOWED_USERNAME).getAsString());

            followeds.add(followed);
        }

        return followeds;
    }
}
