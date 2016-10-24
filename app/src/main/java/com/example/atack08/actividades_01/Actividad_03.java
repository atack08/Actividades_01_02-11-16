package com.example.atack08.actividades_01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Actividad_03 extends AppCompatActivity {

    private int fallos,aciertos,turnos;
    private TextView textN1, textN2, labelTiempo, textCorrectas, textIncorrectas;
    private EditText result;
    private Button comprobar;
    private Hilo_Cuenta hc1;
    private int tiempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_03);

        textN1 = (TextView)findViewById(R.id.textNum1);
        textN2 = (TextView)findViewById(R.id.textNum2);
        comprobar = (Button)findViewById(R.id.botonComprobar);
        labelTiempo = (TextView)findViewById(R.id.labelTiempo);
        result = (EditText)findViewById(R.id.textResultado);
        textCorrectas = (TextView)findViewById(R.id.textCorrectas);
        textIncorrectas = (TextView)findViewById(R.id.textIncorrectas);

        fallos=0;
        aciertos=0;
        tiempo = 5;

    }


    public void iniciarJuego(View v){

        hc1 =  new Hilo_Cuenta(textN1,textN2,labelTiempo,tiempo);
        labelTiempo.setText(String.valueOf(tiempo));
        hc1.execute();
    }

    public void comprobarResultado(View v){

        hc1.cancel(true);
        int n1 = Integer.parseInt(textN1.getText().toString());
        int n2 = Integer.parseInt(textN1.getText().toString());
        int resultCorrecto = n1 +n2;
        boolean aciertoFallo;

        int resultIntroducido = Integer.parseInt(result.getText().toString());

        if(resultCorrecto!=resultIntroducido) {
            aciertoFallo = false;
            fallos++;
            textIncorrectas.setText(String.valueOf(fallos));
        }
        else{
            aciertoFallo = true;
            aciertos++;
            textCorrectas.setText(String.valueOf(aciertos));
        }

        Intent intent = new Intent(this,Resultado_Operacion.class);
        Bundle b = new Bundle();
        b.putBoolean("result",aciertoFallo);
        intent.putExtras(b);

        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        iniciarJuego(null);
    }
}
