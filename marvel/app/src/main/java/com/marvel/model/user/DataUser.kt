package com.marvel.model.user

import com.marvel.model.characters.Character

object DataUser {
    var listCharacterFav: ArrayList<Character> = ArrayList()

    //Characters
    fun addFavCharacter(items: Character) {
        if (!listCharacterFav.contains(items)) {
            listCharacterFav.add(items)

        }
    }

    fun removeFavCharacter(items: Character) {
        if (listCharacterFav.contains(items)) {
            listCharacterFav.removeAt(listCharacterFav.indexOf(items))
        }
    }

    fun isCharacterFav(items: Character?): Boolean {
        return listCharacterFav.contains(items)
    }
}