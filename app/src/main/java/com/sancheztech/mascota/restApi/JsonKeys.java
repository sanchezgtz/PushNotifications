package com.sancheztech.mascota.restApi;

/**
 * Created by rsanchezgu on 23/06/2016.
 */
public class JsonKeys {
    //-- obtener los seguidores
    public static final String FOLLOWED_ARRAY       = "data";
    public static final String FOLLOWED_USERNAME    = "username";
    public static final String FOLLOWED_ID          = "id";
    public static final String FOLLOWED_FULLNAME    = "full_name";

    //-- obtener el perfil

    public static final String PERFIL_USER_ARRAY                = "data";
    public static final String PERFIL_USER                      = "user";
    public static final String PERFIL_USER_IMAGEPERFIL          = "profile_picture";
    public static final String PERFIL_USER_IMAGE                = "images";
    public static final String PERFIL_USER_IMAGE_STANDAR        ="standard_resolution";
    public static final String PERFIL_USER_IMAGE_STANDAR_URL    ="url";

    //--obetner imagenes timeline

    public static final String TIMELINE_ARRAY       = "data";
    public static final String TIMELINE_IMAGES      = "images";
    public static final String TIMELINE_URLFOTO     = "url";
    public static final String TIMELINE_LIKES       = "likes";
    public static final String TIMELINE_LIKES_COUNT = "count";
    public static final String TIMELINE_STANDAR     = "standard_resolution";

    //--
    public static final String SEARCH_ARRAY         = "data";
    public static final String SEARCH_ID            = "id";
    public static final String SEARCH_FULLNAME      = "full_name";
    public static final String SEARCH_USERNAME      = "username";
    public static final String SEARCH_PROFILEPICTURE      = "profile_picture";

}
