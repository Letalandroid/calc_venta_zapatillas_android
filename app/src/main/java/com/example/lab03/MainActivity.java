package com.example.lab03;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import DataAccessObject.ProductoDAO;
import DataTranserObject.ProductoBean;

public class MainActivity extends AppCompatActivity {

    private Spinner spnMarca;
    private Spinner spnTalla;
    private EditText txtCant;
    private Button btnCalc;
    private EditText txtResult;
    private ProductoBean prod;
    private ProductoDAO prodDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spnMarca = findViewById(R.id.spnMarca);
        spnTalla = findViewById(R.id.spnTalla);
        txtCant = findViewById(R.id.txtCant);
        btnCalc = findViewById(R.id.btnCalc);
        txtResult = findViewById(R.id.txtResult);
        prod = new ProductoBean();
        prodDAO = new ProductoDAO();

        btnCalc.setOnClickListener(v -> {
            calcular();
        });
    }

    private void calcular() {
        prod.setMarca(spnMarca.getSelectedItemPosition());
        prod.setTalla(spnTalla.getSelectedItemPosition());
        prod.setNumPares(Integer.parseInt(txtCant.getText().toString()));
        prod.setVentaNeta(prodDAO.calcVenta(prod));
        prod.setDescuento(prodDAO.calcDescuento(prod));
        txtResult.setText(prodDAO.calcOperation(prod));
    }
}