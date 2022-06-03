package sv.edu.udb.guia2_ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView lblNombreEmp;
    private TextView lblHorasTot;
    private TextView lblSalarioNeto;
    private TextView lblISSS;
    private TextView lblAFP;
    private TextView lblRenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lblNombreEmp = (TextView) findViewById(R.id.lblNombreEmp);
        lblHorasTot = (TextView) findViewById(R.id.lblHorasTot);
        lblSalarioNeto = (TextView) findViewById(R.id.lblSalarioNeto);
        lblISSS = (TextView) findViewById(R.id.lblISSS);
        lblAFP = (TextView) findViewById(R.id.lblAFP);
        lblRenta = (TextView) findViewById(R.id.lblRenta);

        Bundle bundle = getIntent().getExtras();
        String nombre = bundle.getString("txtNombre");
        String HorasTot = bundle.getString("txtHorasTot");
        double isss = bundle.getDouble("txtISSS");
        double afp = bundle.getDouble("txtAFP");
        double renta = bundle.getDouble("txRenta");
        double neto = bundle.getDouble("txtSalarioNeto");

        lblNombreEmp.setText("Nombre: " + nombre);
        lblHorasTot.setText("Horas: " + HorasTot);
        lblISSS.setText("ISSS (2%): $" + isss);
        lblAFP.setText("AFP (3%): $" + afp);
        lblRenta.setText("Renta (4%): $" + renta);
        lblSalarioNeto.setText("Salario Neto: $" + neto);

    }

    public void finalizar(View v) {
        finish();
    }
}