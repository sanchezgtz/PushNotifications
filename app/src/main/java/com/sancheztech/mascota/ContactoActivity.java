package com.sancheztech.mascota;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.sancheztech.mascota.email.SendMail;

public class ContactoActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnSend;
    TextInputEditText txeNombre;
    TextInputEditText txeEmail;
    TextInputEditText txeMensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_contact);

        btnSend = (Button) findViewById(R.id.btnEnviar);

        btnSend.setOnClickListener(this);

    }

    private void SendEmail()
    {
        txeNombre = (TextInputEditText) findViewById(R.id.txeNombre);
        txeEmail = (TextInputEditText) findViewById(R.id.txeEmail);
        txeMensaje = (TextInputEditText) findViewById(R.id.txeMensaje);

        String nombre = txeNombre.getText().toString().trim();
        String email = txeEmail.getText().toString().trim();
        String mensaje = txeMensaje.getText().toString().trim();

        SendMail sm = new SendMail(this, email, this.getResources().getString(R.string.subject), "Hola "+ nombre + ", " + mensaje );

        sm.execute();
    }

    @Override
    public void onClick(View v) {
        SendEmail();
    }
}
