package com.example.datastorage.Adapters

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.datastorage.R
import com.example.datastorage.Modelos.User

    class UsersListAdapter(private val activity: Activity, userList: List<User>?) : BaseAdapter(){
    private var user = ArrayList<User>()

    init {
        this.user = userList as ArrayList<User>
    }

    override fun getCount(): Int {
        return user.size
    }

    override fun getItem(i: Int): Any {
        return user[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    fun getName(i: Int): String? {
        return user[i].name
    }

    override fun getView(i: Int, convertView: View?, viewGroup: ViewGroup): View {
        var vi: View
        val inflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        vi = inflater.inflate(R.layout.row_item, null)
        val nombre = vi.findViewById<TextView>(R.id.Nombre)
        val director = vi.findViewById<TextView>(R.id.Edad)
        nombre.text = user[i].name
        director.text = user[i].age.toString()
        return vi
    }
}