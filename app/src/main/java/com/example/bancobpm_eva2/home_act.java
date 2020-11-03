package com.example.bancobpm_eva2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class home_act extends AppCompatActivity {

    public ViewFlipper vf;
    public int [] images = {R.drawable.a, R.drawable.b, R.drawable.c};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_act);

        vf = (ViewFlipper) findViewById(R.id.slider);

        for (int i = 0; i < images.length; i++) {

            flip_image(images[i]);
        }
    }
    public void flip_image(int i)
    {
        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);

        vf.addView(view);
        vf.setFlipInterval(2200);
        vf.setAutoStart(true);

        vf.setInAnimation(this, android.R.anim.slide_in_left);
        vf.setOutAnimation(this, android.R.anim.slide_out_right);

    }

    public void clientes(View v)
    {
        Intent i = new Intent(getBaseContext(), clientes_act.class);
        startActivity(i);
    }

    public void prestamos(View v)
    {

        ArrayList<String> clientes = new ArrayList<String>();
        ArrayList<String> creditos = new ArrayList<String>();

        clientes.add("Axel");
        clientes.add("Roxana");

        clientes.add("Betzabe");
        clientes.add("Matias");


        creditos.add("Credito Hipotecario");
        creditos.add("Credito Automotriz");


        Intent i = new Intent(this, prestamos_act.class);
        i.putExtra("listaclientes", clientes);
        i.putExtra("tipocreditos", creditos);
        startActivity(i);

    }

    public void info(View v)
    {
        Intent i = new Intent(getBaseContext(), info_act.class);
        startActivity(i);
    }

    public void seguridad(View v)
    {
        Intent i = new Intent(getBaseContext(), seguridad_act.class);
        startActivity(i);
    }
}
