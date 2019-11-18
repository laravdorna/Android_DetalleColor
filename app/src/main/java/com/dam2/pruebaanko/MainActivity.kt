package com.dam2.pruebaanko

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.jetbrains.anko.toast

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
        //pulsar un boton y que se cambie el texto
        bt_saludo.setOnClickListener{
            bt_saludo.setText("Hola")
            //para acceder a las variables xml
            toast("es la toast")
        }
        bt_amarillo.setOnClickListener{cambiarDetalle(it)}
        bt_rojo.setOnClickListener{cambiarDetalle (it)}

    }

    fun cambiarDetalle(v:View){
        val botonAux = v as Button
        val miIntent = Intent (this, ActivityDetalle::class.java)

        if(botonAux == bt_amarillo){
            miIntent.putExtra("color", "amarillo")
            startActivity(miIntent)
        }else if (botonAux==bt_rojo){
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
}