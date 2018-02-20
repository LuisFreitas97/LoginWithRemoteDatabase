package com.example.luis.testedb;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/* CLASSE ENCURTADORA */
public class SimpleActivity extends AppCompatActivity
{
    /* Construtor */
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    /* Funções encurtadoras */
    public void switchActivityTo(Class c)
    {
        Util.switchActivity(this,c);
    }
    public void writeToast(String s)
    {
        Util.writeToast(getApplicationContext(),s);
    }
    public void waitClickToChangeActivity(int b, final Class act)
    {
        findViewById(b).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                /* Ação ao ser clicado o botão */
                switchActivityTo(act);
            }
        });
    }

    public boolean verificaWifi()
    {
        ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (null != activeNetwork)
        {
            if(activeNetwork.getType() == ConnectivityManager.TYPE_WIFI)
            {
                //answer="You are connected to a WiFi Network";
                return true;
            }
            if(activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE)
            {
                //answer="You are connected to a Mobile Network";
                return true;
            }
            return false;
        }
        else {
            //answer = "No internet Connectivity";
            return false;
        }
    }
}