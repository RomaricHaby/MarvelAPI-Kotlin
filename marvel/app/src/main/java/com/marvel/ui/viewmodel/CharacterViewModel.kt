package com.marvel.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marvel.model.characters.Character
import com.marvel.usecase.character.GetAllCharacterUseCase
import com.marvel.usecase.character.GetCharacterByNameUseCase
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {

    fun getAllCharacterFromAPI(): MutableLiveData<List<Character>?> {
        val characterList = MutableLiveData<List<Character>?>()
        viewModelScope.launch {
            val character = GetAllCharacterUseCase().execute().getOrThrow()
            val data = character?.dataCharacter?.results
            characterList.postValue(data)
        }
        return characterList
    }


    fun getSearchCharacterFromAPI(nameCharacter: String): MutableLiveData<List<Character>?> {
        val characterList = MutableLiveData<List<Character>?>()
        viewModelScope.launch {
            val character = GetCharacterByNameUseCase(nameCharacter).execute().getOrThrow()
            val data = character?.dataCharacter?.results
            characterList.postValue(data)
        }
        return characterList
    }
}