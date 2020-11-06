package com.example.rubenaguileraev02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import Clases.Credito;

public class Prestamos_act extends AppCompatActivity {
    private Spinner spClientes;
    private Spinner spCredito;
    private TextView textoP;
    private int sAxel = 750000;
    private int sRoxana = 900000;
    private int saldoVariante = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestamos_act);
        spClientes = (Spinner)findViewById(R.id.spn_ClientesP);
        spCredito = (Spinner)findViewById(R.id.spn_CreditoP);
        textoP = (TextView) findViewById(R.id.txt_ResultadoP);
        ArrayList<String> listaClientes = (ArrayList<String>) getIntent().getSerializableExtra("Lista Clientes");
        ArrayList<String>listaCreditos = (ArrayList<String>) getIntent().getSerializableExtra("Lista Creditos");
        ArrayAdapter<String> adaptClientesP = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaClientes);
        ArrayAdapter<String> adaptCreditoP = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaCreditos);
        spClientes.setAdapter(adaptClientesP);
        spCredito.setAdapter(adaptCreditoP);
    }
    public void ONCCalcularPrestamo(View V){
        String creditoSp = spCredito.getSelectedItem().toString();
        String clientesSp = spClientes.getSelectedItem().toString();
        Credito credito = new Credito();
        if(creditoSp.equals("Credito Hipotecario"))
        {
            if(clientesSp.equals("Axel"))
            {
                calculoC(sAxel, credito.getCreditoHipotecario(), 1);

            }
            if(clientesSp.equals("Roxana"))
            {
                calculoC(sRoxana, credito.getCreditoHipotecario(), 1);
            }
            else {
                calculoC(saldoVariante, credito.getCreditoHipotecario(), 1);
            }
        }
        else {

            if(clientesSp.equals("Axel"))
            {
                calculoC(sAxel, credito.getCreditoAutomotriz(), 1);
            }
            if(clientesSp.equals("Roxana"))
            {
                calculoC(sRoxana, credito.getCreditoAutomotriz(), 1);
            }
            else{
                calculoC(saldoVariante, credito.getCreditoAutomotriz(),1);
            }
        }
        saldoVariante= 0;
    }
    public void ONCCalcularDeudas(View V){
        String creditoSp = spCredito.getSelectedItem().toString();
        String clientesSp = spClientes.getSelectedItem().toString();
        Credito credito = new Credito();
        if(creditoSp.equals("Credito Hipotecario"))
        {
            if(clientesSp.equals("Axel"))
            {
                calculoC(sAxel, credito.getCreditoHipotecario(), 12);

            }
            if(clientesSp.equals("Roxana"))
            {
                calculoC(sRoxana, credito.getCreditoHipotecario(), 12);
            }
            else {
                calculoC(saldoVariante, credito.getCreditoHipotecario(), 12);
            }
        }
        else {

            if(clientesSp.equals("Axel"))
            {
                calculoC(sAxel, credito.getCreditoAutomotriz(), 8);
            }
            if(clientesSp.equals("Roxana"))
            {
                calculoC(sRoxana, credito.getCreditoAutomotriz(), 8);
            }
            else{
                calculoC(saldoVariante, credito.getCreditoAutomotriz(),8);
            }
        }
        saldoVariante= 0;
    }

    // funcion para calcular deudas y creditos
    public void calculoC (int x, int y,int z)
    {
        saldoVariante =(x+y)/z;
        textoP.setText(""+saldoVariante);
    }

}