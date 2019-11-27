package com.dam2.pruebaanko

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.jetbrains.anko.Android
import org.jetbrains.anko.browse
import org.jetbrains.anko.toast
import java.net.URL

const val SUMA_REQUEST = 1
const val MY_PERMISSIONS_REQUEST_READ_CONTACTS =1
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        /*
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
*/
        //boton que llame a la camara del movil para lo cual hacen falta permisos
        btn_camara.setOnClickListener {
            comprobarPermisosCamara()
        }
        //pulsar un boton y que se cambie el texto
        bt_saludo.setOnClickListener {
            bt_saludo.setText("Hola")
            //para acceder a las variables xml
            toast("es la toast")
        }
        bt_amarillo.setOnClickListener { cambiarDetalle(it) }
        bt_rojo.setOnClickListener { cambiarDetalle(it) }

        btn_buscar.setOnClickListener {
            browse("http://" + (txt_Url.getText().toString()))

        }

        btn_sumar.setOnClickListener { sumarNumeros(it) }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        //super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == SUMA_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                if (data != null) {
                    txt_ResultF.setText(data.getIntExtra("suma", 0).toString())
                }
            }

        }
    }

    private fun sumarNumeros(it: View?) {

        val miIntent = Intent(this, Activity_suma::class.java)
        miIntent.putExtra("a", txt_suma.text)
        val putExtra = miIntent.putExtra("b", txt_sumb.text)

       // startActivityForResult(miIntent)

    }

    fun cambiarDetalle(v: View) {
        val botonAux = v as Button
        val miIntent = Intent(this, ActivityDetalle::class.java)

        if (botonAux == bt_amarillo) {
            miIntent.putExtra("color", "amarillo")
            startActivity(miIntent)
        } else if (botonAux == bt_rojo) {
            miIntent.putExtra("color", "rojo")
            startActivity(miIntent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun  comprobarPermisosCamara(){

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
            toast("No tiene permiso para usar la camara")
        }else{
            toast("Tienes permiso de usar la camara")

        }

    }
    private fun solicitarPermisosCamara(){

        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.CAMERA)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                    arrayOf(android.Manifest.permission.CAMERA),
                    MY_PERMISSIONS_REQUEST_READ_CONTACTS)

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            // Permission has already been granted
        }

    }


}
