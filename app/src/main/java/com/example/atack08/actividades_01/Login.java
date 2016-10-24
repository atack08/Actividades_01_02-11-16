package com.example.atack08.actividades_01;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView t = (TextView)findViewById(R.id.resultadoLogin);

        Button salir = (Button)findViewById(R.id.botonVolver2);
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        boolean login = b.getBoolean("login");

        if(login){
            t.setBackgroundColor(Color.parseColor("#2196F3"));
            t.setText("EL USUARIO y la PASSWORD son CORRECTOS");
        }
        else{
            t.setBackgroundColor(Color.parseColor("#F44336"));
            t.setText("USUARIO Y/O PASSWORD INCORRECTOS");
        }




    }
}
