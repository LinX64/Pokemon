package com.example.justdice.data.repository

import com.example.justdice.data.api.ApiService
import com.example.justdice.util.NetworkResult
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getPokemons() = flow {
        emit(NetworkResult.Loading(true))

        val response = apiService.getPokemons().results
        emit(NetworkResult.Success(response))
    }.catch { e -> emit(NetworkResult.Error(e.message.toString())) }
}