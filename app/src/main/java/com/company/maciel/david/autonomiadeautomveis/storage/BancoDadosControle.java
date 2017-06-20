package com.company.maciel.david.autonomiadeautomveis.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by david on 19/06/2017.
 */

public class BancoDadosControle {
    public SQLiteDatabase db;
    public BancoDadosHelper banco;

    public BancoDadosControle(Context context){
        banco = new BancoDadosHelper(context);
    }

//    public String insereDado(int km, int litros, String posto, String data ){
//        ContentValues valores;
//        long resultado;
//
//        db = banco.getWritableDatabase();
//        valores = new ContentValues();
//        valores.put(BancoDadosHelper.NOME_BD, km);
//        valores.put(BancoDadosHelper.LITROS, litros);
//        valores.put(BancoDadosHelper.DATA, data);
//        valores.put(BancoDadosHelper.POSTO, posto);
//
//        resultado = db.insert(BancoDadosHelper.TABELA, null, valores);
//        db.close();
//
//        if (resultado ==-1) {
//            return "Erro ao inserir registro";
//        }else {
//            return "Registro Inserido com sucesso";
//        }
//    }
}
