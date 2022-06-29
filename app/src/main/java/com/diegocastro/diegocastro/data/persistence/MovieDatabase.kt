package com.diegocastro.diegocastro.data.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.diegocastro.diegocastro.data.persistence.dao.MovieDao
import com.diegocastro.diegocastro.data.persistence.entities.MovieEntity

@Database(entities = [MovieEntity::class], version = 1)
abstract class MovieDatabase: RoomDatabase() {

    abstract fun getMovieDao(): MovieDao

}