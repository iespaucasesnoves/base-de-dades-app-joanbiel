package com.example.usuario.basededades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditaVi extends AppCompatActivity {
    Button btnActualitzar;
    EditText editID, editNomvi, editAnada, editLloc,
            editGraduacio, editData, editComentari,
            editIDBodega, editIDDenominacio, editPreu,
            editValolfativa, editValgustativa, editValvisual,
            editNota, editTipus;
    //String  editFoto;
    DataSourceVi db = new DataSourceVi(this);
    Vi vi = new Vi();
    Long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edita_vi);
        Intent in = getIntent();
        if (!in.getStringExtra("ID").equals("")) {
            id = Long.parseLong(in.getStringExtra("ID"));
        }
        ;
        btnActualitzar = findViewById(R.id.btnActualitzar);
        btnActualitzar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        guardarVi();
                    }
                }

        );

        editID = findViewById(R.id.editID);
        editNomvi = findViewById(R.id.editNomvi);
        editAnada = findViewById(R.id.editAnada);
        editLloc = findViewById(R.id.editLloc);
        editGraduacio = findViewById(R.id.editGraduacio);
        editData = findViewById(R.id.editData);
        editComentari = findViewById(R.id.editComentari);
        editIDBodega = findViewById(R.id.editIDBodega);
        editIDDenominacio = findViewById(R.id.editIDDenominacio);
        editPreu = findViewById(R.id.editPreu);
        editValolfativa = findViewById(R.id.editValolfativa);
        editValgustativa = findViewById(R.id.editValgustativa);
        editValvisual = findViewById(R.id.editValvisual);
        editNota = findViewById(R.id.editNota);
        //editFoto = findViewById(R.id.editFoto);
        editTipus = findViewById(R.id.editTipus);
        if (id != null && !id.toString().isEmpty()) {
            db.open();
            vi = db.getVi(id);
            db.close();
            editNomvi.setText(vi.getNomVi());
            editAnada.setText(vi.getAnada());
            editLloc.setText(vi.getLloc());
            editGraduacio.setText(vi.getGraduacio());
            editData.setText(vi.getData());
            editComentari.setText(vi.getComentari());
//            if (vi.getIdBodega() <= 0){
//                vi.getIdBodega() =  ;
//            }
            editIDBodega.setText( Long.toString(vi.getIdBodega()));
            editIDDenominacio.setText( Long.toString( vi.getIdDenominacio()));
            editPreu.setText(Double.toString(vi.getPreu()));
            editValolfativa.setText(vi.getValOlfativa());
            editValgustativa.setText(vi.getValGustativa());
            editValvisual.setText(vi.getValVisual());
            editNota.setText(vi.getNota());
        }
    }

    public void guardarVi() {
        vi.setId(Long.parseLong(editID.toString()));
        vi.setNomVi(editNomvi.toString());
        vi.setAnada(editAnada.toString());
        vi.setLloc(editLloc.toString());
        vi.setGraduacio(editGraduacio.toString());
        vi.setData(editData.toString());
        vi.setComentari(editComentari.toString());
        vi.setIdBodega(Long.parseLong(editIDBodega.toString()));
        vi.setIdDenominacio(Long.parseLong(editIDDenominacio.toString()));
        vi.setPreu(Double.parseDouble(editPreu.toString()));
        vi.setValOlfativa(editValolfativa.toString());
        vi.setValGustativa(editValgustativa.toString());
        vi.setValVisual(editValvisual.toString());
        vi.setNota(Integer.parseInt(editNota.toString()));

        db.open();
        if (id != null && id.toString().isEmpty()) {
            db.updateVi(vi);
        } else {
            db.createVi(vi);
        }
        db.close();
    }

}
