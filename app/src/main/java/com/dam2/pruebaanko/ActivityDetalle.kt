package com.dam2.pruebaanko

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detalle.*
import kotlinx.android.synthetic.main.content_main.*

class ActivityDetalle : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        val valor = intent.getStringExtra("color")
        txt_color.setText(valor)

        //CAMBIA EL COLOR DEL TEXTO
        if (valor == "amarillo"){
            txt_color.setTextColor(Color.YELLOW)
        } else if (valor == "rojo"){

            txt_color.setTextColor(Color.RED)
        }


    }
}
