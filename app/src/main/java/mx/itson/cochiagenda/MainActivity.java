package mx.itson.cochiagenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import mx.itson.cochiagenda.entidades.Contacto;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView = (ListView) findViewById(R.id.listContactos);
        List<Contacto> contactos = new ArrayList<Contacto>();
        Contacto c = new Contacto(this);
        contactos = c.obtenerLista();
        ArrayAdapter<Contacto> arrayAdapter = new ArrayAdapter<Contacto>(this, R.layout.listview_renglon, contactos);
        listView.setAdapter(arrayAdapter);

        listView.setClickable(true);
    }

    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_registro:
                Intent intent = new Intent(MainActivity.this, registro.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
