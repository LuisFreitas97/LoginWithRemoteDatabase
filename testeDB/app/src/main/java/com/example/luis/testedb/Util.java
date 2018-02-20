package com.example.luis.testedb;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public abstract class Util
{
    public static void switchActivity(AppCompatActivity orig, Class dest)
    {
        Intent i = new Intent(orig.getApplicationContext(), dest);
        orig.startActivity(i);
    }
    public static void writeToast(Context c,String s)
    {
        Toast.makeText(c,s,Toast.LENGTH_LONG).show();
    }
}