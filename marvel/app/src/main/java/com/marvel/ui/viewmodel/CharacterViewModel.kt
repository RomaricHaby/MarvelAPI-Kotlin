package com.marvel.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marvel.model.characters.Character
import com.marvel.model.comics.Comic
import com.marvel.model.series.Serie
import com.marvel.model.stories.Storie
import com.marvel.usecase.character.*
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {

    fun getAllCharacterFromAPI(): LiveData<List<Character>?> {
        val characterList = MutableLiveData<List<Character>?>()
        viewModelScope.launch {
            val character = GetAllCharactersUseCase().execute().getOrThrow()
            val data = character?.dataCharacters?.results
            characterList.postValue(data)
        }
        return characterList
    }

    fun getSearchCharacterFromAPI(nameCharacter: String): LiveData<List<Character>?> {
        val characterList = MutableLiveData<List<Character>?>()
        viewModelScope.launch {
            val character = GetCharacterByNameUseCase(nameCharacter).execute().getOrThrow()
            val data = character?.dataCharacters?.results
            characterList.postValue(data)
        }
        return characterList
    }

    fun getCharacterComicsFromAPI(id: String): LiveData<List<Comic>?> {
        val characterList = MutableLiveData<List<Comic>?>()
        viewModelScope.launch {
            val character = GetCharacterComicsUseCase(id).execute().getOrThrow()
            val data = character?.dataComics?.results
            characterList.postValue(data)
        }
        return characterList
    }

    fun getCharacterSeriesFromAPI(id: String): LiveData<List<Serie>?> {
        val characterList = MutableLiveData<List<Serie>?>()
        viewModelScope.launch {
            val character = GetCharacterSeriesUseCase(id).execute().getOrThrow()
            val data = character?.dataSeries?.results
            characterList.postValue(data)
        }
        return characterList
    }

    fun getCharacterStoriesFromAPI(id: String): LiveData<List<Storie>?> {
        val characterList = MutableLiveData<List<Storie>?>()
        viewModelScope.launch {
            val character = GetCharacterStoriesUseCase(id).execute().getOrThrow()
            val data = character?.data?.results
            characterList.postValue(data)
        }
        return characterList
    }
}