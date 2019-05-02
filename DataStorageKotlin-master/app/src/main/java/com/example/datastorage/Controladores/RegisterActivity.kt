package com.example.datastorage.Controladores

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.datastorage.Modelos.User
import com.example.datastorage.R
import com.example.datastorage.Servicios.UserDBServices
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    var fileUri: Uri? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    fun profile(view: View)
    {
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
    }

    fun acceder(view: View)
    {
        val email = findViewById<TextView>(R.id.email);
        val password = findViewById<TextView>(R.id.password);
    }

    fun Register(view: View){
        val nombrenuevo = findViewById<TextView>(R.id.nombre)
        val emailnuevo = findViewById<TextView>(R.id.correo)
        val agenueva= findViewById<TextView>(R.id.edad).toString()
        val passwordnueva= findViewById<TextView>(R.id.contraseña)

        //Aqui vamos a guardar los datos.

        //val user = User(null, "jei", "jei@gmail.com", 35, "secret",null)
        //UserDBServices(this).saveUser(user) //Código Test

        val imagen= fileUri.toString()

        val usernuevon = User(null, nombrenuevo.text.toString(), emailnuevo.text.toString(), 35, passwordnueva.text.toString(),imagen)
        UserDBServices(this).saveUser(usernuevon) //Código Test

        Toast.makeText(this, "Usuario Registrado",  Toast.LENGTH_SHORT).show()

    }




    fun volver(view: View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun foto(view: View){
        val pickImageIntent = Intent(Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(pickImageIntent,1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int,
                                  data: Intent?) {

        //Esto se puede colocar en el boton registro para que guarde la foto tambien
        if(resultCode == Activity.RESULT_OK){
            //photo from gallery
            fileUri = data?.data


            //guardo en la base de datos
            imageView.setImageURI(fileUri)

            //se guarda como .string y luego se manda a la base de datos
            //pero se debe crear una columna en la base de datos para poder mandarla y logico traerlo


            //val imagens= fileUri.toString()

            //intent.putExtra("URI_IMA",imagens)



        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}
