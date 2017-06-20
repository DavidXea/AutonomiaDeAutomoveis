package com.company.maciel.david.autonomiadeautomveis;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.company.maciel.david.autonomiadeautomveis.storage.BancoDadosHelper;

import java.io.Serializable;
import java.util.ArrayList;


public class Registro implements Serializable{

    public static ArrayList<Registro> listaRegistros;


    private double kmAtual;
    private double lAbastecidos;
    private String dataAbastecimento;
    private String posto;
    private static double autonomiaAtual = 0.0;
    private static double totalLitros = 0.0;


    public Registro(double kmAtual, double lAbastecidos, String dataAbastecimento, String posto){
        this.setKmAtual(kmAtual);
        this.setlAbastecidos(lAbastecidos);
        this.setDataAbastecimento(dataAbastecimento);
        this.setPosto(posto);
    }

    public static ArrayList<Registro> getListaRegistros() {
        return listaRegistros;
    }

    public static void carregaLista(Context cont) {
        BancoDadosHelper bdHelper = new BancoDadosHelper( cont );
        SQLiteDatabase db = bdHelper.getReadableDatabase();
        totalLitros = 0;
        String[] projecao = {
                "km",
                "litros",
                "data",
                "posto"};


        String order = "id ASC";
        try{
            Cursor c = db.query(
                    BancoDadosHelper.TABELA,
                    projecao,
                    null,
                    null,
                    null,
                    null,
                    order
            );
            if(c!=null){
                if(c.moveToFirst()){
                    do{
                        Registro novoRegistro = new Registro(c.getDouble(0),c.getDouble(1),c.getString(2),c.getString(3));
                        listaRegistros.add(novoRegistro);
                        totalLitros += c.getDouble(1);
                    }while (c.moveToNext());
                }else{
                    Toast.makeText(cont, "Lista Vazia", Toast.LENGTH_LONG).show();
                }
            }else{
                Toast.makeText(cont, "Lista Vazia", Toast.LENGTH_LONG).show();
            }
        }catch (Exception erro){
            Toast.makeText(cont, "Lista Vazia", Toast.LENGTH_LONG).show();
            return;
        }

    }

    public static void setListaRegistros(ArrayList<Registro> listaRegistros) {
        Registro.listaRegistros = listaRegistros;
    }

    public static double getAutonomiaAtual() {
        return autonomiaAtual;
    }

    public static void setAutonomiaAtual(double autonomiaAtual) {
        Registro.autonomiaAtual = autonomiaAtual;
    }

    public static double getTotalLitros() {
        return totalLitros;
    }

    public static void setTotalLitros(double totalLitros) {
        Registro.totalLitros = totalLitros;
    }

    public double getKmAtual() {
        return kmAtual;
    }

    public void setKmAtual(double kmAtual) {
        this.kmAtual = kmAtual;
    }

    public double getlAbastecidos() {
        return lAbastecidos;
    }

    public void setlAbastecidos(double lAbastecidos) {
        this.lAbastecidos = lAbastecidos;
    }

    public String getDataAbastecimento() {
        return dataAbastecimento;
    }

    public void setDataAbastecimento(String dataAbastecimento) {
        this.dataAbastecimento = dataAbastecimento;
    }

    public String getPosto() {
        return posto;
    }

    public void setPosto(String posto) {
        this.posto = posto;
    }
}
