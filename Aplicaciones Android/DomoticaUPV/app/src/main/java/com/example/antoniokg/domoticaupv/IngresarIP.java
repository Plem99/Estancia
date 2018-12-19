package com.example.antoniokg.domoticaupv;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class IngresarIP extends AppCompatActivity {

    EditText direccionIP;
    TextView direccionActual;
    Button guardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar_ip);

        direccionIP = (EditText) findViewById(R.id.ip_txt);
        guardar = (Button) findViewById(R.id.guardar_btn);
        direccionActual = (TextView) findViewById(R.id.ipActual_txt);

        String ADDRESS = getIntent().getStringExtra("direccionIP");
        direccionActual.setText("Direccion IP actual: "+ADDRESS);
    }

    public void Modificar(View view){
        AdminSQLiteOpenHelper adminM = new AdminSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase BDD = adminM.getWritableDatabase();

        String direccionM = direccionIP.getText().toString();

        if(!direccionM.isEmpty()){
            ContentValues registroM = new ContentValues();
            //registroM.put("id",1);
            registroM.put("ip",direccionM);

            int cantidadM = BDD.update("direccion",registroM,"id = 1",null);
            BDD.close();
            Toast.makeText(this,"La direccion ip se ha modificado satisfactoriamente", Toast.LENGTH_SHORT).show();
            direccionIP.setText("");
            direccionActual.setText("Direccion IP actual: "+direccionM);
        }else{
            Toast.makeText(this,"Debe llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
}
