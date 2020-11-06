package com.example.rubenaguileraev02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Clases.AdminSQLiteOpenHelper;

public class Clientes_act extends AppCompatActivity {
    private EditText codigoC;
    private EditText nombreC;
    private EditText salarioC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_act);
        codigoC = (EditText)findViewById(R.id.edtxt_CodigoC);
        nombreC = (EditText)findViewById(R.id.edtxt_NombreC);
        salarioC = (EditText)findViewById(R.id.edtxt_SalarioC);
    }
    public void ONCGuardarCliente(View V)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);

        SQLiteDatabase db = admin.getWritableDatabase(); // permite sobreescribir en la base de datos

        if(!codigoC.getText().toString().isEmpty())
        {
            ContentValues cont= new ContentValues();
            cont.put("codigo", codigoC.getText().toString());
            cont.put("nombre", nombreC.getText().toString().trim().toLowerCase());
            cont.put("salario", salarioC.getText().toString());
            db.insert("clientesDb", null, cont);
            db.close();
            Toast.makeText(this, "Se a guardado el Cliente : "+ nombreC.getText().toString(), Toast.LENGTH_LONG).show();
            nombreC.setText("");
            salarioC.setText("");
        }
        else {

            Toast.makeText(this, "Debe rellenar los campos", Toast.LENGTH_LONG).show();
        }
    }
    public void ONCMostrarCliente(View V)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String codigo = codigoC.getText().toString();
        if(!codigo.isEmpty())
        {
            Cursor fila = db.rawQuery("SELECT nombre, salario FROM clientesDb WHERE codigo="+codigo, null);
            if(fila.moveToFirst())
            {
                nombreC.setText(fila.getString(0));
                salarioC.setText(fila.getString(1));

            }
            else {

                Toast.makeText(this, "No hay datos del Cliente", Toast.LENGTH_LONG).show();
            }

        }
        else {

            Toast.makeText(this, "debe ingresar un codigo correcto o existente", Toast.LENGTH_LONG).show();
        }

    }
    public void ONCEliminarCliente(View V)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String codigo = codigoC.getText().toString();
        if(!codigo.isEmpty())
        {
            Toast.makeText(this, "Has eliminado al Cliente : " + nombreC.getText().toString(), Toast.LENGTH_LONG).show();
            db.delete("clientesDb", "codigo="+codigo, null);
            db.close();
            codigoC.setText("");
            nombreC.setText("");
            salarioC.setText("");
        }
        else {
            Toast.makeText(this, "Debe ingresar el codigo del Cliente", Toast.LENGTH_LONG).show();
        }

    }
    public void ONCActualizarCliente(View V)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String codigo = codigoC.getText().toString();
        ContentValues cont = new ContentValues();
        cont.put("codigo", codigoC.getText().toString());
        cont.put("nombre", nombreC.getText().toString());
        cont.put("salario", salarioC.getText().toString());
        if(!codigo.isEmpty())
        {
            db.update("clientesDb", cont,"codigo="+codigo, null);
            db.close();
            Toast.makeText(this, "has actualizado al Cliente : "+ nombreC.getText().toString(), Toast.LENGTH_LONG).show();
            nombreC.setText("");
            salarioC.setText("");
        }
        else {

            Toast.makeText(this, "Debe rellenar los campos", Toast.LENGTH_LONG).show();
        }

    }
}