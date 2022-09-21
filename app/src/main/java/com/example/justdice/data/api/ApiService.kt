package com.example.justdice.data.api

import com.example.justdice.data.model.Pokemons
import retrofit2.http.GET

interface ApiService {

    @GET("api/v2/pokemon/")
    suspend fun getPokemons(): Pokemons
}