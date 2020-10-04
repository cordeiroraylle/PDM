package com.example.rgb

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var tvR: TextView
    private lateinit var tvG: TextView
    private lateinit var tvB: TextView

    private lateinit var receiver: UnlockReceiver
    private lateinit var receiver2: UnlockReceiver2

    private lateinit var  filter: IntentFilter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvR = findViewById(R.id.tvR)
        tvG = findViewById(R.id.tvG)
        tvB = findViewById(R.id.tvB)

        receiver = UnlockReceiver()
        receiver2 = UnlockReceiver2()
        filter = IntentFilter()
        filter.addAction(Intent.ACTION_SCREEN_ON)

        when {
            intent?.action == Intent.ACTION_SEND -> {
                if ("text/plain" == intent.type) {
                    handleSendText(intent) // Handle text being sent
                }
            }
        }
    }

    private fun handleSendText(intent: Intent?) {
        val msg = intent?.getStringExtra(Intent.EXTRA_TEXT) as String
        tvR.text = msg
        tvG.text = msg
        tvB.text = msg
    }

    override fun onResume() {
        super.onResume()
        registerReceiver(receiver,filter)
        registerReceiver(receiver2,filter)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(receiver)
        unregisterReceiver(receiver2)
    }

    inner class UnlockReceiver2: BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            this@MainActivity.tvR.text = "Red"
            this@MainActivity.tvG.text = "Green"
            this@MainActivity.tvB.text = "Blue"
        }
    }
}