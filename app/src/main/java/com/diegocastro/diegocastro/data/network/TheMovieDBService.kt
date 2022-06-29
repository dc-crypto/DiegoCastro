package com.diegocastro.diegocastro.data.network

import com.diegocastro.diegocastro.data.model.PopularMoviesResponse
import retrofit2.Response
import retrofit2.http.GET

interface TheMovieDBService {
    @GET("movie/popular")
    suspend fun getPopularMovies(): Response<PopularMoviesResponse>

}