package com.josecuentas.ciclo_vida_activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends Activity{

    public static final String TAG = "MainActivity";
    private String mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mensaje= getResources().getString(R.string.text_oncreate);
        showLog(mensaje);

    }

    @Override
    protected void onStart() {
        super.onStart();
        mensaje=getResources().getString(R.string.text_onstart);
        showLog(mensaje);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mensaje = getResources().getString(R.string.text_onrestart);
        showLog(mensaje);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mensaje= getResources().getString(R.string.text_onresume);
        showLog(mensaje);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mensaje = getResources().getString(R.string.text_onpause);
        showLog(mensaje);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mensaje = getResources().getString(R.string.text_onstop);
        showLog(mensaje);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mensaje = getResources().getString(R.string.text_ondestroy);
        showLog(mensaje);
    }

    private void showLog(String mensaje){
        Log.d(TAG, "Se ejecuto el "+ mensaje);
    }
}
