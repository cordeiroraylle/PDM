package com.example.vaievolta

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var btOk: Button
    private lateinit var etMensagem: EditText
    private lateinit var btSobre: Button

    val OUTRA = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("app_vai_e_volta", "Main - onCreate")

        this.btOk = findViewById(R.id.btMainOk)
        this.etMensagem = findViewById(R.id.etMainMensagem)
        this.btSobre = findViewById(R.id.btSobre)

        this.btOk.setOnClickListener(OkClickBotao())
        this.btSobre.setOnClickListener(sobreClickBotao())
    }

    override fun onStart() {
        super.onStart()
        Log.i("app_vai_e_volta", "Main - onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("app_vai_e_volta", "Main - onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("app_vai_e_volta", "Main - onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("app_vai_e_volta", "Main - onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("app_vai_e_volta", "Main - onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("aapp_vai_e_volta", "Main - onDestroy")
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK){
            if(requestCode == OUTRA){
                val msg = data?.getStringExtra("MENSAGEM_VOLTA")
                this.etMensagem.setText(msg)
            }
        }else{
            Toast.makeText(this,"Voltou pelo Dispositivo", Toast.LENGTH_SHORT).show()
        }
    }

    inner class OkClickBotao: View.OnClickListener{
        override fun onClick(v: View?) {
            val it = Intent(this@MainActivity, OutraActivity::class.java)
            val msg = this@MainActivity.etMensagem.text.toString()

            it.putExtra("MENSAGEM", msg)

         //   startActivity(it)
            startActivityForResult(it, OUTRA)
        }
    }

    inner class sobreClickBotao: View.OnClickListener{
        override fun onClick(v: View?) {
            val it2 = Intent(this@MainActivity, SobreActivity::class.java)
            startActivity(it2)
        }
    }
}
