package mx.itson.cochiagenda.entidades;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mx.itson.cochiagenda.database.CochiAgendaDB;

/**
 * Created by Cardoso on 3/17/17.
 */

public class Contacto {

    Context context;
    public Contacto () {}
    public Contacto (Context context) { this.context = context; }

    private int id;
    private String nombre;
    private String direccion;
    private String telefono;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void agregar (String nombre, String telefono, String direccion){
        try{
            CochiAgendaDB bd = new CochiAgendaDB(context, "CochiAgendaDB", null, 1);
            SQLiteDatabase baseDatos = bd.getReadableDatabase();
            baseDatos.execSQL("INSERT INTO Contacto " +
            "(nombre, " +
            "telefono, " +
            "direccion) VALUES " +
            "('" + nombre + "', '" +
            telefono + "', '" +
            direccion +
            "')");

            baseDatos.close();
            Toast.makeText(context, "El registro se guardo correctamente.", Toast.LENGTH_LONG).show();
        }catch (Exception e) {
            Toast.makeText(context, "Ocurrio el siguiente error: " + e.getMessage(), Toast.LENGTH_LONG).show();

        }
    }

    public Contacto obtenerPorId (int id) {
        CochiAgendaDB bd = new CochiAgendaDB(context, "CochiAgendaDB", null, 1);
        SQLiteDatabase baseDatos = bd.getReadableDatabase();
        Cursor cursor = baseDatos.rawQuery("SELECT id, nombre, direccion, telefono " +
                "FROM Contacto WHERE id = '" + id + "'", null);
        if(cursor.moveToFirst()) {
            while (cursor.moveToNext()) {
                this.setId(Integer.parseInt(cursor.getString(0)));
                this.setNombre(cursor.getString(1));
                this.setDireccion(cursor.getString(2));
                this.setTelefono(cursor.getString(3));
            }
        }
        return this;
    }

    public List<Contacto> obtenerLista (){
        List<Contacto> contactos = new ArrayList<Contacto>();
        try{
            CochiAgendaDB bd = new CochiAgendaDB(context, "CochiAgendaDB", null, 1);
            SQLiteDatabase baseDatos = bd.getReadableDatabase();
            String query = "SELECT id, nombre, direccion, telefono FROM Contacto";
            Cursor cursor = baseDatos.rawQuery(query, null);
            if(cursor.moveToFirst()) {
                while(cursor.moveToNext()) {
                    Contacto contacto = new Contacto();
                    contacto.setId(Integer.parseInt(cursor.getString(0)));
                    contacto.setNombre(cursor.getString(1) != null ? cursor.getString(1) : "");
                    contacto.setDireccion(cursor.getString(2) != null ? cursor.getString(2) : "");
                    contacto.setTelefono(cursor.getString(3) != null ? cursor.getString(3) : "");

                    contactos.add(contacto);
                }
            }
            baseDatos.close();
        }catch (Exception e) {

        }
        return contactos;
    }

    public String toString() { return this.nombre; }
}
