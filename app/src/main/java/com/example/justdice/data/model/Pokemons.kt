package com.example.justdice.data.model

import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Pokemons(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: Any,
    @SerializedName("results")
    val results: List<Pokemon>
)