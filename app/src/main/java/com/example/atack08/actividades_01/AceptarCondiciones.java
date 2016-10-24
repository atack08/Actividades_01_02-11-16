package com.example.atack08.actividades_01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.net.Socket;

public class AceptarCondiciones extends AppCompatActivity {

    private TextView nombreApellidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aceptar_condiciones);

        nombreApellidos = (TextView) findViewById(R.id.aceptarCondicionesText);

        Intent intent = this.getIntent();
        Bundle b = intent.getExtras();
        String nombre = b.getString("nombre");
        String apellidos = b.getString("apellidos");

        nombreApellidos.setText("Hola " + nombre.toUpperCase() + " " + apellidos.toUpperCase() +
        " " + "¿Aceptas las condiciones?");

    }

    public void fijarCondicion(View v){

        boolean condiciones;
        int botonId = v.getId();
        if(botonId == R.id.botonCondicionesAceptar)
            condiciones = true;
        else
            condiciones=false;

        Intent intentRespuesta = new Intent();
        Bundle b = new Bundle();
        b.putBoolean("condiciones",condiciones);
        intentRespuesta.putExtras(b);

        setResult(1,intentRespuesta);
        finish();

    }
}
