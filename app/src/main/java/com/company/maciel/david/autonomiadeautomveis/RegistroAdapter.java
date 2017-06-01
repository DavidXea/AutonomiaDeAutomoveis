package com.company.maciel.david.autonomiadeautomveis;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


public class RegistroAdapter extends RecyclerView.Adapter<RegistroHolder> {

    private List<Registro> listaRegistros;

    public void setListaRegistros(List<Registro> lista) {
        this.listaRegistros = lista;
    }

    public List<Registro> getListaRegistros(){
        return this.listaRegistros;
    }

    public RegistroAdapter() {
    }

    @Override
    public RegistroHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.registro_item, null);
        RegistroHolder rcv = new RegistroHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RegistroHolder holder, int position) {
        Registro atual = listaRegistros.get(position);
        holder.renderizaNovoRegistro(atual);
    }

    @Override
    public int getItemCount() {
        return listaRegistros.size();
    }
}
