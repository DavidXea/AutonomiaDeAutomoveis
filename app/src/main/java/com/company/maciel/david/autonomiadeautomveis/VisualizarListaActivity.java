package com.company.maciel.david.autonomiadeautomveis;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.company.maciel.david.autonomiadeautomveis.storage.BancoDadosHelper;

public class VisualizarListaActivity extends AppCompatActivity {

    private RegistroAdapter registroAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_lista);

        RecyclerView rvRegistros = (RecyclerView)findViewById(R.id.rvRegistros);
        rvRegistros.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
        registroAdapter = new RegistroAdapter();
        registroAdapter.setListaRegistros(Registro.getListaRegistros());
        rvRegistros.setAdapter(registroAdapter);
    }
}
