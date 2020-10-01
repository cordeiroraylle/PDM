package com.example.minhascorespreferidas

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var lvCores: ListView
    private lateinit var btAdd: FloatingActionButton
    private lateinit var lista : ArrayList<Cor>
    private var CADASTRO = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btAdd = findViewById(R.id.btAdd)
        lvCores = findViewById(R.id.LvCores)
        lista = ArrayList()

        btAdd.setOnClickListener{
            add()
        }
        lvCores.setOnItemLongClickListener(clickLongo())

        lvCores.adapter = CorAdapter(this,lista)

    }

    fun add(){
        val intent = Intent(this@MainActivity,CadastroActivity::class.java)
        startActivityForResult(intent,CADASTRO)
    }

    fun atualiza(){
        (this.lvCores.adapter as BaseAdapter).notifyDataSetChanged()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==CADASTRO){
            if (resultCode== Activity.RESULT_OK){
                val cor = data?.getSerializableExtra("COR") as Cor
                lista.add(cor)
                atualiza()
            }
        }
    }

    inner class clickLongo:AdapterView.OnItemLongClickListener{
        override fun onItemLongClick(
            parent: AdapterView<*>?,
            view: View?,
            position: Int,
            id: Long
        ): Boolean {
            lista.removeAt(position)
            atualiza()
            return true
        }

    }


}