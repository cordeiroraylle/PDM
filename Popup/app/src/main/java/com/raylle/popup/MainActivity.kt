package com.raylle.popup

import android.content.DialogInterface
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var btMensagem: Button
    private lateinit var btInput: Button
    private lateinit var btData: Button
    private lateinit var btHora: Button
    private lateinit var btValores: Button
    private lateinit var btEscolha: Button
    private lateinit var btUnico: Button
    private lateinit var btVarios: Button
    private lateinit var view: View


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btMensagem = findViewById(R.id.btMensagem)
        this.btInput = findViewById(R.id.btInput)
        this.btData = findViewById(R.id.btData)
        this.btHora = findViewById(R.id.btHora)
        this.btValores = findViewById(R.id.btValores)
        this.btEscolha = findViewById(R.id.btEscolha)
        this.btUnico = findViewById(R.id.btUnico)
        this.btVarios = findViewById(R.id.btVarios)

        this.btMensagem.setOnClickListener({ mensagem() })
        this.btInput.setOnClickListener({ input() })
        this.btData.setOnClickListener({ data() })
        this.btHora.setOnClickListener({ hora() })
        this.btValores.setOnClickListener({ valores() })
        this.btEscolha.setOnClickListener({ escolha() })
        this.btUnico.setOnClickListener({ unico() })
        this.btVarios.setOnClickListener({ varios() })


    }

    fun mensagem() {
        val janela = AlertDialog.Builder(this)
        janela.setTitle("Mensagem")
        janela.setIcon(R.mipmap.ic_launcher)
        janela.setMessage("Que bom!")

        janela.setPositiveButton("Ok") { dialog, wich ->
            Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show()
        }

        janela.setNegativeButton("Cancelar") { dialog, wich ->
            Toast.makeText(this, "Cancelar", Toast.LENGTH_SHORT).show()
        }

        janela.setNeutralButton("Generico") { dialog, wich ->
            Toast.makeText(this, "Generico", Toast.LENGTH_SHORT).show()
        }
        janela.create().show()
    }

    fun input() {
        val janela = AlertDialog.Builder(this)
        this.view = EditText(this)

        janela.setTitle("Input")
        janela.setIcon(R.mipmap.ic_launcher)
        janela.setMessage("Digite uma frase: ")
        janela.setView(this.view)

        janela.setPositiveButton("Ok") { dialog, wich ->
            val msg = (this.view as EditText).text.toString()
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }

        janela.setNegativeButton("Cancelar") { dialog, wich ->
            Toast.makeText(this, "Cancelar", Toast.LENGTH_SHORT).show()
        }
        janela.create().show()
    }

    fun data() {
        val janela = AlertDialog.Builder(this)
        this.view = DatePicker(this)

        janela.setTitle("Data")
        janela.setIcon(R.mipmap.ic_launcher)
        janela.setMessage("Escolha uma data ")
        janela.setView(this.view)

        janela.setPositiveButton("Ok") { dialog, wich ->
            val dp = this.view as DatePicker
            val msg = "${dp.dayOfMonth}/${dp.month + 1}/${dp.year}"
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }

        janela.setNegativeButton("Cancelar") { dialog, wich ->
            Toast.makeText(this, "Cancelar", Toast.LENGTH_SHORT).show()
        }
        janela.create().show()
    }

    fun hora() {
        val janela = AlertDialog.Builder(this)
        this.view = TimePicker(this)

        janela.setTitle("Hora")
        janela.setIcon(R.mipmap.ic_launcher)
        janela.setMessage("Escolha uma hora")
        janela.setView(this.view)

        janela.setPositiveButton("Ok") { dialog, wich ->
            val tp = this.view as TimePicker
            var msg = ""

            if (Build.VERSION.SDK_INT < 23) {
                msg = "${tp.currentHour}:${tp.currentMinute}"
            } else {
                msg = "${tp.hour}:${tp.minute}"
            }

            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }

        janela.setNegativeButton("Cancelar") { dialog, wich ->
            Toast.makeText(this, "Cancelar", Toast.LENGTH_SHORT).show()
        }
        janela.create().show()
    }

    fun valores() {
        val janela = AlertDialog.Builder(this)
        this.view = SeekBar(this)

        janela.setTitle("Faixa de Valores")
        janela.setIcon(R.mipmap.ic_launcher)
        janela.setMessage("Escolha um valor ")
        janela.setView(this.view)

        janela.setPositiveButton("Ok") { dialog, wich ->
            val sb = this.view as SeekBar
            var msg = "${sb.progress}"

            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }

        janela.setNegativeButton("Cancelar") { dialog, wich ->
            Toast.makeText(this, "Cancelar", Toast.LENGTH_SHORT).show()
        }
        janela.create().show()
    }

    fun escolha() {
        val janela = AlertDialog.Builder(this)
        this.view = Switch(this)

        janela.setTitle("Escolha")
        janela.setIcon(R.mipmap.ic_launcher)
        janela.setMessage("On / Off")
        janela.setView(this.view)

        janela.setPositiveButton("Ok") { dialog, wich ->
            val sb = this.view as Switch
            var msg = "${sb.isChecked}"

            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }
        janela.setNegativeButton("Cancelar") { dialog, wich ->
            Toast.makeText(this, "Cancelar", Toast.LENGTH_SHORT).show()
        }
        janela.create().show()
    }

    fun unico() {
        val janela = AlertDialog.Builder(this)
        this.view = RadioGroup(this)

        val rb = RadioButton(this)
        rb.text = "Opção 1"
        rb.id = 1.toInt()

        val rb2 = RadioButton(this)
        rb2.text = "Opção 2"
        rb2.id = 2.toInt()

        val rb3 = RadioButton(this)
        rb3.text = "Opção 3"
        rb3.id = 3.toInt()

        (this.view as RadioGroup).addView(rb)
        (this.view as RadioGroup).addView(rb2)
        (this.view as RadioGroup).addView(rb3)

        janela.setTitle("Escolha uma opção:")
        janela.setIcon(R.mipmap.ic_launcher)
        janela.setView(this.view)

        janela.setPositiveButton("Ok") { dialog, wich ->
            val rg = this.view as RadioGroup
            val rb = rg.findViewById<RadioButton>(rg.checkedRadioButtonId)?.text.toString()
            var msg = if (rb == "null") {
                "Nenhuma opção selecionada"
            } else {
                rb
            }
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }
        janela.setNegativeButton("Cancelar") { dialog, wich ->
            Toast.makeText(this, "Cancelar", Toast.LENGTH_SHORT).show()
        }
        janela.create().show()
    }

    fun varios() {
        val janela = AlertDialog.Builder(this)
        this.view = LinearLayout(this)

        val cb = CheckBox(this)
        cb.text = "Opção 1"

        val cb2 = CheckBox(this)
        cb2.text = "Opção 2"

        val cb3 = CheckBox(this)
        cb3.text = "Opção 3"

        val cb4 = CheckBox(this)
        cb4.text = "Opção 4"

        (this.view as LinearLayout).addView(cb)
        (this.view as LinearLayout).addView(cb2)
        (this.view as LinearLayout).addView(cb3)
        (this.view as LinearLayout).addView(cb4)

        janela.setTitle("Escolha uma ou mais opções")
        janela.setIcon(R.mipmap.ic_launcher)
        janela.setView(this.view)

        janela.setPositiveButton("Ok") { dialog, wich ->

            val layout = this.view as LinearLayout
            var msg = ""

            val cb = layout.getChildAt(0)
            if ((cb as CheckBox).isChecked) {
                msg += "${cb.text} "
            }

            val cb2 = layout.getChildAt(1)
            if ((cb2 as CheckBox).isChecked) {
                msg += "${cb2.text} "
            }

            val cb3 = layout.getChildAt(2)
            if ((cb3 as CheckBox).isChecked) {
                msg += "${cb3.text} "
            }

            val cb4 = layout.getChildAt(3)
            if ((cb4 as CheckBox).isChecked) {
                msg += "${cb4.text}"
            }


            if(msg != ""){
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
            }else{
                msg="Nenhuma opção selecionada"
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
            }

        }
        janela.setNegativeButton("Cancelar") { dialog, wich ->
            Toast.makeText(this, "Cancelar", Toast.LENGTH_SHORT).show()
        }
        janela.create().show()
    }
}
