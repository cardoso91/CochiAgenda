package mx.itson.cochiagenda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import mx.itson.cochiagenda.entidades.Contacto;

public class registro extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        Button btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String nombre = ((EditText) findViewById(R.id.txtNombre)).getText().toString();
        String direccion = ((EditText) findViewById(R.id.txtDireccion)).getText().toString();
        String telefono = ((EditText) findViewById(R.id.txtTel)).getText().toString();

        Contacto contacto = new Contacto(this);

        contacto.agregar(nombre, telefono, direccion);

    }
}
