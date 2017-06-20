package com.company.maciel.david.autonomiadeautomveis.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;



public class BancoDadosControle {
    public SQLiteDatabase db;
    public BancoDadosHelper banco;

    public BancoDadosControle(Context context){
        banco = new BancoDadosHelper(context);
    }

    public String insereDado(double km, double litros, String data, String posto ){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(BancoDadosHelper.KM, km);
        valores.put(BancoDadosHelper.LITROS, litros);
        valores.put(BancoDadosHelper.DATA, data);
        valores.put(BancoDadosHelper.POSTO, posto);

        resultado = db.insert(BancoDadosHelper.TABELA, null, valores);
        db.close();

        if (resultado ==-1) {
            return "Erro ao inserir registro";
        }else {
            return "Registro Inserido com sucesso";
        }
    }
}
