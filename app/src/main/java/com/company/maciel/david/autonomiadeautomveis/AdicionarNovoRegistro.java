package com.company.maciel.david.autonomiadeautomveis;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

public class AdicionarNovoRegistro extends AppCompatActivity {

    private EditText etkmAtual;
    private EditText etData;
    private EditText etLitros;
    private Spinner spPosto;
    private ImageButton imButton;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addregistro);

        etkmAtual = (EditText) findViewById(R.id.etkmAtual);
        imButton = (ImageButton) findViewById(R.id.imButton);

        etData = (EditText) findViewById(R.id.etData);
        etLitros = (EditText) findViewById(R.id.etListros);
        spPosto = (Spinner) findViewById(R.id.spPosto);

        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(this, R.array.arrayPostos ,
                                                                    android.R.layout.simple_spinner_item);
        spPosto.setAdapter(arrayAdapter);
    }

    public void onClickAdicionar(View v){
        double km = Double.parseDouble(etkmAtual.getText().toString());
        double litros = Double.parseDouble(etLitros.getText().toString());
        Registro novoRegistro = new Registro(km,litros,etData.getText().toString(),
                                                spPosto.getSelectedItem().toString());

        if(km < Registro.getTotalKm()){
            etkmAtual.setError("A Quilometragem digitada é menor que a atual");
            return;
        }else if(km <= 0) {
            etkmAtual.setError("É necessario digitar um valor diferente de 0");
            return;
        }else if(litros <= 0){
            etLitros.setError("É necessario digitar um valor diferente de 0");
            return;
        }else{
            Registro.setTotalLitros(Registro.getTotalLitros() + litros);
            Registro.setTotalKm(km);
            Registro.setAutonomiaAtual(km / Registro.getTotalLitros());
            Registro.listaRegistros.add(novoRegistro);
            finish();
        }
    }
}
