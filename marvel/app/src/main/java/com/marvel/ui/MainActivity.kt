package com.marvel.ui

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.marvel.R
import com.marvel.ui.character.CharacterFragment
import com.marvel.ui.comic.ComicFragment
import com.marvel.ui.event.EventFragment
import com.marvel.ui.favorite.FavoriteActivity
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

        onButtonQRCodeClicked()
        onButtonFavClicked()

        loadFragment(CharacterFragment())
    }

    private fun unitUI() {
        navigation = findViewById(R.id.bottom_nav_bar)
        buttonQRCode = findViewById(R.id.action_qrcode)
        buttonFav = findViewById(R.id.action_fav)

        initBottomNavBar()
    }

    private fun onButtonQRCodeClicked() {
        buttonQRCode.setOnClickListener {
            val intent = Intent(this, ScanQRCodeActivity::class.java)
            startActivity(intent)
        }
    }

    private fun onButtonFavClicked() {
        buttonFav.setOnClickListener {
            val intent = Intent(this, FavoriteActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initBottomNavBar() {
        navigation.selectedItemId = R.id.action_character

        navigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.action_comics -> loadFragment(ComicFragment())

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