package com.sancheztech.mascota.Service;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by rsanchezgu on 01/07/2016.
 */
public class NotificacionIDTokenService extends FirebaseInstanceIdService{
    private static final String TAG = "FIREBASE_TOKEN";
    String token;
    @Override
    public void onTokenRefresh() {
        //super.onTokenRefresh();
        token = FirebaseInstanceId.getInstance().getToken();
        enviarTokenRegistro(token);
    }

    private void enviarTokenRegistro(String token){
        Log.d(TAG, token);
    }
}
