package com.company.maciel.david.autonomiadeautomveis.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BancoDadosHelper extends SQLiteOpenHelper {

    public static final String NOME_BD = "bd_autonomia";
    public static final String TABELA = "tabela_registros";
    public static final String ID = "id";
    public static final String KM = "km";
    public static final String LITROS = "litros";
    public static final String DATA = "data";
    public static final String POSTO = "posto";
    private static final int VERSAO = 1;

    public BancoDadosHelper(Context context){
        super(context, NOME_BD , null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABELA+" (" +
                ID+" integer primary key," +
                KM+" double," +
                LITROS+" double," +
                DATA+" text," +
                POSTO+" text" +
        ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion == 2 && oldVersion == 1){
            db.execSQL("ALTER TABLE "+TABELA+" ADD COLUMN nova_coluna int;");
        }
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion == 1 && oldVersion == 2){
            db.execSQL("ALTER TABLE "+TABELA+" DROP COLUMN nova_coluna;");
        }
    }
}
