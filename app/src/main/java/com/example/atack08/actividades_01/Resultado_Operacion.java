package com.example.atack08.actividades_01;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Resultado_Operacion extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado__operacion);

        TextView infoResult = (TextView)findViewById(R.id.textInfoResult);

        Intent intent = this.getIntent();
        Bundle b = intent.getExtras();

        if(b.getBoolean("result")){
            infoResult.setTextColor(Color.GREEN);
            infoResult.setText("CORRECTA");
        }
        else{
            infoResult.setTextColor(Color.RED);
            infoResult.setText("INCORRECTA");
        }
    }

    public void salirResult(View v){

        Intent intentRespuesta = new Intent();
        setResult(1,intentRespuesta);
        finish();
    }
}
