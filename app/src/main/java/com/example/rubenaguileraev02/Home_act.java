package com.example.rubenaguileraev02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class Home_act extends AppCompatActivity {
    private ViewFlipper vF;
    private int [] image ={R.drawable.a, R.drawable.b, R.drawable.c};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_act);
        vF = (ViewFlipper)findViewById(R.id.slider_Home);
        for (int i=0; i<image.length; i++)
        {
            flip_image(image[i]);
        }
    }
    public void flip_image(int i)
    {
        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);
        vF.addView(view);
        vF.setFlipInterval(2800);
        vF.setAutoStart(true);
        vF.setInAnimation(this, android.R.anim.slide_in_left);
        vF.setOutAnimation(this, android.R.anim.slide_out_right);
    }
    public void ONCInfo(View V)
    {
        Intent i = new Intent(this, Info_act.class);
        startActivity(i);
    }
    public void ONCSeguridad(View V)
    {
        Intent i = new Intent(this, Seguridad_act.class);
        startActivity(i);
    }
    public void ONCPrestamos(View V)
    {
        ArrayList<String> arregloClientes = new ArrayList<String>();
        ArrayList<String> arregloCreditos = new ArrayList<String>();
        arregloClientes.add("Axel");
        arregloClientes.add("Roxana");
        arregloCreditos.add("Credito Hipotecario");
        arregloCreditos.add("Credito Automotriz");
        Intent i = new Intent(this, Prestamos_act.class);
        i.putExtra("Lista Clientes", arregloClientes);
        i.putExtra("Lista Creditos", arregloCreditos);
        startActivity(i);
    }
    public void ONCClientes(View V)
    {
        Intent i = new Intent(this, Clientes_act.class);
        startActivity(i);
    }
}