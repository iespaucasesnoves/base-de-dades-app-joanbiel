package com.example.usuario.basededades;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DataSourceVi {

    private SQLiteDatabase database;
    private HelperVi dbAjuda;                    //CLASSE AJUDA

    private String[] allColumnsVi = {
            HelperVi.COLUMN_ID, HelperVi.COLUMN_NOMVI, HelperVi.COLUMN_ANADA,
            HelperVi.COLUMN_LLOC, HelperVi.COLUMN_GRADUACIO, HelperVi.COLUMN_DATA,
            HelperVi.COLUMN_COMENTARI, HelperVi.COLUMN_IDBODEGA,
            HelperVi.COLUMN_IDDENOMINACIO, HelperVi.COLUMN_PREU,
            HelperVi.COLUMN_VALOLFATIVA, HelperVi.COLUMN_VALGUSTATIVA,
            HelperVi.COLUMN_VALVISUAL, HelperVi.COLUMN_NOTA, HelperVi.COLUMN_FOTO,
            HelperVi.COLUMN_TIPUS
    };

    public DataSourceVi(Context context) {  //CONSTRUCTOR
        dbAjuda = new HelperVi(context);
    }

    public void open() throws SQLException {
        database = dbAjuda.getWritableDatabase();
    }

    public void close() {
        dbAjuda.close();
    }

    public Vi createVi(Vi vi) {
        // insert d'un nou vi
        ContentValues values = new ContentValues();
        values.put(HelperVi.COLUMN_NOMVI, vi.getNomVi());
        values.put(HelperVi.COLUMN_ANADA, vi.getAnada());
        values.put(HelperVi.COLUMN_TIPUS, vi.getTipus());
        values.put(HelperVi.COLUMN_LLOC, vi.getLloc());
        values.put(HelperVi.COLUMN_GRADUACIO, vi.getGraduacio());
        values.put(HelperVi.COLUMN_DATA, String.valueOf(vi.getData()));
        values.put(HelperVi.COLUMN_COMENTARI, vi.getComentari());
        values.put(HelperVi.COLUMN_IDBODEGA, vi.getIdBodega());
        values.put(HelperVi.COLUMN_IDDENOMINACIO, vi.getIdDenominacio());
        values.put(HelperVi.COLUMN_PREU, vi.getPreu());
        values.put(HelperVi.COLUMN_VALOLFATIVA, vi.getValOlfativa());
        values.put(HelperVi.COLUMN_VALGUSTATIVA, vi.getValGustativa());
        values.put(HelperVi.COLUMN_VALVISUAL, vi.getValVisual());
        values.put(HelperVi.COLUMN_NOTA, vi.getNota());
        values.put(HelperVi.COLUMN_FOTO, vi.getFoto());
        long insertId = database.insert(HelperVi.TABLE_VI, null, values);
        vi.setId(insertId);
        return vi;
    }
}
