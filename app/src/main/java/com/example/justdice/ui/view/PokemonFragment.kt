package com.example.justdice.ui.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.justdice.R
import com.example.justdice.data.model.Pokemon
import com.example.justdice.databinding.FragmentPokemonsBinding
import com.example.justdice.ui.adapter.PokemonsAdapter
import com.example.justdice.ui.viewmodel.MainViewModel
import com.example.justdice.util.NetworkResult
import com.example.justdice.util.inVisible
import com.example.justdice.util.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonFragment : Fragment(R.layout.fragment_pokemons) {

    private lateinit var binding: FragmentPokemonsBinding
    private val mainViewModel by activityViewModels<MainViewModel>()
    private val pokemonAdapter by lazy { PokemonsAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPokemonsBinding.bind(view)
        binding.lifecycleOwner = viewLifecycleOwner

        setupUI()
        setupObserver()
    }

    private fun setupUI() {
        binding.pokemonsRecyclerView.adapter = pokemonAdapter
    }

    private fun setupObserver() {
        mainViewModel.pokemonResponse.observe(viewLifecycleOwner) {
            when (it) {
                is NetworkResult.Success -> {
                    binding.progressBar.inVisible()
                    setPokemonAdapter(it.data)
                }
                is NetworkResult.Error -> {
                    Toast.makeText(requireContext(), it.error, Toast.LENGTH_SHORT).show()
                    binding.progressBar.inVisible()
                }
                is NetworkResult.Loading -> binding.progressBar.visible()
            }
        }
    }

    private fun setPokemonAdapter(pokemons: List<Pokemon>) {
        pokemonAdapter.setData(pokemons)
        pokemonAdapter.notifyDataSetChanged()
    }
}