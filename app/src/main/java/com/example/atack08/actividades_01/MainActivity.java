package com.example.atack08.actividades_01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void linkActividades(View v){

        Intent intent=null;
        int idBoton = v.getId();
        switch (idBoton){
            case R.id.botonActividad01:
                intent = new Intent(this,Actividad_01.class);
                break;
            case R.id.botonActividad02:
                intent = new Intent(this,Actividad_02.class);
                break;
            case R.id.botonActividad03:
                intent = new Intent(this,Actividad_03.class);
                break;
            case R.id.botonActividad04:
               // intent = new Intent(this,Actividad_04.class);
                break;
        }

        startActivity(intent);

    }

}
