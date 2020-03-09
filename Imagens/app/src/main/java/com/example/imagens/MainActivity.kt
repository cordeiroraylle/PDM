package com.example.imagens

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.provider.MediaStore
import android.util.Log
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.core.view.get
import kotlinx.android.synthetic.main.dialog_options.*
import java.net.URL

class MainActivity : AppCompatActivity() {
    private var CAMERA = 1
    private lateinit var btCamera: Button
    private lateinit var btARQUIVO: Button
    private lateinit var btDownload: Button
    private lateinit var ivImage: ImageView
    private lateinit var rgOptions: RadioGroup


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btCamera = findViewById(R.id.btCamera)
        this.btARQUIVO = findViewById(R.id.btARQUIVO)
        this.btDownload = findViewById(R.id.btDownload)

        this.ivImage = findViewById(R.id.ivImage)

        this.btCamera.setOnClickListener({ camera() })
        this.btARQUIVO.setOnClickListener({ arquivo() })
        this.btDownload.setOnClickListener({ showOptions() })

    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun showOptions() {
        val janela = AlertDialog.Builder(this)
        janela.setTitle("Escolha uma das opcoes abaixo:")
        janela.setView(R.layout.dialog_options)
        janela.setNegativeButton("Cancelar", null)
        janela.setNeutralButton("ok", DialogInterface.OnClickListener { dialog, which ->

            this.rgOptions = findViewById(R.id.rgEscolhas)
            val item = rgOptions.checkedRadioButtonId
            if (item==null){
                Toast.makeText(this,"is null", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "not null", Toast.LENGTH_SHORT).show()
            }

        })


        janela.create().show()
    }

//    inner class ChangeRadioGroup: RadioGroup.OnCheckedChangeListener{
//        override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
////            val op = checkedId.toString()
//
////            when (op){
////                1 -> Toast.makeText(this, op, Toast.LENGTH_SHORT).show()
////                2 -> Toast.makeText(this, op, Toast.LENGTH_SHORT).show()
////            }
//            val build = AlertDialog.Builder(this)
//            build.setMessage("Escolha: ")
//            build.setSingleChoiceItems(bt01)
//            build.setSingleChoiceItems(R.id.bt2)
//
//            build.setPositiveButton("Ok", null)
//            build.create().show()
//        }
//    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == CAMERA) {
                val imagem = data?.extras?.get("data") as Bitmap
                this.ivImage.setImageBitmap(imagem)
            }
        }
    }


    fun camera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, CAMERA)
    }

    fun arquivo() {
        this.ivImage.setImageResource(R.drawable.super_mario)
    }

    fun downloadDaImagem(url: String): Bitmap {  // faz o download com base em uma url
        URL(url).openStream().use {
            val imagem = BitmapFactory.decodeStream(it)
            return imagem
        }
    }

    fun download() {
        val handler = Handler()
        val url = "http://www.valeria.eti.br/sm/sm_xxxhdpi.png"
        Thread {
            val imagem = this.downloadDaImagem(url)
            handler.post {
                this.ivImage.setImageBitmap(imagem)
            }
        }.start()
    }
}
