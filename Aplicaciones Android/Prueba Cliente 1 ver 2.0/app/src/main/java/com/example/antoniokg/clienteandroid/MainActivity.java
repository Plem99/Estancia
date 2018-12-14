package com.example.antoniokg.clienteandroid;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /**
     * Controles
     * */
    private Button button;
    private EditText editText;
    private EditText editText2;
    private Context context = this;

    private TextView Ncod1;
    private TextView Ncod2;
    private TextView Ncod3;
    private TextView Ncod4;
    private TextView Ncod5;
    private TextView Ncod6;
    private TextView Ncod7;
    private TextView Ncod8;
    private ListView listView;
    private Button on1;
    private Button on2;
    private Button on3;
    private Button on4;
    private Button on5;
    private Button on6;
    private Button on7;
    private Button on8;
    private Button off1;
    private Button off2;
    private Button off3;
    private Button off4;
    private Button off5;
    private Button off6;
    private Button off7;
    private Button off8;
    public int bandera=1;
    public String texto;
    Switch aSwitch;
    /**
     * Puerto
     * */
    private static final int SERVERPORT = 1099;
    /**
     * HOST
     * */
    private static String ADDRESS="192.168.1.114";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        button = ((Button) findViewById(R.id.button));
        editText = ((EditText) findViewById(R.id.editText));
        editText2 = ((EditText) findViewById(R.id.editText2));

        Ncod1 = ((TextView) findViewById(R.id.Ncod1));
        Ncod2 = ((TextView) findViewById(R.id.Ncod2));
        Ncod3 = ((TextView) findViewById(R.id.Ncod3));
        Ncod4 = ((TextView) findViewById(R.id.Ncod4));
        Ncod5 = ((TextView) findViewById(R.id.Ncod5));
        Ncod6 = ((TextView) findViewById(R.id.Ncod6));
        Ncod7 = ((TextView) findViewById(R.id.Ncod7));
        Ncod8 = ((TextView) findViewById(R.id.Ncod8));
        //listView = ((ListView) findViewById(R.id.listView));
        on1 = ((Button) findViewById(R.id.on1));
        on2 = ((Button) findViewById(R.id.on2));
        on3 = ((Button) findViewById(R.id.on3));
        on4 = ((Button) findViewById(R.id.on4));
        on5 = ((Button) findViewById(R.id.on5));
        on6 = ((Button) findViewById(R.id.on6));
        on7 = ((Button) findViewById(R.id.on7));
        on8 = ((Button) findViewById(R.id.on8));
        off1 = ((Button) findViewById(R.id.off1));
        off2 = ((Button) findViewById(R.id.off2));
        off3 = ((Button) findViewById(R.id.off3));
        off4 = ((Button) findViewById(R.id.off4));
        off5 = ((Button) findViewById(R.id.off5));
        off6 = ((Button) findViewById(R.id.off6));
        off7 = ((Button) findViewById(R.id.off7));
        off8 = ((Button) findViewById(R.id.off8));

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("a");

        aSwitch = (Switch) findViewById(R.id.switch1);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked == true){
                    Toast.makeText(getBaseContext(),"9-16",Toast.LENGTH_SHORT).show();
                    Ncod1.setText("9");
                    Ncod2.setText("10");
                    Ncod3.setText("11");
                    Ncod4.setText("12");
                    Ncod5.setText("13");
                    Ncod6.setText("14");
                    Ncod7.setText("15");
                    Ncod8.setText("16");
                    bandera=2;
                }else if(isChecked == false){
                    Toast.makeText(getBaseContext(),"1-8",Toast.LENGTH_SHORT).show();
                    Ncod1.setText("1");
                    Ncod2.setText("2");
                    Ncod3.setText("3");
                    Ncod4.setText("4");
                    Ncod5.setText("5");
                    Ncod6.setText("6");
                    Ncod7.setText("7");
                    Ncod8.setText("8");
                    bandera=1;
                }
            }
        });
        /*button.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        if(editText.getText().toString().length()>0){
                            MyATaskCliente myATaskYW = new MyATaskCliente();
                            myATaskYW.execute(editText.getText().toString());
                        }else{
                            Toast.makeText(context, "Escriba \"Caracter\"", Toast.LENGTH_LONG).show();
                        }

                    }
                });*/
        //==============================   IP   =============================================
        /*button.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {

                        MyATaskCliente myATaskYW = new MyATaskCliente();
                        ADDRESS = editText.getText().toString();
                        //myATaskYW.execute(editText.getText().toString());


                    }
                });*/
        //================================    ON   =================================================================
        on1.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View view) {
                        if (bandera == 1) {
                            MyATaskCliente myATaskYW = new MyATaskCliente();
                            texto = editText.getText().toString();
                            myATaskYW.execute(texto + "1 on");
                        }else
                            if(bandera==2){
                                MyATaskCliente myATaskYW = new MyATaskCliente();
                                texto = editText.getText().toString();
                                myATaskYW.execute(texto + "9 on");
                        }

                    }
                });

        on2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if (bandera == 1) {
                    MyATaskCliente myATaskYW = new MyATaskCliente();
                    texto = editText.getText().toString();
                    myATaskYW.execute(texto + "2 on");
                }else
                if(bandera==2){
                    MyATaskCliente myATaskYW = new MyATaskCliente();
                    texto = editText.getText().toString();
                    myATaskYW.execute(texto + "10 on");
                }

            }
        });

        on3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if (bandera == 1) {
                    MyATaskCliente myATaskYW = new MyATaskCliente();
                    texto = editText.getText().toString();
                    myATaskYW.execute(texto + "3 on");
                }else
                if(bandera==2){
                    MyATaskCliente myATaskYW = new MyATaskCliente();
                    texto = editText.getText().toString();
                    myATaskYW.execute(texto + "11 on");
                }

            }
        });

        on4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if (bandera == 1) {
                    MyATaskCliente myATaskYW = new MyATaskCliente();
                    texto = editText.getText().toString();
                    myATaskYW.execute(texto + "4 on");
                }else
                if(bandera==2){
                    MyATaskCliente myATaskYW = new MyATaskCliente();
                    texto = editText.getText().toString();
                    myATaskYW.execute(texto + "12 on");
                }

            }
        });

        on5.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if (bandera == 1) {
                    MyATaskCliente myATaskYW = new MyATaskCliente();
                    texto = editText.getText().toString();
                    myATaskYW.execute(texto + "5 on");
                }else
                if(bandera==2){
                    MyATaskCliente myATaskYW = new MyATaskCliente();
                    texto = editText.getText().toString();
                    myATaskYW.execute(texto + "13 on");
                }

            }
        });

        on6.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if (bandera == 1) {
                    MyATaskCliente myATaskYW = new MyATaskCliente();
                    texto = editText.getText().toString();
                    myATaskYW.execute(texto + "6 on");
                }else
                if(bandera==2){
                    MyATaskCliente myATaskYW = new MyATaskCliente();
                    texto = editText.getText().toString();
                    myATaskYW.execute(texto + "14 on");
                }

            }
        });

        on7.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if (bandera == 1) {
                    MyATaskCliente myATaskYW = new MyATaskCliente();
                    texto = editText.getText().toString();
                    myATaskYW.execute(texto + "7 on");
                }else
                if(bandera==2){
                    MyATaskCliente myATaskYW = new MyATaskCliente();
                    texto = editText.getText().toString();
                    myATaskYW.execute(texto + "15 on");
                }

            }
        });

        on8.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if (bandera == 1) {
                    MyATaskCliente myATaskYW = new MyATaskCliente();
                    texto = editText.getText().toString();
                    myATaskYW.execute(texto + "8 on");
                }else
                if(bandera==2){
                    MyATaskCliente myATaskYW = new MyATaskCliente();
                    texto = editText.getText().toString();
                    myATaskYW.execute(texto + "16 on");
                }

            }
        });
        //===============================================   OFF  ========================================================
        off1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if (bandera == 1) {
                    MyATaskCliente myATaskYW = new MyATaskCliente();
                    texto = editText.getText().toString();
                    myATaskYW.execute(texto + "1 off");
                }else
                if(bandera==2){
                    MyATaskCliente myATaskYW = new MyATaskCliente();
                    texto = editText.getText().toString();
                    myATaskYW.execute(texto + "9 off");
                }

            }
        });

        off2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if (bandera == 1) {
                    MyATaskCliente myATaskYW = new MyATaskCliente();
                    texto = editText.getText().toString();
                    myATaskYW.execute(texto + "2 off");
                }else
                if(bandera==2){
                    MyATaskCliente myATaskYW = new MyATaskCliente();
                    texto = editText.getText().toString();
                    myATaskYW.execute(texto + "10 off");
                }

            }
        });

        off3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if (bandera == 1) {
                    MyATaskCliente myATaskYW = new MyATaskCliente();
                    texto = editText.getText().toString();
                    myATaskYW.execute(texto + "3 off");
                }else
                if(bandera==2){
                    MyATaskCliente myATaskYW = new MyATaskCliente();
                    texto = editText.getText().toString();
                    myATaskYW.execute(texto + "11 off");
                }

            }
        });

        off4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if (bandera == 1) {
                    MyATaskCliente myATaskYW = new MyATaskCliente();
                    texto = editText.getText().toString();
                    myATaskYW.execute(texto + "4 off");
                }else
                if(bandera==2){
                    MyATaskCliente myATaskYW = new MyATaskCliente();
                    texto = editText.getText().toString();
                    myATaskYW.execute(texto + "12 off");
                }

            }
        });

        off5.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if (bandera == 1) {
                    MyATaskCliente myATaskYW = new MyATaskCliente();
                    texto = editText.getText().toString();
                    myATaskYW.execute(texto + "5 off");
                }else
                if(bandera==2){
                    MyATaskCliente myATaskYW = new MyATaskCliente();
                    texto = editText.getText().toString();
                    myATaskYW.execute(texto + "13 off");
                }

            }
        });

        off6.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if (bandera == 1) {
                    MyATaskCliente myATaskYW = new MyATaskCliente();
                    texto = editText.getText().toString();
                    myATaskYW.execute(texto + "6 off");
                }else
                if(bandera==2){
                    MyATaskCliente myATaskYW = new MyATaskCliente();
                    texto = editText.getText().toString();
                    myATaskYW.execute(texto + "14 off");
                }

            }
        });

        off7.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if (bandera == 1) {
                    MyATaskCliente myATaskYW = new MyATaskCliente();
                    texto = editText.getText().toString();
                    myATaskYW.execute(texto + "7 off");
                }else
                if(bandera==2){
                    MyATaskCliente myATaskYW = new MyATaskCliente();
                    texto = editText.getText().toString();
                    myATaskYW.execute(texto + "15 off");
                }

            }
        });

        off8.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if (bandera == 1) {
                    MyATaskCliente myATaskYW = new MyATaskCliente();
                    texto = editText.getText().toString();
                    myATaskYW.execute(texto + "8 off");
                }else
                if(bandera==2){
                    MyATaskCliente myATaskYW = new MyATaskCliente();
                    texto = editText.getText().toString();
                    myATaskYW.execute(texto + "16 off");
                }

            }
        });
        //=======================================================================================================
    }


    /**
     * Clase para interactuar con el servidor
     * */
    class MyATaskCliente extends AsyncTask<String,Void,String>{

        /**
         * Ventana que bloqueara la pantalla del movil hasta recibir respuesta del servidor
         * */
        ProgressDialog progressDialog;

        /**
         * muestra una ventana emergente
         * */
        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
            progressDialog = new ProgressDialog(context);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.setTitle("Connecting to server");
            progressDialog.setMessage("Please wait...");
            progressDialog.show();
        }

        /**
         * Se conecta al servidor y trata resultado
         * */
        @Override
        protected String doInBackground(String... values){

            try {
                //Se conecta al servidor
                InetAddress serverAddr = InetAddress.getByName(ADDRESS);
                Log.i("I/TCP Client", "Connecting...");
                Socket socket = new Socket(serverAddr, SERVERPORT);
                Log.i("I/TCP Client", "Connected to server");

                //envia peticion de cliente
                Log.i("I/TCP Client", "Send data to server");
                PrintStream output = new PrintStream(socket.getOutputStream());
                String request = values[0];
                output.println(request);

                //recibe respuesta del servidor y formatea a String
                Log.i("I/TCP Client", "Received data to server");
                InputStream stream = socket.getInputStream();
                byte[] lenBytes = new byte[256];
                stream.read(lenBytes,0,256);
                String received = new String(lenBytes,"UTF-8").trim();
                Log.i("I/TCP Client", "Received " + received);
                Log.i("I/TCP Client", "");
                //cierra conexion
                socket.close();
                return received;
            }catch (UnknownHostException ex) {
                Log.e("E/TCP Client", "" + ex.getMessage());
                return ex.getMessage();
            } catch (IOException ex) {
                Log.e("E/TCP Client", "" + ex.getMessage());
                return ex.getMessage();
            }
        }

        /**
         * Oculta ventana emergente y muestra resultado en pantalla
         * */
        @Override
        protected void onPostExecute(String value){
            progressDialog.dismiss();
            editText2.setText(value);
        }

    }
}
