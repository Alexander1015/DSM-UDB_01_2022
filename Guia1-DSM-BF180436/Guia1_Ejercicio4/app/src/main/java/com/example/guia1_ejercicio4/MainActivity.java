package com.example.guia1_ejercicio4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText txtcant;
    private EditText txtpuntox;
    private EditText txtpuntoy;
    private Button btnprocesar;
    private Button btncontinuar;
    private TextView lblresultado;
    public int cantidad;
    public List<Integer> digitosx = new ArrayList<Integer>();
    public List<Integer> digitosy = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //--
        btncontinuar = findViewById(R.id.btnprocesar2);
        txtcant = findViewById(R.id.txtcantidad);
        //-
        btnprocesar = findViewById(R.id.btnprocesar);
        txtpuntox = findViewById(R.id.txtpuntox);
        txtpuntoy = findViewById(R.id.txtpuntoy);
        lblresultado = findViewById(R.id.lblresultado);
        lblresultado = findViewById(R.id.lblresultado);
    }

    public void cantidadtotal(View view) {
        try {
            String num = txtcant.getText().toString();
            int x = Integer.parseInt(num);
            if (x > 0) {
                cantidad = x;
                //--
                btncontinuar.setVisibility(View.INVISIBLE);
                txtcant.setVisibility(View.INVISIBLE);
                //--
                txtpuntox.setVisibility(View.VISIBLE);
                txtpuntoy.setVisibility(View.VISIBLE);
                btnprocesar.setVisibility(View.VISIBLE);
                lblresultado.setVisibility(View.VISIBLE);
                //--
                txtcant.setText("");
                txtpuntox.setText("");
                txtpuntoy.setText("");
                lblresultado.setText("");
            }
            else {
                cantidad = 0;
                //--
                btncontinuar.setVisibility(View.VISIBLE);
                txtcant.setVisibility(View.VISIBLE);
                //--
                txtpuntox.setVisibility(View.INVISIBLE);
                txtpuntoy.setVisibility(View.INVISIBLE);
                btnprocesar.setVisibility(View.INVISIBLE);
                lblresultado.setVisibility(View.INVISIBLE);
                //--
                txtpuntox.setText("");
                txtpuntoy.setText("");
                lblresultado.setText("");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void agregar(View view) {
        try {
            if (cantidad > 1) {
                String numx = txtpuntox.getText().toString();
                int x = Integer.parseInt(numx);
                String numy = txtpuntoy.getText().toString();
                int y = Integer.parseInt(numy);
                digitosx.add(x);
                digitosy.add(y);
                cantidad--;
            }
            else if (cantidad == 1) {
                //--
                String numx = txtpuntox.getText().toString();
                int ulx = Integer.parseInt(numx);
                String numy = txtpuntoy.getText().toString();
                int uly = Integer.parseInt(numy);
                digitosx.add(ulx);
                digitosy.add(uly);
                cantidad--;
                //--
                String resultado = "";
                int cuadran1 = 0;
                int cuadran2 = 0;
                int cuadran3 = 0;
                int cuadran4 = 0;
                if (digitosx.size() == digitosy.size()) {
                    for (int i = 0; i < digitosx.size(); i++) {
                        int x = digitosx.get(i);
                        int y = digitosy.get(i);
                        if (x >= 0 && y >= 0) cuadran1++;
                        else if (x <= 0 && y >= 0) cuadran2++;
                        else if (x <= 0 && y <= 0) cuadran3++;
                        else if (x >= 0 && y <= 0) cuadran4++;
                    }
                }
                txtpuntox.setVisibility(View.INVISIBLE);
                txtpuntoy.setVisibility(View.INVISIBLE);
                btnprocesar.setVisibility(View.INVISIBLE);
                resultado = "Hay " + cuadran1 + " en el cuadrante [x,y], " + cuadran2 + " en el cuadrante [-x,y], " + cuadran3 + " en el cuadrante [-x,-y], " + cuadran4 + " en el cuadrante [x,-y]";
                lblresultado.setText(resultado);
            }
            txtpuntox.setText("");
            txtpuntoy.setText("");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}