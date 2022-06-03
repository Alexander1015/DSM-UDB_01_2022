package sv.edu.udb.guia4_ejercicio2;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import sv.edu.udb.guia4_ejercicio2.datos.DatePickerFragment;
import sv.edu.udb.guia4_ejercicio2.datos.Persona;

public class AddPersonaActivity extends AppCompatActivity {

    EditText edtDUI, edtNombre, edtNacimiento, edtGenero, edtPeso, edtAltura;
    String key="",nombre="",dui="",accion="", nacimiento = "", genero = "";
    Double peso = 0.0, altura = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_persona);
        inicializar();
    }

    private void inicializar() {
        edtNombre = findViewById(R.id.edtNombre);
        edtDUI = findViewById(R.id.edtDUI);
        edtNacimiento = findViewById(R.id.edtNacimiento);
        edtGenero = findViewById(R.id.edtGenero);
        edtPeso = findViewById(R.id.edtPeso);
        edtAltura = findViewById(R.id.edtAltura);

        // Obtención de datos que envia actividad anterior
        Bundle datos = getIntent().getExtras();
        key = datos.getString("key");
        dui = datos.getString("dui");
        nombre=datos.getString("nombre");
        nombre=datos.getString("nombre");
        nacimiento = datos.getString("nacimiento");
        genero = datos.getString("genero");
        peso = datos.getDouble("peso");
        altura = datos.getDouble("altura");
        accion=datos.getString("accion");
        edtDUI.setText(dui);
        edtNombre.setText(nombre);
        edtNacimiento.setText(nacimiento);
        edtGenero.setText(genero);
        edtPeso.setText(peso.toString());
        edtAltura.setText(altura.toString());
    }

    public void guardar(View v){
        String nombre = edtNombre.getText().toString();
        String dui = edtDUI.getText().toString();
        String nacimiento = edtNacimiento.getText().toString();
        String genero = edtGenero.getText().toString();
        Double peso = Double.parseDouble(edtPeso.getText().toString());
        Double altura = Double.parseDouble(edtAltura.getText().toString());
        // Se forma objeto persona
        Persona persona = new Persona(dui,nombre, nacimiento, genero, peso, altura);

        if (accion.equals("a")) { //Agregar usando push()
            PersonasActivity.refPersonas.push().setValue(persona);
        }
        else // Editar usando setValue
        {
            PersonasActivity.refPersonas.child(key).setValue(persona);
        }
        finish();
    }
    public void cancelar(View v){
        finish();
    }

    public void onClickFecha (View view) {
        showDatePickerDialog();
    }

    private void showDatePickerDialog() {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // +1 because January is zero
                final String selectedDate = day + " / " + (month+1) + " / " + year;
                edtNacimiento.setText(selectedDate);
            }
        });

        newFragment.show(this.getSupportFragmentManager(), "datePicker");
    }

}