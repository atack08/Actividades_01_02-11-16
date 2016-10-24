package com.example.atack08.actividades_01;

import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by atack08 on 19/10/16.
 */

public class Hilo_Cuenta extends AsyncTask<Void, Integer, Boolean> {

    private TextView textNum1,textNum2, cuenta;
    private int tiempo;

    public Hilo_Cuenta(TextView textNum1, TextView textNum2, TextView cuenta, int tiempo){

        super();
        this.textNum1 = textNum1;
        this.textNum2 = textNum2;
        this.tiempo = tiempo;
        this.cuenta = cuenta;
    }

    @Override
    protected Boolean doInBackground(Void... params) {

        while(tiempo > 0){

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tiempo --;
            publishProgress();
        }

        return true;
    }

    protected void onPreExecute(){

        crearNumerosAleatorios();
        cuenta.setText(String.valueOf(tiempo));
    }

    @Override
    protected void onProgressUpdate(Integer... values) {

        cuenta.setText(String.valueOf(tiempo));
    }

    @Override
    protected void onPostExecute(Boolean result) {

        Toast.makeText(null, "", Toast.LENGTH_SHORT).show();
        
    }

    public void crearNumerosAleatorios(){

        int r1 = ((int)(Math.random()*1000))+1;
        int r2 = ((int)(Math.random()*1000))+1;

        this.textNum1.setText(String.valueOf(r1));
        this.textNum2.setText(String.valueOf(r2));
    }


}
