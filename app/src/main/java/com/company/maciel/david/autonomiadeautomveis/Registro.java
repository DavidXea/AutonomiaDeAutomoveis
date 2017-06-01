package com.company.maciel.david.autonomiadeautomveis;

import java.io.Serializable;
import java.util.ArrayList;


public class Registro implements Serializable{

    public static ArrayList<Registro> listaRegistros;

    public static ArrayList<Registro> obterListaRegistros(){
        return Registro.getListaRegistros();
    }

    private double kmAtual;
    private double lAbastecidos;
    private String dataAbastecimento;
    private String posto;
    private static double autonomiaAtual = 0.0;
    private static double totalLitros = 0.0;
    private static double totalKm = 0.0;

    public Registro(double kmAtual, double lAbastecidos, String dataAbastecimento, String posto){
        this.setKmAtual(kmAtual);
        this.setlAbastecidos(lAbastecidos);
        this.setDataAbastecimento(dataAbastecimento);
        this.setPosto(posto);
    }

    public static ArrayList<Registro> getListaRegistros() {
        return listaRegistros;
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

    public static double getTotalKm() {
        return totalKm;
    }

    public static void setTotalKm(double totalKm) {
        Registro.totalKm = totalKm;
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
