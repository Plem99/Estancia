package com.example.antoniokg.domoticaupv;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void aIngresar(View view) {
        AdminSQLiteOpenHelper adminI = new AdminSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase BDD = adminI.getWritableDatabase();

        Cursor fila = BDD.rawQuery("select ip from direccion where id = 1",null);
        if(fila.moveToFirst()){
            String Address = fila.getString(0);
            BDD.close();
            Intent myIntent = new Intent(this,IngresarIP.class);
            myIntent.putExtra("direccionIP",Address);
            startActivity(myIntent);
        }
    }

    public void aControlRemoto(View view) {
        AdminSQLiteOpenHelper adminC = new AdminSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase BDD = adminC.getWritableDatabase();

        Cursor fila = BDD.rawQuery("select ip from direccion where id = 1",null);
        if(fila.moveToFirst()){
            String Address = fila.getString(0);
            BDD.close();
            Intent myIntent = new Intent(this,ControlX10.class);
            myIntent.putExtra("direccionIP",Address);
            startActivity(myIntent);
        }
    }
}
