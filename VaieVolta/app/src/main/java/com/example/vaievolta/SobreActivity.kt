package com.example.vaievolta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView

class SobreActivity : AppCompatActivity() {
    private lateinit var foto: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sobre)

        this.foto = findViewById(R.id.foto)
        this.foto.setOnClickListener(fotoOnClick())
    }

    inner class fotoOnClick: View.OnClickListener{
        override fun onClick(v: View?) {
            finish()
        }
    }

}
