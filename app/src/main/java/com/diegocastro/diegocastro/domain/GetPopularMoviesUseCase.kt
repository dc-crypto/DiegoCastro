package com.diegocastro.diegocastro.domain

import com.diegocastro.diegocastro.data.persistence.entities.toLocalDB
import com.diegocastro.diegocastro.domain.model.Movie
import com.diegocastro.diegocastro.repository.TheMovieDBRepository
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(private val repository: TheMovieDBRepository){

    suspend operator fun invoke(): List<Movie>{
        val movies = repository.getPopularMoviesFromApi()

        return if(movies.isNotEmpty()){
            repository.clearMovies()
            repository.insertMovies(movies.map { it.toLocalDB() })
            movies
        }else{
            return repository.getPopularMoviesFromLocalDB()
        }
    }

}