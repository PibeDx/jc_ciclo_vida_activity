package com.josecuentas.ciclo_vida_activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ScrollView;
import android.widget.TextView;


public class MainActivity extends Activity{

    public static final String TAG = "MainActivity";
    public static final String BUNDLE = "data";
    private String mensaje="", resultado="";
    TextView mTxvResultado;
    ScrollView svContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState!=null) {
//            resultado = savedInstanceState.getString(BUNDLE) + resultado;
//            showLog("Se recupera los datos == Inicio");
//            showLog(resultado);
//            showLog("Se recupera los datos == Fin");
        }

        mensaje= getResources().getString(R.string.text_oncreate);
        showLog(mensaje);
        mTxvResultado = (TextView) findViewById(R.id.txv_result);
        svContainer = (ScrollView)findViewById(R.id.sview_container);
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
        outState.putString(BUNDLE, resultado);
        outState.putIntArray("ARTICLE_SCROLL_POSITION",
                new int[]{svContainer.getScrollX(), svContainer.getScrollY()});
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        showLog("onRestoreInstanceState");
        resultado = savedInstanceState.getString(BUNDLE)+resultado;
        final int[] position = savedInstanceState.getIntArray("ARTICLE_SCROLL_POSITION");
        if(position != null)
            svContainer.post(new Runnable() {
                public void run() {
                    svContainer.scrollTo(position[0], position[1]);
                }
            });
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
