package com.example.usuario.basededades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Denominacio extends AppCompatActivity {
    private long idDenominacio;
    private String nomDenominacio;

    public Denominacio(){this.idDenominacio = -1;}

    public void setIdDenominacio(long idDenominacio) {this.idDenominacio = idDenominacio;}
    public long getIdDenominacio() {return idDenominacio;}
    public String getNomDenominacio() { return nomDenominacio;}
    public void setNomDenominacio(String nomDenominacio) {this.nomDenominacio = nomDenominacio;}
}
