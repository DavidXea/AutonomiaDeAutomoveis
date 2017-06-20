package com.company.maciel.david.autonomiadeautomveis;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.company.maciel.david.autonomiadeautomveis.storage.BancoDadosHelper;

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

        BancoDadosHelper bdHelper = new BancoDadosHelper(AdicionarNovoRegistro.this);

            SQLiteDatabase bd = bdHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("km", Double.parseDouble(etkmAtual.getText().toString()));
            values.put("litros", Double.parseDouble(etLitros.getText().toString()));
            values.put("data", etData.getText().toString());
            values.put("posto", spPosto.getSelectedItem().toString());

            long newRowId = bd.insert("minha_tabela", null, values);

            Toast.makeText(this, "Salvo com id: " + newRowId, Toast.LENGTH_LONG).show();
            finish();
    }
}

