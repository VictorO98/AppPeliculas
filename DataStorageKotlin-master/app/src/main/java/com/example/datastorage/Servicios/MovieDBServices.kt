package com.example.datastorage.Servicios

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.datastorage.Modelos.Movie
import com.example.datastorage.Modelos.User

class MovieDBServices(context: Context) : SQLiteOpenHelper(context, "MovieDBService", null, 1), IMovieServices
{


    override fun onCreate(db: SQLiteDatabase?) {
            val sql : String = "CREATE TABLE movies(idMovie int primarykey," +
                    "nameMovie text, " +
                    "duration text, " +
                    "synopsis text, " +
                    "gender text, " +
                    "year text, " +
                    "director text, " +
                    "score integer)"
            db?.execSQL(sql)
        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int)
        {
            TODO("Sin implementación")
        }

        override fun saveMovie(movie: Movie)
        {
            var localUser = ContentValues()
            localUser.put("nombre", movie.nameMovie)//puede que falte id pelicula
            localUser.put("duracion", movie.duration)
            localUser.put("synopsis", movie.synopsis)
            localUser.put("genero", movie.gender)
            localUser.put("anio", movie.year)
            localUser.put("director", movie.director)
            localUser.put("score", movie.score)
            this.executeModification(localUser)
        }



        override fun consultMovies(): List<Movie>?
        {
            val sql : String = "SELECT idMovie, nameMovie, duration, synopsis, gender, year, director, score FROM movies"
            val result : Cursor = this.executeQuery(sql, this.writableDatabase)
            var listMovie : MutableList<Movie>? = ArrayList<Movie>()
            result.moveToFirst()

            while(!result.isAfterLast)
            {

                var movie : Movie = Movie(
                    result.getInt(0),
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getInt(5),
                    result.getString(6),
                    result.getInt(7)
                )

                listMovie?.add(movie)
                result.moveToNext()
            }

            return listMovie
        }




        private fun executeQuery(sql: String, bd : SQLiteDatabase) : Cursor
        {
            val consulta : Cursor = bd.rawQuery(sql,null)
            return consulta
        }

        private fun executeModification(movie: ContentValues)
        {
            val bd = this.writableDatabase
            bd.insert("movies", null, movie)
            bd.close()
        }
}
