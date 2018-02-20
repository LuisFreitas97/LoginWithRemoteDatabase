package com.example.luis.testedb;

import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

public class Registo extends SimpleActivity
{
    AutoCompleteTextView id=null,nome=null;
    EditText pass=null;
    Button bReg=null;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        id = (AutoCompleteTextView)findViewById(R.id.textId);
        nome = (AutoCompleteTextView)findViewById(R.id.textNome);
        pass = (EditText)findViewById(R.id.textPass);
        bReg=(Button)findViewById(R.id.buttonReg);

        bReg .setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view) {
                        String idText = id.getText().toString();
                        String nomeText = nome.getText().toString();
                        String passText = pass.getText().toString();

                        if (verificaWifi())
                        {
                            if (idText.equals("") || nomeText.equals("") || passText.equals("")) {
                                writeToast("Preencha todos os campos");
                            } else {
                                new getMethodDemo().execute("http://lgfreitas-4.000webhostapp.com/registo.php?id=" + idText + "&nome=" + nomeText + "&password=" + passText);
                                switchActivityTo(login.class);
                                writeToast("Registo efetuado com sucesso!");
                            }
                        }
                        else
                        {
                            writeToast("Conecte-se a uma rede de internet!");
                        }
                    }
                });
    }
}