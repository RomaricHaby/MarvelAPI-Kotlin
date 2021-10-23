package com.marvel.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.marvel.R
import com.marvel.manager.ResourcesManager
import com.marvel.ui.fragment.character.CharacterFragment
import com.marvel.ui.fragment.comics.ComicsFragment
import com.marvel.ui.fragment.favoris.FavorisFragment
import com.marvel.usecase.comics.GetComicsUseCase
import com.marvel.usecase.creators.GetAllCreatorsUseCase
import com.marvel.usecase.events.GetAllEventsUseCase
import com.marvel.usecase.series.GetAllSeriesUseCase
import com.marvel.usecase.stories.GetAllStories
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity(), CoroutineScope by MainScope() {
    private lateinit var navigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        unitUI()

        ResourcesManager.loadKeyAPI()

        loadFragment(CharacterFragment())

        /*launch(Dispatchers.Main) {
              try {
                  val response = GetAllStories().execute().getOrThrow()
                  Toast.makeText(this@MainActivity, response?.data?.results?.get(1)?.type, Toast.LENGTH_LONG).show()
              } catch (e: Exception) {
                  Toast.makeText(this@MainActivity, "Error Occurred: ${e.message}", Toast.LENGTH_LONG).show()
              }
          }*/
    }

    private fun unitUI() {
        navigation = findViewById(R.id.bottom_nav_bar)
        initBottomNavBar()
    }

    private fun initBottomNavBar() {
        navigation.itemIconTintList = null
        navigation.selectedItemId = R.id.action_character

        navigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.action_comics -> loadFragment(ComicsFragment())

                R.id.action_character -> loadFragment(CharacterFragment())

                R.id.action_fav -> loadFragment(FavorisFragment())

            }
            return@setOnItemSelectedListener true
        }
    }

    private fun loadFragment(fragment: Fragment?) {
        if (fragment != null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainerView, fragment)
                .addToBackStack(null)
                .commit()
        }
    }


}