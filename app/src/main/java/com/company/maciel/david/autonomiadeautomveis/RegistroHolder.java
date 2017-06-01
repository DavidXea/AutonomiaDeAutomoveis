package com.company.maciel.david.autonomiadeautomveis;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class RegistroHolder extends RecyclerView.ViewHolder {

    private final Context context;
    private ImageView ivFotografia;
    private TextView tvKm;
    private TextView tvLitros;
    private TextView tvData;
    private Registro registro;

    public RegistroHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();
        ivFotografia = (ImageView) itemView.findViewById(R.id.ivFotografia);

        tvData = (TextView) itemView.findViewById(R.id.tvData);
        tvLitros = (TextView) itemView.findViewById(R.id.tvLitros);
        tvKm = (TextView) itemView.findViewById(R.id.tvKm);
    }

    public void renderizaNovoRegistro(Registro r){
        this.tvData.setText("Data : "+r.getDataAbastecimento());
        this.tvKm.setText("Km : "+r.getKmAtual());
        this.tvLitros.setText("Litros : "+r.getlAbastecidos());
        String posto = r.getPosto();

        if(posto.equals("Shell")){
            ivFotografia.setImageResource(R.drawable.shell);
        } else if(posto.equals("Texaco")){
            ivFotografia.setImageResource(R.drawable.texaco);
        }else if(posto.equals("Petrobras")){
            ivFotografia.setImageResource(R.drawable.petrobras);
        }else if(posto.equals("Ipiranga")){
            ivFotografia.setImageResource(R.drawable.ipiranga);
        }else if(posto.equals("Outros")){
            ivFotografia.setImageResource(R.drawable.outros);
        }
        registro = r;
    }
}
