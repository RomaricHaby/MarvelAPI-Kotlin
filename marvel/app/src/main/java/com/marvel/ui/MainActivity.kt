package com.marvel.ui

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.marvel.R
import com.marvel.manager.ResourcesManager
import com.marvel.manager.SharedPreferencesManager
import com.marvel.ui.character.CharacterFragment
import com.marvel.ui.comics.ComicsFragment
import com.marvel.ui.event.EventFragment
import com.marvel.ui.favorites.FavoritesActivity
import com.marvel.ui.qrcode.ScanQRCodeActivity
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private lateinit var navigation: BottomNavigationView
    private lateinit var buttonQRCode: ImageButton
    private lateinit var buttonFav: ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        unitUI()

        loadFragment(CharacterFragment())
    }

    private fun buttonQRCode() {
        buttonQRCode.setOnClickListener {
            val intent = Intent(this, ScanQRCodeActivity::class.java)
            startActivity(intent)
        }
    }

    private fun buttonFav() {
        buttonFav.setOnClickListener {
            val intent = Intent(this, FavoritesActivity::class.java)
            startActivity(intent)
        }
    }

    private fun unitUI() {
        navigation = findViewById(R.id.bottom_nav_bar)
        buttonQRCode = findViewById(R.id.action_qrcode)
        buttonFav = findViewById(R.id.action_fav)

        initBottomNavBar()
        buttonQRCode()
        buttonFav()
    }

    private fun initBottomNavBar() {

        navigation.selectedItemId = R.id.action_character

        navigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.action_comics -> loadFragment(ComicsFragment())

                R.id.action_character -> loadFragment(CharacterFragment())

                R.id.action_event -> loadFragment(EventFragment())
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

    override fun onBackPressed() {
        super.onBackPressed()
        if (supportFragmentManager.backStackEntryCount == 0) {

            finish()
        }
    }

}