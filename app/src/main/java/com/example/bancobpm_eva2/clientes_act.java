package com.example.bancobpm_eva2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Clases.AdminSQLiteOpenHelper;

public class clientes_act extends AppCompatActivity {

    private EditText txtcodigo, txtnombre, txtsalario;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_act);

        txtcodigo   = (EditText)findViewById(R.id.txtcodigo);
        txtnombre   = (EditText)findViewById(R.id.txtnombre);
        txtsalario  = (EditText)findViewById(R.id.txtsalario);
    }

    public void guardar(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        if (!txtcodigo.getText().toString().isEmpty()) {
            ContentValues registro = new ContentValues();

            registro.put("codigo", txtcodigo.getText().toString());
            registro.put("nombre", txtnombre.getText().toString());
            registro.put("salario", txtsalario.getText().toString());

            bd.insert("clientes", null, registro);
            bd.close();

            Toast.makeText(this, "Guardado con Exito.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Debe ingresar dato.", Toast.LENGTH_SHORT).show();
        }
    }

    public void mostrar(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String codigo = txtcodigo.getText().toString();

        if(!codigo.isEmpty())
        {
            Cursor fila = bd.rawQuery("SELECT nombre, salario FROM clientes WHERE codigo= " + codigo, null);

            if (fila.moveToFirst())
            {
                txtnombre.setText(fila.getString(0));
                txtsalario.setText(fila.getString(1));
            }
            else
            {
                Toast.makeText(this, "No hay código asociado a cliente", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void eliminar(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String codigo = txtcodigo.getText().toString();

        bd.delete("clientes", "codigo="+codigo, null);
        bd.close();

         Toast.makeText(this, "Registro eliminado.", Toast.LENGTH_SHORT).show();
    }

    public void actualizar(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String codigo = txtcodigo.getText().toString();

        ContentValues act = new ContentValues();

        act.put("codigo", txtcodigo.getText().toString());
        act.put("nombre", txtnombre.getText().toString());
        act.put("salario", txtsalario.getText().toString());

        if(!codigo.isEmpty())
        {
            bd.update("clientes", act, "codigo="+codigo, null);
            Toast.makeText(this, "Registro Actualizado", Toast.LENGTH_LONG).show();
        }
    }
}