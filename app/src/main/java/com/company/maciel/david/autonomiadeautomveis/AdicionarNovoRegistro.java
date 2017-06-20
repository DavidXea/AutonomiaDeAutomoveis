package com.company.maciel.david.autonomiadeautomveis;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.company.maciel.david.autonomiadeautomveis.storage.BancoDadosControle;


public class AdicionarNovoRegistro extends AppCompatActivity {

    private EditText etkmAtual;
    private EditText etData;
    private EditText etLitros;
    private Spinner spPosto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addregistro);

        etkmAtual = (EditText) findViewById(R.id.etkmAtual);
        etData = (EditText) findViewById(R.id.etData);
        etLitros = (EditText) findViewById(R.id.etListros);
        spPosto = (Spinner) findViewById(R.id.spPosto);

        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(this, R.array.arrayPostos ,
                                                                    android.R.layout.simple_spinner_item);
        spPosto.setAdapter(arrayAdapter);
    }

    public void onClickAdicionar(View v){

        BancoDadosControle inserir = new BancoDadosControle(getBaseContext());

        String resultado;

        resultado = inserir.insereDado  ( Double.parseDouble(etkmAtual.getText().toString()),
                                          Double.parseDouble(etLitros.getText().toString()),
                                          etData.getText().toString(),
                                          spPosto.getSelectedItem().toString()
                                        );
        Registro.setTotalLitros(Registro.getTotalLitros()+Double.parseDouble(etLitros.getText().toString()));

        Registro novoRegistro = new Registro(   Double.parseDouble(etkmAtual.getText().toString()),
                                                Double.parseDouble(etLitros.getText().toString()),
                                                etData.getText().toString(),
                                                spPosto.getSelectedItem().toString()
                                            );
        Registro.listaRegistros.add(novoRegistro);

            Toast.makeText(this,resultado, Toast.LENGTH_LONG).show();
            finish();
    }
}

