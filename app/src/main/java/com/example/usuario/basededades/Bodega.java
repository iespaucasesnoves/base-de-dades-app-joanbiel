package com.example.usuario.basededades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Bodega extends AppCompatActivity {
    private long idBodega;
    private String nomBodega;

    public Bodega(){this.idBodega = -1;}

    public long getIdBodega() {return idBodega;}
    public void setIdBodega(long idBodega) {this.idBodega = idBodega;}
    public String getNomBodega() { return nomBodega;}
    public void setNomBodega(String nomBodega) {this.nomBodega = nomBodega;}
}
