package com.example.datastorage.Controladores

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.datastorage.Modelos.User
import com.example.datastorage.R
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.activity_profile.view.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.view.*
import java.net.URI
import java.net.URL

class ProfileActivity : AppCompatActivity() {

    companion object{
        const val USER_NAME_SHOW = "user_name_show"
        const val USER_EMAIL_SHOW = "user_email_show"
        const val USER_AGE_SHOW = "user_age_show"

        const val USER_IMAGE_SHOW = "user_image_show"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val textName = findViewById<TextView>(R.id.nameProfile)
        val textAge = findViewById<TextView>(R.id.ageProfile)
        val textEmail = findViewById<TextView>(R.id.emailProfile)

        val name = intent.getStringExtra(USER_NAME_SHOW)
        val age = intent.getIntExtra(USER_AGE_SHOW, 0)
        val email = intent.getStringExtra(USER_EMAIL_SHOW)

        val image = intent.getStringExtra(USER_IMAGE_SHOW)

        textName.text = name
        textAge.text = age.toString()
        textEmail.text = email

        //val imagenS = intent.getStringExtra("URI_IMA")



        //val imagen = Uri.parse(image)
        //imageProfile.setImageURI(imagen)



    }

    fun volverButton(view : View){
        val intent = Intent(this, UsersListActivity::class.java)
        startActivity(intent)
        finish()
    }
}