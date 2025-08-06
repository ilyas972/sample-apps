package com.example.muhamadilyas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    //MEMBUAT VARIABEL
    private lateinit var username:EditText
    private lateinit var password:EditText
    private lateinit var tombollogin:Button
    var usr= String()
    var pwd= String()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //Memanggil Widget
        username=findViewById(R.id.txtuser)
        password=findViewById(R.id.txtpass)
        tombollogin=findViewById(R.id.klik)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //ketika tombol di klik
        tombollogin.setOnClickListener(){
            usr = username.text.toString()
            pwd = password.text.toString()


            if (usr=="husam" && pwd=="junduloh"){
                Toast.makeText(applicationContext,"Login Berhasil", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this@MainActivity,tombollogin::class.java))
                finish()
            }
            else{
                AlertDialog.Builder(this).apply {
                    setCancelable(false)
                    setMessage("Username atau Password Salah !")
                    setPositiveButton("Keluar"){
                            _,_ ->
                        finishAndRemoveTask()
                        Toast.makeText(applicationContext,"Ulah Kapok", Toast.LENGTH_SHORT).show()
                    }
                    setNegativeButton("Ulangi"){
                            dialog,_ ->
                        dialog.cancel()
                    }
                    create()
                    show()
                }
            }
        }

    }
}
