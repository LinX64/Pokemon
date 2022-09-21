package com.example.justdice.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.justdice.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showFragment()
    }

    private fun showFragment() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container_view, PokemonFragment())
            .commitNow()
    }
}

