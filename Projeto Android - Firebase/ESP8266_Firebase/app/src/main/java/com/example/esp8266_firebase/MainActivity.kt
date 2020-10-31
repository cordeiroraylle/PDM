package com.example.esp8266_firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.util.Log
import android.view.View
import android.widget.*
import com.google.firebase.database.*
//import com.google.firebase.database.ktx.getValue
import java.lang.StringBuilder
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var ivImagem: ImageView
    private lateinit var btRegar: Button
    private lateinit var btParar: Button
    private lateinit var tvStatus: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

          this.ivImagem = findViewById(R.id.ivImagem)
          this.btRegar = findViewById(R.id.btRegar)
          this.btParar = findViewById(R.id.btParar)
          this.tvStatus = findViewById(R.id.tvStatus)

        var database = FirebaseDatabase.getInstance().reference

        btRegar.setOnClickListener(){
            database.child("bomba").setValue("on")
            Toast.makeText(this,"Rega Iniciada",Toast.LENGTH_SHORT).show()
        }

        btParar.setOnClickListener(){
            database.child("bomba").setValue("off")
            Toast.makeText(this,"Rega Finalizada",Toast.LENGTH_SHORT).show()
        }

        var getdata = object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
            }

            override fun onDataChange(p0: DataSnapshot) {
                var map = p0.value as Map<String, Any>

                var dados = Dados( map["leitura"].toString().toInt(),  map["status"].toString())

                tvStatus.text = "A umidade lida foi de ${dados.leitura} \n A sua plantinha está com o solo ${dados.status}"

                setImage(dados.status)

            }
        }
        database.addValueEventListener(getdata)
        database.addListenerForSingleValueEvent(getdata)
    }

    fun setImage( status : String){
        val img = ivImagem
        when(status){
            "seco" -> img.setImageResource(R.drawable.ic_img1)
            "moderado" -> img.setImageResource(R.drawable.ic_img2)
            "encharcado" -> img.setImageResource(R.drawable.ic_img3)
            else -> img.setImageResource(R.drawable.ic_img4)
        }
    }
}