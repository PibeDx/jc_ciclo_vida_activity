package com.josecuentas.ciclo_vida_activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


public class MainActivity extends Activity{

    public static final String TAG = "MainActivity";
    private String mensaje="", resultado="";
    TextView mTxvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mensaje= getResources().getString(R.string.text_oncreate);
        showLog(mensaje);
        mTxvResultado = (TextView) findViewById(R.id.txv_result);
        resultado += mensaje + "\n";
        mTxvResultado.setText(resultado);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mensaje=getResources().getString(R.string.text_onstart);
        showLog(mensaje);
        resultado += mensaje + "\n";
        mTxvResultado.setText(resultado);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mensaje = getResources().getString(R.string.text_onrestart);
        showLog(mensaje);
        resultado += mensaje + "\n";
        mTxvResultado.setText(resultado);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mensaje= getResources().getString(R.string.text_onresume);
        showLog(mensaje);
        resultado += mensaje + "\n";
        mTxvResultado.setText(resultado);
    }



    @Override
    protected void onPause() {
        super.onPause();
        mensaje = getResources().getString(R.string.text_onpause);
        showLog(mensaje);
        resultado += mensaje + "\n";
        mTxvResultado.setText(resultado);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mensaje = getResources().getString(R.string.text_onstop);
        showLog(mensaje);
        resultado += mensaje + "\n";
        mTxvResultado.setText(resultado);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mensaje = getResources().getString(R.string.text_ondestroy);
        showLog(mensaje);
        resultado += mensaje + "\n";
        mTxvResultado.setText(resultado);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        showLog("onSaveInstanceState");
        outState.putString("text", resultado);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        showLog("onRestoreInstanceState");
        resultado = savedInstanceState.getString("text")+resultado;
    }

    private void showLog(String mensaje){
        Log.d(TAG, "Se ejecuto el "+ mensaje);
    }

    private void sleep(long milisecond){
        try {
            Thread.sleep(milisecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
