package com.raylle.deuruim

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.SeekBar

class FormActivity : AppCompatActivity() {
    private lateinit var etDescricao: EditText
    private lateinit var sbNota: SeekBar
    private lateinit var btSalvar: Button
    private lateinit var btCancelar: Button
    private lateinit var btFoto: Button
    private lateinit var IvFoto: ImageView
    private lateinit var imagem : Bitmap

    var FOTO = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        this.etDescricao = findViewById(R.id.etFormDescricao)
        this.sbNota = findViewById(R.id.sbFormNota)
        this.IvFoto = findViewById(R.id.IvFormFoto)

        this.btSalvar = findViewById(R.id.btFormSalvar)
        this.btCancelar = findViewById(R.id.btFormCancelar)
        this.btFoto = findViewById(R.id.btFoto)

        this.btSalvar.setOnClickListener({salvar()})
        this.btCancelar.setOnClickListener({
            finish()
        })
        this.btFoto.setOnClickListener({foto()})
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK){
            if(requestCode == FOTO){
                imagem = data?.extras?.get("data") as Bitmap
                this.IvFoto.setImageBitmap(imagem)
            }
        }
    }

    fun salvar(){
        val descricao = this.etDescricao.text.toString()
        val nota = this.sbNota.progress
        val foto = Bitmap.createBitmap(200,200,Bitmap.Config.ARGB_8888)

        val evento = Evento(descricao, nota, foto)

        val intent = Intent()
        intent.putExtra("EVENTO", evento)
        setResult(Activity.RESULT_OK,intent)

        finish()
    }

    fun foto(){
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, FOTO)
    }
}
