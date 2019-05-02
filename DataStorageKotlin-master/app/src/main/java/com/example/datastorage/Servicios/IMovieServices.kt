package com.example.datastorage.Servicios

import com.example.datastorage.Modelos.Movie

interface IMovieServices {
        fun saveMovie(user: Movie)
        fun consultMovies() : List<Movie>?
}