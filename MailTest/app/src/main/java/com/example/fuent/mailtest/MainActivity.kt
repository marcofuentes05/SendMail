package com.example.fuent.mailtest

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.LiveFolders.INTENT
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val startBtn : Button = findViewById(R.id.enviar)
        startBtn.setOnClickListener { sendMail() }
    }




    protected fun sendMail() {0
        /**Primero declaramos las variables en las que l
         guardaremos los datos del email y el Intent**/
        var destinatario : EditText = findViewById(R.id.destinatario)
        var asunto : EditText = findViewById(R.id.asunto)
        var cuerpo : EditText = findViewById(R.id.cuerpo)
        var emailIntent = Intent (Intent.ACTION_SENDTO)

        emailIntent.data = Uri.parse("mailto:")

        /**Con estas llamadas almètodod putExtra() le agregamos
         los campos necesarios al mail*/
        emailIntent.putExtra(Intent.EXTRA_EMAIL, destinatario.getText().toString())

        emailIntent.putExtra(Intent.EXTRA_SUBJECT, asunto.getText().toString());

        emailIntent.putExtra(Intent.EXTRA_TEXT, cuerpo.getText().toString());

        /** Finalmente, llamamos al Intent y, al momento de ejecutarse, nuestra app nos
         *  redireccionarà a la app de correo predeterminada **/
        try{
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email", "");
        } catch(e: Exception){
            /**Código para manejar el error**/
        }
    }
}

