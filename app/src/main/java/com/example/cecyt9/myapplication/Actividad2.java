package com.example.cecyt9.myapplication;

/**
 * Created by CECyT9 on 02/06/2017.
 */


import android.Manifest;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Actividad2 extends Activity {

    String nombre = "", fecha = "", hora = "", apellido = "", edad = "", eMail = "", tarjetaCredito = "", codigo = "";
    int personas = 0;
    TextView muestraDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);

        muestraDatos = (TextView) findViewById(R.id.muestraDatos);

        Bundle recibe = new Bundle();
        recibe = this.getIntent().getExtras();

        nombre = recibe.getString("nombre");
        personas = recibe.getInt("personas");
        fecha = recibe.getString("fecha");
        hora = recibe.getString("hora");
        apellido = recibe.getString("apellido");
        edad = recibe.getString("edad");
        eMail = recibe.getString("eMail");
        tarjetaCredito = recibe.getString("tarjetaCredito");
        codigo = recibe.getString("codigo");

        muestraDatos.setText("RESERVACIÓN A:\n" +
                "Nombre completo:" + nombre + " " + apellido + "\n" +
                "Edad: " + edad + " años \n" +
                "Email:" + eMail + "\n" +
                "Tarjeta Credito: " + tarjetaCredito + " " + codigo + "\n" +
                "Personas: " + personas + "\n" +
                "Fecha: " + fecha + "\n" +
                "Hora: " + hora + "\n");
    }

    public void hacerOtraReserva(View v) {
        Intent envia = new Intent(this, MainActivity.class);
        finish();
        startActivity(envia);
    }

    public void pagWeb(View pag) {
        Intent pagina = new Intent(Intent.ACTION_VIEW, Uri.parse("http://nonsolo.mx/"));
        startActivity(pagina);
    }

    public void mapa(View mapa) {
        Intent maps = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:19.4328203,-99.1390092"));
        startActivity(maps);
    }

    public void llamar(View llamada) {
        Intent intento = new Intent(Intent.ACTION_CALL, Uri.parse("tel:5555120619 "));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(intento);
    }

    public void mail (View email)
    {
        Intent intento = new Intent(Intent.ACTION_SEND);
        intento.setType("text/plain");
        intento.putExtra(Intent.EXTRA_SUBJECT, "Reservación");
        intento.putExtra(Intent.EXTRA_TEXT, "Reservación de "+nombre+" "+apellido+".\n Para el día " + fecha + " a las "+hora+" hrs.");
        intento.putExtra(Intent.EXTRA_EMAIL, new String[] {"atencionacliente_noreplay@nonsolo.com.mx"});
        startActivity(intento);
    }

    public void foto (View photo)
    {
        Intent intento = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(intento);
    }

}
