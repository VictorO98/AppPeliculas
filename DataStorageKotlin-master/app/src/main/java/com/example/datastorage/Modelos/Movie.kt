package com.example.datastorage.Modelos

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

data class Movie(
    val idMovie: Int?,
    var nameMovie: String?,
    val duration: String?,
    var synopsis: String?,
    val gender: String?,
    val year: Int?,
    val director: String?,
    var score: Int?
)