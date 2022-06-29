package com.diegocastro.diegocastro.repository

import com.diegocastro.diegocastro.data.network.TheMovieDBClient
import com.diegocastro.diegocastro.data.persistence.dao.MovieDao
import com.diegocastro.diegocastro.data.persistence.entities.MovieEntity
import com.diegocastro.diegocastro.domain.model.Movie
import com.diegocastro.diegocastro.domain.model.toDomain
import javax.inject.Inject

class TheMovieDBRepository @Inject constructor(
    private val  apiClient: TheMovieDBClient,
    private val movieDao: MovieDao
) {
    suspend fun getPopularMoviesFromApi(): List<Movie> {
        val response  = apiClient.getPopularMovies()
        response.toString()
        return response.map { it.toDomain() }
    }

    suspend fun getPopularMoviesFromLocalDB(): List<Movie>{
        val response = movieDao.getAllMovies()
        return response.map { it.toDomain() }
    }

    suspend fun insertMovies(movies: List<MovieEntity>) {
        movieDao.insertAll(movies)
    }

    suspend fun clearMovies() {
        movieDao.deleteAllMovies()
    }
}