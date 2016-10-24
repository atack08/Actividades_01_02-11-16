package com.example.atack08.actividades_01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class Actividad_01 extends AppCompatActivity {

    private CheckBox check1;
    private EditText nombre,apellidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_01);

        check1 =  (CheckBox) findViewById(R.id.checkCondiciones_01);
        nombre = (EditText)findViewById(R.id.nombre_01);
        apellidos = (EditText) findViewById(R.id.apellidos_01);

        check1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    verificar(null);
            }
        });
    }

    public void verificar(View v){

        String nom = nombre.getText().toString();
        String ape = apellidos.getText().toString();

        if(!nom.equals("") && !ape.equals("")){
            Intent intent  = new Intent(this,AceptarCondiciones.class);
            Bundle b = new Bundle();
            b.putString("nombre",nom);
            b.putString("apellidos",ape);

            intent.putExtras(b);
            startActivityForResult(intent,1);
        }
        else
            Toast.makeText(this, "FALTAN DATOS", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intentResult) {
        super.onActivityResult(requestCode, resultCode, intentResult);

        Bundle b = intentResult.getExtras();
        boolean condiciones = b.getBoolean("condiciones");
        if(condiciones){
            check1.setChecked(true);
            Toast.makeText(this, "SE ACEPTARON LAS CONDICIONES", Toast.LENGTH_SHORT).show();
        }
        else{
            check1.setChecked(false);
            Toast.makeText(this, "NO SE ACEPTARON LAS CONDICIONES", Toast.LENGTH_SHORT).show();
        }


    }

    public void volver(View v){
        finish();
    }
}
