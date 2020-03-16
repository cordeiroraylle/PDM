package com.raylle.deuruim

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.activity_main.view.tvMainQuantidade

class MainActivity : AppCompatActivity() {

    private lateinit var btNovo: Button
    private lateinit var tvQtde: TextView

    private lateinit var cadastro: Cadastro

    val FORM = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.cadastro = Cadastro()

        this.btNovo = findViewById(R.id.btNovo)
        this.tvQtde = findViewById(R.id.tvMainQuantidade)

        this.tvQtde.text = this.cadastro.count().toString()

        this.btNovo.setOnClickListener(onClickBotao())
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK){
            if(requestCode == FORM){
                val evento = data?.getParcelableExtra<Evento>("EVENTO")
                Log.i("APP_DEURUIM", evento.toString())
                this.cadastro.add(evento!!)

                this.tvQtde.text = this.cadastro.count().toString()
                Log.i("APP_DEURUIM", this.cadastro.get().toString())
            }
        }
    }

    inner class onClickBotao: View.OnClickListener{
        override fun onClick(v: View?) {
            val intent = Intent(this@MainActivity, FormActivity::class.java)
            startActivityForResult(intent, FORM)
        }
    }
}
