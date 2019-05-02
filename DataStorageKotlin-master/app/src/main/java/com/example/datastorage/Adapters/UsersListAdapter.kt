package com.example.datastorage.Adapters

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.datastorage.R
import com.example.datastorage.Modelos.Movie

class UsersListAdapter(private val activity: Activity, movieList: List<Movie>?) : BaseAdapter(){
    private var movieList = ArrayList<Movie>()

    init {
        this.movieList = movieList as ArrayList<Movie>
    }

    override fun getCount(): Int {
        return movieList.size
    }

    override fun getItem(i: Int): Any {
        return movieList[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    fun getName(i: Int): String? {
        return movieList[i].nameMovie
    }

    override fun getView(i: Int, convertView: View?, viewGroup: ViewGroup): View {
        var vi: View
        val inflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        vi = inflater.inflate(R.layout.row_item, null)
        val nombre = vi.findViewById<TextView>(R.id.Nombre)
        val director = vi.findViewById<TextView>(R.id.Edad)
        nombre.text = movieList[i].nameMovie
        director.text = movieList[i].director.toString()
        return vi
    }
}