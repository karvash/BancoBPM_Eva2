package com.example.bancobpm_eva2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.EditText;

import java.util.ArrayList;
import Clases.creditos;

public class prestamos_act extends AppCompatActivity {

    private Spinner clientes;
    private Spinner creditos;
    private TextView resultado;
    private EditText edit;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestamos_act);

        clientes = (Spinner)findViewById(R.id.clientes);
        creditos = (Spinner)findViewById(R.id.creditos);
        resultado = (TextView)findViewById(R.id.resultado);

        // Recibir el dato.
        // <----
        ArrayList<String> listaclientes = (ArrayList<String>) getIntent().getSerializableExtra("listaclientes");
        ArrayList<String> tipocreditos = (ArrayList<String>) getIntent().getSerializableExtra("tipocreditos");


        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaclientes);
        ArrayAdapter<String> adapts = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tipocreditos);

        clientes.setAdapter(adapt);
        creditos.setAdapter(adapts);
    }

    public void Calcular_prestamo(View v)
    {
        String cliente = clientes.getSelectedItem().toString();
        String credito = creditos.getSelectedItem().toString();

        creditos tipo_credito = new creditos();

        int saldo_credito = 0;

        if (cliente.equals("Axel")&& (credito.equals("Credito Automotriz"))) {
        saldo_credito = (tipo_credito.getAutomotriz()) +750000;

        resultado.setText("Saldo final es "+saldo_credito);


    }
        if (cliente.equals("Axel")&& (credito.equals("Credito Hipotecario"))) {
        saldo_credito = (tipo_credito.getHipotecario()) +750000;

        resultado.setText("Saldo final es "+saldo_credito);


        }

        if (cliente.equals("Roxana")&& (credito.equals("Credito Automotriz"))) {
            saldo_credito = (tipo_credito.getAutomotriz()) +900000;

            resultado.setText("Saldo final es "+saldo_credito);


        }
        if (cliente.equals("Roxana")&& (credito.equals("Credito Hipotecario"))) {
            saldo_credito = (tipo_credito.getHipotecario()) +900000;

            resultado.setText("Saldo final es "+saldo_credito);
        }

    }



    public void Calcular_deuda(View v)
    {
        String cliente = clientes.getSelectedItem().toString();
        String credito = creditos.getSelectedItem().toString();

        creditos tipo_credito = new creditos();

        int saldo_credito = 0;

        if (cliente.equals("Axel")&& (credito.equals("Credito Automotriz"))) {
            saldo_credito = ((tipo_credito.getAutomotriz()) +750000)/8;

            resultado.setText("Saldo final es "+saldo_credito);


        }
        if (cliente.equals("Axel")&& (credito.equals("Credito Hipotecario"))) {
            saldo_credito = ((tipo_credito.getHipotecario()) +750000)/12;

            resultado.setText("Saldo final es "+saldo_credito);


        }

        if (cliente.equals("Roxana")&& (credito.equals("Credito Automotriz"))) {
            saldo_credito = ((tipo_credito.getAutomotriz()) +900000)/8;

            resultado.setText("Saldo final es "+saldo_credito);


        }
        if (cliente.equals("Roxana")&& (credito.equals("Credito Hipotecario"))) {
            saldo_credito = ((tipo_credito.getHipotecario()) +900000)/12;

            resultado.setText("Saldo final es "+saldo_credito);
        }
    }
}