package com.example.datastorage.Adapters

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.datastorage.Modelos.Movie
import com.example.datastorage.R

class MovieListAdapter(private val activity: Activity, movieList: List<Movie>?) : BaseAdapter() {

    private var movie = ArrayList<Movie>()

    init {
        this.movie = movieList as ArrayList<Movie>
    }

    override fun getCount(): Int {
        return movie.size
    }

    override fun getItem(position: Int): Any {
        return movie[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    fun getName(i: Int) : String?{
        return movie[i].nameMovie
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var vi: View
        val inflater : LayoutInflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        vi = inflater.inflate(R.layout.row_item_movie, null)
        val nameMovie : TextView = vi.findViewById<TextView>(R.id.NombrePelicula)
        val director : TextView = vi.findViewById<TextView>(R.id.Director)
        nameMovie.text = movie[position].nameMovie
        director.text = movie[position].director
        return vi
    }


}