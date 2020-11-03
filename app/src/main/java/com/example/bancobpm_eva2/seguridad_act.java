package com.example.bancobpm_eva2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class seguridad_act extends AppCompatActivity {

    private EditText pass;
    private TextView texto_salida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seguridad_act);
        pass = (EditText)findViewById(R.id.pass_encrip);
        texto_salida = (TextView)findViewById(R.id.mostrar);

    }

    private SecretKeySpec generateKey(String passwd) throws Exception
    {
        MessageDigest sh = MessageDigest.getInstance("SHA-256");
        byte [] key = passwd.getBytes("UTF-8");
        key = sh.digest(key);

        SecretKeySpec secretKey = new SecretKeySpec(key,"AES");

        return secretKey;
    }

    public String encriptar(String datos,String passwd) throws Exception
    {

        if(!pass.getText().toString().isEmpty())
        {
            SecretKeySpec secretKey = generateKey(passwd);

            Cipher cipher = Cipher.getInstance("AES");

            cipher.init(cipher.ENCRYPT_MODE,secretKey);

            byte [] datosEncriptadosBt = cipher.doFinal(datos.getBytes());
            String datosEncriptadosSt = Base64.encodeToString(datosEncriptadosBt, Base64.DEFAULT);

            return datosEncriptadosSt;
        }
else
        {
            Toast.makeText(this,"Debe ingresar contraseña", Toast.LENGTH_LONG);
            return null;
        }
    }

    public void encriptar(View v)
    {

        try
        {
            String mensaje = encriptar(pass.getText().toString(),texto_salida.getText().toString());
            texto_salida.setText(mensaje);
        }catch(Exception e)

        {
            e.printStackTrace();
        }
    }
}