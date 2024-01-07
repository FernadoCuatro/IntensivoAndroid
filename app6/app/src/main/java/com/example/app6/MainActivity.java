package com.example.app6;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // creo un evento OnClickListener asociado al boton cuando se pulse
        Button btnCrearDB = (Button) findViewById(R.id.btnCrearDB);

        btnCrearDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // llamamos a la base de datos siendo un nuevo objeto BBDD
                BBDD dataBase = new BBDD(getApplicationContext(), "alumnos_db", null, 1);

                // apuntamos mediante la variable a la base de datos
                // accediendo a la db en modo escritura, tambien se puede solo en lectura
                SQLiteDatabase db = dataBase.getWritableDatabase();
            }
        });

        /*
        * insert, update y delete
        * Primer metodo
        * pocas posibilidades de opciones
        * insertar
        * db.execSQL("INSERT INTO alumnos (nombre) VALUES (6, 'melissa')");
        *
        * modificar
        * db.execSQL("UPDATE alumnos SET nombre='Ale' WHERE nombre='melissa'");
        *
        * eliminar
        * db.execSQL("DELETE FROM alumnos WHERE nombre='Ale'");
        *
        * segundo metodo
        * es bastante mas potente y se pueden hacer cosas mas sufisticadas
        * insertar
        * ContentValues nuevoRegistro = new ContentValues();
        * nuevoRegistro.put("nombre", "usuariopru");
        * db.insert("alumnos", null, nuevoRegistro)
        *
        * modificar
        * ContentValues editarRegistro = new ContentValues();
        * editarRegistro.put("nombre", "usuarionuevo");
        * db.update("alumnos", editarRegistro, "nombre='pepe'", null)
        *
        * borrar
        * db.delete("alumnos", "nombre='pepe'", null)
        *  */

        // insertamos nombre de alumno en la base de datos
        Button btnAddName = (Button) findViewById(R.id.btnAddName);
        btnAddName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BBDD dataBase = new BBDD(getApplicationContext(), "alumnos_db", null, 1);
                // apuntamos mediante la variable a la base de datos
                // accediendo a la db en modo escritura, tambien se puede solo en lectura
                SQLiteDatabase db = dataBase.getWritableDatabase();

                // obtenemos el dato desde el input
                EditText edtNombre = (EditText) findViewById(R.id.edtNombre);
                String nombre = edtNombre.getText().toString();

                // insertamos a base de datos
                db.execSQL("INSERT INTO alumnos (nombre) VALUES ('" + nombre + "')");
                edtNombre.setText("");
                db.close();
            }
        });

        /*
        * consulta
        * primer metodo
        * String[] args = new String[] {"usu1"}
        * Cursor c = db.rawQuery("SELECT codigo, nombre FROM usuarios WHERE nombre = ?", args)
        *
        * segundo metodo
        * String[] campos = new Strin[] ("codigo", "nombre")
        * String[] args = new String[] ("usu1")
        * Cursor c = db.query("usuarios", campos, "usuario=?", args, null, null, null)
        *
        * Parametros => GROUP BY, HAVING, ORDER BY
        * */
        // a lo que venimos
        Button btnFindName = (Button) findViewById(R.id.btnFindName);
        btnFindName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // campo a buscar
                String[] campos =  new String[] {"nombre"};
                String[] args = new String[] {""};

                // obtenemos el valor desde el input
                EditText edtNombre = (EditText) findViewById(R.id.edtNombre);
                args[0] = edtNombre.getText().toString();

                BBDD dataBase = new BBDD(getApplicationContext(), "alumnos_db", null, 1);
                // apuntamos mediante la variable a la base de datos
                // accediendo a la db en modo escritura, tambien se puede solo en lectura
                SQLiteDatabase db = dataBase.getWritableDatabase();

                // recupera un objeto de tipo cursor
                Cursor c = db.query("alumnos", campos, "nombre=?", args, null, null, null);

                int nombres = 0;
                // nos aseguramos que exista al menos un registro
                if (c.moveToFirst()) {
                    // recorremos el cursos hasta que no hayan mas registros
                    do {
                        String nombre = c.getString(0);
                        nombres++;
                    } while (c.moveToNext());
                }

                // sacamos el dato para mostrarlo
                TextView tvBusqueda = (TextView) findViewById(R.id.tvBusqueda);
                tvBusqueda.setText("Existen " + nombres + " alumnos con el nombre " + edtNombre.getText().toString());
            }
        });


    }
}