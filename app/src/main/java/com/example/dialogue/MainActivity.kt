package com.example.dialogue

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDial = findViewById<Button>(R.id.btnDial)
        val dialogueBinding = layoutInflater.inflate(R.layout.alert_dialouge,null)
        val myDial = Dialog(this)
        myDial.setContentView(dialogueBinding)

        btnDial.setOnClickListener{


            myDial.setCancelable(true)
            myDial.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            myDial.show()

            val btnOkay = dialogueBinding.findViewById<Button>(R.id.btnOkay)
            val btnCancel = dialogueBinding.findViewById<Button>(R.id.btnCancel)

            btnCancel.setOnClickListener{
                myDial.dismiss()
            }

            btnOkay.setOnClickListener{
              val i = Intent(this@MainActivity, NewActivity::class.java)
                startActivity(i)
            }


        }
    }
    private var doubleBackToExitPressedOnce = false
    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }

        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show()

        Handler(Looper.getMainLooper()).postDelayed(Runnable { doubleBackToExitPressedOnce = false }, 2000)
    }
}

