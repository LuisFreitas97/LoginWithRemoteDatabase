package com.example.luis.testedb;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import java.util.concurrent.ExecutionException;

public class login extends SimpleActivity {

   private Button bReg,bLogin;
   private  AutoCompleteTextView id;
   private EditText pass;
   private static String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bReg=(Button)findViewById(R.id.buttonRegisto);
        bLogin=(Button)findViewById(R.id.buttonLogin);
        id=(AutoCompleteTextView)findViewById(R.id.loginIdText);
        pass=(EditText) findViewById(R.id.editTextPass);

        bReg.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        switchActivityTo(Registo.class);
                    }
                });

        bLogin.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view) {
                        String idtext = id.getText().toString();
                        String password = pass.getText().toString();

                        if (verificaWifi())
                        {
                            if (!(idtext.equals("")) && (!password.equals("")) && verificaWifi()) {
                                getMethodDemo exec = new getMethodDemo();
                                try {
                                    result = exec.execute("http://lgfreitas-4.000webhostapp.com/verificaLogin.php?id=" + idtext + "&password=" + password).get();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                } catch (ExecutionException e) {
                                    e.printStackTrace();
                                }

                                if (result.contains("1")) {
                                    writeToast("Sucesso no login!");
                                } else {
                                    writeToast("Login não reconhecido!");
                                }
                            } else {
                                writeToast("Preencha todos os campos!");
                            }
                    }
                    else
                        {
                            writeToast("Conecte-se a uma rede de internet");
                        }
                        id.setText("");
                        pass.setText("");
                    }
                });
    }
}
