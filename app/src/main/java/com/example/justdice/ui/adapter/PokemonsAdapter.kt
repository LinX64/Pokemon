package com.example.justdice.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.justdice.data.model.Pokemon
import com.example.justdice.data.model.Pokemons
import com.example.justdice.databinding.PokemonsListItemBinding

class PokemonsAdapter : RecyclerView.Adapter<PokemonsAdapter.MyViewHolder>() {
    private var pokemons = ArrayList<Pokemon>()

    inner class MyViewHolder(
        private val binding: PokemonsListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(pokemons: Pokemon) {
            binding.pokemon = pokemons
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemBinding =
            PokemonsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(itemBinding)
    }

    override fun getItemCount(): Int = pokemons.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) =
        holder.bind(pokemons[position])

    fun setData(list: List<Pokemon>) {
        pokemons.clear()
        pokemons.addAll(list)
    }
}