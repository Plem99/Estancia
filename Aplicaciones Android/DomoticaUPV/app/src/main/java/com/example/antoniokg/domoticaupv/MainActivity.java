package com.example.antoniokg.domoticaupv;

import android.content.Intent;
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
        Intent myIntent = new Intent(this,IngresarIP.class);
        startActivity(myIntent);
    }

    public void aControlRemoto(View view) {
        Intent myIntent = new Intent(this,ControlX10.class);
        startActivity(myIntent);
    }
}
