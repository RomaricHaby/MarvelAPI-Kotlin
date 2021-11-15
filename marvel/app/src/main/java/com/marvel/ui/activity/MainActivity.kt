package com.marvel.ui.activity

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.Gson
import com.marvel.R
import com.marvel.manager.ResourcesManager
import com.marvel.model.characters.Character
import com.marvel.model.user.DataUser
import com.marvel.ui.fragment.character.CharacterFragment
import com.marvel.ui.fragment.comics.ComicsFragment
import com.marvel.ui.fragment.event.EventFragment
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity(), CoroutineScope by MainScope() {
    private lateinit var navigation: BottomNavigationView
    private lateinit var buttonQRCode: ImageButton
    private lateinit var buttonFav: ImageButton

    companion object {
        private const val CHARACTER_FAV: String = "CharacterFav"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        unitUI()

        ResourcesManager.loadKeyAPI()

        loadCharacter()

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
        navigation.itemIconTintList = null
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
            //todo dialog demande de quitter l'app
            finish()
        }
    }

    //TODO voir ou save
    private fun saveCharacter() {
        val gson = Gson()
        val sharedPreferences: SharedPreferences = getSharedPreferences(CHARACTER_FAV, 0)
        val editor = sharedPreferences.edit()

        editor.clear()

        for (character in DataUser.listCharacterFav) {
            val json = gson.toJson(character)
            editor.putString(character.id.toString(), json)
        }
        editor.apply()
    }


    private fun loadCharacter() {
        val gson = Gson()
        val sharedPreferences: SharedPreferences = getSharedPreferences(CHARACTER_FAV, 0)
        val allEntries = sharedPreferences.all

        for ((key) in allEntries) {
            val json = sharedPreferences.getString(key, "")
            val character = gson.fromJson(json, Character::class.java)
            DataUser.listCharacterFav.add(character)
        }
    }


}