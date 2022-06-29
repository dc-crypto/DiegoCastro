package com.diegocastro.diegocastro.data.network

import android.util.Log
import com.diegocastro.diegocastro.data.model.MovieModel
import javax.inject.Inject

class TheMovieDBClient @Inject constructor(private val api: TheMovieDBService) {

    suspend fun getPopularMovies(): List<MovieModel> {
        return try{
            val response = api.getPopularMovies()
            response.body()?.results ?: emptyList()
        }catch (e: TheMovieDBInterceptor.NoInternetException){
            Log.d(TheMovieDBClient::class.java.simpleName, e.message, e)
            emptyList()
        }
    }

}