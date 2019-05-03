package com.example.datastorage.Controladores

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.TextView
import com.example.datastorage.R

class RegisterMovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_movie)
    }

    fun foto(view: View){
        val pickImageIntent = Intent(
            Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(pickImageIntent,1)
    }

    fun volver(view: View){
        val intent = Intent(this, MovieListActivity::class.java)
        startActivity(intent)
    }

    fun Register(view: View){
        val nameMovie : TextView = findViewById<TextView>(R.id.nombre)
        val durationMovie : TextView = findViewById<TextView>(R.id.duracionEdit)
    }
}
