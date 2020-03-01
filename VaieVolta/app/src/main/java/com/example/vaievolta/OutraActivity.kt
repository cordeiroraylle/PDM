package com.example.vaievolta

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText

class OutraActivity : AppCompatActivity() {
    private lateinit var  btOk: Button
    private lateinit var etMensagem: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_outra)

        Log.e("app_vai_e_volta", "Outra - onCreate")

        this.btOk = findViewById(R.id.btOutraOk)
        this.etMensagem = findViewById(R.id.etOutraMensagem)

        this.btOk.setOnClickListener(OnClickBotao())

        this.etMensagem.setText(intent.getStringExtra("MENSAGEM"))
    }

    override fun onStart() {
        super.onStart()
        Log.e("app_vai_e_volta", "Outra - onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("app_vai_e_volta", "Outra - onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("app_vai_e_volta", "Outra- onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("app_vai_e_volta", "Outra - onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("app_vai_e_volta", "Outra - onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("app_vai_e_volta", "Outra - onDestroy")
    }

    inner class OnClickBotao:View.OnClickListener{
        override fun onClick(v: View?) {
            val it = Intent()
            val msg = this@OutraActivity.etMensagem.text.toString()
            it.putExtra("MENSAGEM_VOLTA", msg)
            setResult(Activity.RESULT_OK, it)
            finish()
        }
    }
}
