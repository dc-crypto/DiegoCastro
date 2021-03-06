package com.diegocastro.diegocastro.ui.movies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diegocastro.diegocastro.domain.GetPopularMoviesUseCase
import com.diegocastro.diegocastro.domain.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase
) : ViewModel() {


    val isLoading = MutableLiveData<Boolean>()
    val popularMovies = MutableLiveData<List<Movie>>()

    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getPopularMoviesUseCase()
            if(!result.isNullOrEmpty()){
                popularMovies.postValue(result)
                isLoading.postValue(false)
            }
        }
    }




}