package com.example.app7;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

// clase que nos permite trabajar SQL
public class BBDD extends SQLiteOpenHelper {
    // constructor
    public BBDD(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // crea la base de datos
    @Override
    public void onCreate(SQLiteDatabase db) {
        // ejecutamos un comando
        db.execSQL("CREATE TABLE contactos (nombre TEXT, telefono TEXT)");
    }

    // creamos o actualizamos la base de datos
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // ejecutamos un comando
        db.execSQL("DROP TABLE IF EXISTS contactos");
        db.execSQL("CREATE TABLE contactos (nombre TEXT, telefono TEXT)");
    }

    // le decimos que nos genere los metodos obligatorios


}
