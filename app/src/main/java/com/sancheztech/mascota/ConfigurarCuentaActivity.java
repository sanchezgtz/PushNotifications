package com.sancheztech.mascota;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ConfigurarCuentaActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnGuardarCuenta;
    private TextInputEditText txeUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurar_cuenta);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_instagram);

        txeUsuario = (TextInputEditText) findViewById(R.id.txeUsuario);
        btnGuardarCuenta = (Button) findViewById(R.id.btnCuentaInst);
        btnGuardarCuenta.setOnClickListener(this);

        SharedPreferences misReferencias = getSharedPreferences("shared", Context.MODE_PRIVATE);
        txeUsuario.setText( misReferencias.getString("perfilInstagram", ""));

    }

    @Override
    public void onClick(View v) {
        GuardarCuenta();
    }

    private void GuardarCuenta() {
        String usuario = txeUsuario.getText().toString().trim();
        if(ValidaCampo(usuario)){
            SharedPreferences perfilInstagram = getSharedPreferences("shared", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = perfilInstagram.edit();
            editor.putString("perfilInstagram", usuario);
            editor.commit();

            Toast.makeText(this, "La cuenta se guardó correctamente", Toast.LENGTH_SHORT).show();
            finish();
        }
        else{
            txeUsuario.setError("Ingrese una cuenta de usario");
        }

    }

    private boolean ValidaCampo(String usuario) {
        if(usuario.isEmpty() || usuario == null || usuario.length() == 0)
            return false;
        else
            return true;
    }
}
