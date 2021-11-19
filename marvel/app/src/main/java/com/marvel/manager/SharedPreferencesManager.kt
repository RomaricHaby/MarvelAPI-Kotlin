package com.marvel.manager

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.marvel.model.character.Character
import com.marvel.model.user.DataUser

object SharedPreferencesManager {
    private const val CHARACTER_FAV: String = "CharacterFav"

    fun saveAllCharacter(context: Context) {
        val gson = Gson()
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(CHARACTER_FAV, 0)
        val editor = sharedPreferences.edit()

        editor.clear()

        for (character in DataUser.listCharacterFav) {
            val json = gson.toJson(character)
            editor.putString(character.id.toString(), json)
        }
        editor.apply()
    }

    fun loadAllCharacter(context: Context) {
        if (DataUser.listCharacterFav.isEmpty()) {
            val gson = Gson()
            val sharedPreferences: SharedPreferences =
                context.getSharedPreferences(CHARACTER_FAV, 0)
            val allEntries = sharedPreferences.all

            for ((key) in allEntries) {
                val json = sharedPreferences.getString(key, "")
                val character = gson.fromJson(json, Character::class.java)
                DataUser.listCharacterFav.add(character)
            }
        }
    }
}