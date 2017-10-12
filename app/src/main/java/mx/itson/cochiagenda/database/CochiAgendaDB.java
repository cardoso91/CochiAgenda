package mx.itson.cochiagenda.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Cardoso on 3/17/17.
 * Implmenta los metodos de sql para la base de datos de los contactos
 */

public class CochiAgendaDB extends SQLiteOpenHelper {

    public CochiAgendaDB (Context contextoActual, String nombre, SQLiteDatabase.CursorFactory factory, int version) {

        super(contextoActual, nombre, factory, version);

    }

    public void onUpgrade (SQLiteDatabase baseDatos, int versionAnterior, int versionNueva) {


    }

    public void onCreate (SQLiteDatabase baseDatos) {

        try {
            baseDatos.execSQL("CREATE TABLE Contacto" + "(id INTEGER PRIMARY " + "KEY AUTOINCREMENT, "+ "nombre TEXT, " + "telefono TEXT)");
            baseDatos.execSQL("CREATE TABLE Direccion" + "(id INTEGER PRIMARY " + "KEY AUTOINCREMENT, " + "direccion TEXT, " + "idContacto INTEGER, " + " FOREIGN KEY (idContacto) REFERENCES Contacto(id))");

        } catch (Exception e) {
            Log.i ("Error", e.getMessage());
        }

    }


}
