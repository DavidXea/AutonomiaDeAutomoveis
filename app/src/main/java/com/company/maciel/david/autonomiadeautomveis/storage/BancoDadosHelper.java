package com.company.maciel.david.autonomiadeautomveis.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by marcelo on 5/15/17.
 */

public class BancoDadosHelper extends SQLiteOpenHelper {

    public static final String NOME_BD = "meu_bd";
    public static final String TABELA = "tabela_registros";
//    private static final String ID = "_id";
//    private static final String TITULO = "titulo";
//    private static final String AUTOR = "autor";
//    private static final String EDITORA = "editora";
    private static final int VERSAO = 1;

    public BancoDadosHelper(Context context){

        super(context, NOME_BD, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE minha_tabela (" +
                "id integer primary key," +
                "km double," +
                "litros double," +
                "data text," +
                "posto text" +
        ");");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //se atualizar a estrutura, lembrar de atualizar o método onCreate
        if(newVersion == 2 && oldVersion == 1){
            db.execSQL("ALTER TABLE minha_tabela ADD COLUMN nova_coluna int;");
        }
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion == 1 && oldVersion == 2){
            db.execSQL("ALTER TABLE minha_tabela DROP COLUMN nova_coluna;");
        }
    }




}
