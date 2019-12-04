package com.dam2.pruebaanko

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_suma.*

class Activity_suma : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suma)

        //para guardar los valores dados por el usuario:
        val a = intent.getIntExtra("a", 0)
        val b = intent.getIntExtra("b", 0)



        //mostrar valores enviados en la pantalla
        txt_a.text = a.toString()
        txt_b.text = b.toString()
        //valor del resultado
        val suma = a + b

        txt_sResultado.setText(suma.toString())
        //poner el resultado en un int y data intent para poder pasarlo a la activity anterior
        val data = Intent()

        data.putExtra("suma", suma)
        setResult(Activity.RESULT_OK, data)


        btn_volverS.setOnClickListener { finish() }


    }


}
