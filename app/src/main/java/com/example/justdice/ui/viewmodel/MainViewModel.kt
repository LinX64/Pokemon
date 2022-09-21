package com.example.justdice.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.justdice.data.model.Pokemon
import com.example.justdice.data.repository.MainRepository
import com.example.justdice.di.IoDispatcher
import com.example.justdice.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRep: MainRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    init {
        getPokemons()
    }

    private var _pokemonResponse =
        MutableLiveData<NetworkResult<List<Pokemon>>>()
    val pokemonResponse: LiveData<NetworkResult<List<Pokemon>>> =
        _pokemonResponse

    private fun getPokemons() = viewModelScope.launch(ioDispatcher) {
        val pokemons = mainRep.getPokemons()
        pokemons.collect { _pokemonResponse.postValue(it) }
    }
}
