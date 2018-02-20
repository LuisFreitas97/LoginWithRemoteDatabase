package com.example.luis.testedb;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by luis on 19-12-2017.
 */
public class getMethodDemo extends AsyncTask<String , Void ,String> {

    private static String server_response;

    @Override
    protected String doInBackground(String... strings) {

        URL url;
        HttpURLConnection urlConnection = null;

        try {
            url = new URL(strings[0]);
            urlConnection = (HttpURLConnection) url.openConnection();

            int responseCode = urlConnection.getResponseCode();

            if(responseCode == HttpURLConnection.HTTP_OK){

                //login.send(server_response);
                //Chamar metodo para verificar se o login existe
                //verificaLogin(server_response);
                //GetMethodDemo sendPostReqAsyncTask = new GetMethodDemo();

                urlConnection.setRequestMethod("GET");
                return readStream(urlConnection.getInputStream());

            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
       // Log.e("antes",server_response);
       /*if (server_response.contains("1"))
        {
           // Log.e("ola","Login efetuado com sucesso!");
            //Enviar
            login.send(server_response);
            Log.e("dsf",login.getResult());
        }
        else
        {
           // Log.e("ola","Não está registado no sistema!");
            login.send(server_response);
            Log.e("dsf",login.getResult());
        }
        login.getT1().start();*/
       // Log.e("depois",server_response);
        //login.send(server_response);
        //sc.writeToast(server_response);
        //id=(TextView) View.findViewById(R.id.labelLoginId);
        //id.setText(server_response);
        //Log.e("Response", "ola " + server_response);
        //texto.setText(server_response);

    }

      private String readStream(InputStream in) {
        BufferedReader reader = null;
        StringBuffer response = new StringBuffer();
        try {
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                response.append(line+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return response.toString();
    }
}