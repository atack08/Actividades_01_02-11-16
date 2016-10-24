package com.example.atack08.actividades_01;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Actividad_02 extends AppCompatActivity {

    private boolean login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_02);

        ((TextView)findViewById(R.id.textRecordar)).setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);

    }


    public void login(View v){

        String user = ((EditText)findViewById(R.id.textUsuario)).getText().toString();
        String pass = ((EditText)findViewById(R.id.textPassword)).getText().toString();


        if(user.equals("") || pass.equals(""))
            Toast.makeText(this, "FALTAN DATOS", Toast.LENGTH_SHORT).show();
        else{

            Intent intent = new Intent(this,Login.class);
            Bundle bundle = new Bundle();

            if(user.equalsIgnoreCase("javier") && pass.equals("1234"))
                bundle.putBoolean("login",true);
            else
                bundle.putBoolean("login",false);

            intent.putExtras(bundle);
            startActivity(intent);
        }
        
    }
    
    public void recordarDatos(View v){

        Toast.makeText(this, "Usuario: Javier, Password: 1234", Toast.LENGTH_SHORT).show();
    }


}
