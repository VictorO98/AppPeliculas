package com.example.datastorage.Controladores

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.Toast
import com.example.datastorage.Adapters.MovieListAdapter
import com.example.datastorage.Modelos.Movie
import com.example.datastorage.R
import com.example.datastorage.Servicios.MovieDBServices

class MovieListActivity : AppCompatActivity() {

    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)

        val listPosts: List<Movie>? = MovieDBServices(this).consultMovies()
        listView = findViewById<ListView>(R.id.listMovie) as ListView
        val adapter = MovieListAdapter(this, listPosts)
        listView.adapter = adapter

        listView.setClickable(true)
        listView.setOnItemClickListener{ adapterView, view, i, l ->
            Toast.makeText(this, "Item Clicked " + adapter.getName(i), Toast.LENGTH_SHORT).show()
        }
    }

    fun movies(view: View){
        val intent = Intent(this, RegisterMovieActivity::class.java)
        startActivity(intent)
    }
}
