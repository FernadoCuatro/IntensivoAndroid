package com.example.app6;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// SQLiteOpenHelper es la clase que nos permite trabajar con base de datos

public class BBDD extends SQLiteOpenHelper {
    // constructor personalizado
    public BBDD (Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // metodo para crear una tabla
    @Override
    public void onCreate(SQLiteDatabase db) {
        // el comando create database esta explicito y lo hace automaticamente
        db.execSQL("CREATE TABLE alumnos (nombre TEXT)");
    }

    // metodo para modifificar en el cazo sera necesario
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS alumnos");

        // se crea la nueva version de la tabla
        db.execSQL("CREATE TABLE alumnos (nombre TEXT)");
    }
}
