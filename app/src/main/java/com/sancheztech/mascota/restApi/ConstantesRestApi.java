package com.sancheztech.mascota.restApi;

/**
 * Created by rsanchezgu on 23/06/2016.
 */
public class ConstantesRestApi {

    public static final String VERSION = "/v1/";
    public static final String ROOT_URL = "https://api.instagram.com" + VERSION;
    public static final String ACCES_TOKEN = "3436368772.753a0d0.b6bff24aa65647e1b863e096a617a0d9";
    public static final String KEY_ACCES_TOKEN = "?access_token=";

    public static final String KEY_GET_FOLLOWEDBY = "users/self/follows";
    public static final String URL_GET_FOLLOWEDBY = KEY_GET_FOLLOWEDBY + KEY_ACCES_TOKEN + ACCES_TOKEN;

    public static final String KEY_GET_RECENT_MEDIA_USER = "users/self/media/recent/";
    public static final String URL_GET_RECENT_MEDIA_USER = KEY_GET_RECENT_MEDIA_USER + KEY_ACCES_TOKEN + ACCES_TOKEN;

    public static final String KEY_SEARCH_USER = "users/search";
    public static final String URL_SEARCH_USER = KEY_SEARCH_USER;

    public static final String KEY_GET_RECENT_MEDIA_OTHER = "users/{id}/media/recent/";
    public static final String URL_GET_RECENT_MEDIA_OTHER = KEY_GET_RECENT_MEDIA_OTHER + KEY_ACCES_TOKEN + ACCES_TOKEN;

    public static final String ROOT_URL_FIREBASE ="https://kinder-hockey-59168.herokuapp.com/";
    public static final String KEY_POST_ID_TOKEN = "token-device/";
}
