package sv.edu.udb.guia2_ejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView lblresultado;
    public int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lblresultado = findViewById(R.id.lblNum);
        if (savedInstanceState != null) {
            contador = savedInstanceState.getInt("contador");
            lblresultado.setText(String.valueOf(contador));
        }
    }

    public void sumar(View view) {
        contador++;
        if (contador > 9) contador = 0;

        lblresultado.setText(String.valueOf(contador));
    }

    @Override
    protected void onSaveInstanceState(Bundle estado) {
        super.onSaveInstanceState(estado);
        estado.putInt("contador", contador);
    }

    @Override
    protected void onRestoreInstanceState(Bundle estado) {
        super.onRestoreInstanceState(estado);
        contador = estado.getInt("contador");
        lblresultado.setText(String.valueOf(contador));
    }
}