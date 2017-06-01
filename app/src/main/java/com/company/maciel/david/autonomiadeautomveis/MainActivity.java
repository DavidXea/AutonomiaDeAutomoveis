package com.company.maciel.david.autonomiadeautomveis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView tvAutonomia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvAutonomia = (TextView) findViewById(R.id.tvAutonomia);
        tvAutonomia.setText(String.valueOf(Registro.getAutonomiaAtual()));
        Registro.listaRegistros = new ArrayList<>();
    }

    public void onClickAdicionaRegistro(View v){
        Intent intent = new Intent(this.getApplicationContext(), AdicionarNovoRegistro.class);
        startActivity(intent);
    }

    public void onClickVisualizarRegistros(View v){
        Intent intent = new Intent(this.getApplicationContext(), VisualizarListaActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume(){
        tvAutonomia.setText(String.valueOf(String.format("%.2f",Registro.getAutonomiaAtual())));
        super.onResume();
    }
}
