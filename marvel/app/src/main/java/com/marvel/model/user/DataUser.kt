package com.marvel.model.user

import com.marvel.model.characters.Character

object DataUser {
    var listCharacterFav : MutableList<Character> = ArrayList()

    //Characters
    fun addFavCharacter(items: Character?) {
        if (!listCharacterFav.contains(items)) {
             listCharacterFav.plus(items)

        }
    }

    fun removeFavCharacter(items: Character?) {
        if (listCharacterFav.contains(items)) {
            listCharacterFav.drop(listCharacterFav.indexOf(items))
        }
    }

    fun isCharacterFav(items: Character?): Boolean {
        return listCharacterFav.contains(items)
    }
}